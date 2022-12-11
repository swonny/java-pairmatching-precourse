package controller;

import domain.Mission;
import domain.MissionPairRepository;
import domain.MissionRepository;
import domain.Pair;
import domain.utils.Command;
import domain.utils.Course;
import domain.utils.Level;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PairMatchingController {
    private static final int NONE = 0;
    private static final int MAX_TRIAL = 3;
    private static final int COURSE = 0;
    private static final int LEVEL = 1;
    private static final int MISSION = 2;

    public static void start() {
        List<String> inputs = getInput();
        Level level = read(Level::getLevelByName, inputs.get(LEVEL));
        Mission mission = read(MissionRepository::getMissionByName, inputs.get(MISSION));
        Course course = read(Course::getCourseByName, inputs.get(COURSE));
        if (MissionPairRepository.hasPair(mission) && !willRepair()) {
            MainController.start();
        }
        List<Pair> pairs = getUniquePairs(level, course, mission);
        try {
            validateSize(pairs.size());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return;
        }
        addToMissionRepository(inputs.get(MISSION), pairs);
        OutputView.printPairMatchingResult(pairs);
    }

    private static boolean willRepair() {
        return read(Command::isRepair, InputView::askForRemakePair);
    }

    private static List<String> getInput() {
        String input = read(InputView::readPairMatching);
        return Arrays.stream(input.split(", ")).collect(Collectors.toList());
    }

    private static List<Pair> getUniquePairs(Level level, Course course, Mission mission) {
        if (!MissionPairRepository.hasPair(mission)) {
            return PairMatcher.match(course);
        }
        List<Pair> pairs = Collections.emptyList();
        for (int trial = 0; trial < MAX_TRIAL; trial++) {
            pairs = PairMatcher.match(course);
            if (!MissionPairRepository.hasSamePair(level, pairs)) {
                break;
            }
        }
        return pairs;
    }

    private static void validateSize(int size) {
        if (size == NONE) {
            throw new IllegalArgumentException("매칭 시도에 3번 실패했습니다.");
        }
    }

    private static void addToMissionRepository(String missionName, List<Pair> pairs) {
        try {
            MissionPairRepository.add(MissionRepository.getMissionByName(missionName), pairs);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            start();
        }
    }

    private static <T> T read(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputReader.get();
        }
    }

    private static <T, R> R read(Function<T, R> object, String input) {
        try {
            return object.apply((T) input);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return
        }
    }

    private static <T, R> R read(Function<T, R> object, Supplier<T> input) {
        try {
            return object.apply(input.get());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return object.apply(input.get());
        }
    }

}
