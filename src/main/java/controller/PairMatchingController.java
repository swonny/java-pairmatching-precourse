package controller;

import domain.*;
import contatants.Command;
import contatants.Course;
import contatants.Level;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingController {
    private static final int NONE = 0;
    private static final int MAX_TRIAL = 3;
    private static final int COURSE = 0;
    private static final int LEVEL = 1;
    private static final int MISSION = 2;
    private static final int NUMBER_OF_RESULT = 3;

    public static void start() {
        List<String> input = getInput();
        Level level = getLevel(input.get(LEVEL));
        Mission mission = getMission(input.get(MISSION));
        Course course = getCourse(input.get(COURSE));
        if (MissionPairRepository.hasPair(mission) && !willRepair()) {
            MainController.start();
        }
        List<Pair> pairs = getUniquePairs(level, course, mission);
        validateSize(pairs.size());
        addToMissionRepository(mission, course, pairs);
        OutputView.printPairMatchingResult(pairs);
    }

    private static List<String> getInput() {
        try {
            String input = InputView.readPairMatching();
            List<String> result = Arrays.stream(input.split(", ")).collect(Collectors.toList());
            validateResultSize(result.size());
            getLevel(result.get(LEVEL));
            getMission(result.get(MISSION));
            getCourse(result.get(COURSE));
            return result;
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getInput();
        }
    }

    private static void validateResultSize(int size) {
        if (size < NUMBER_OF_RESULT) {
            throw new IllegalArgumentException("세 개의 값 모두 입력하세요.");
        }
    }

    private static Course getCourse(String course) {
        return Course.getCourseByName(course);
    }

    private static Mission getMission(String mission) {
        return MissionRepository.getMissionByName(mission);
    }

    private static Level getLevel(String level) {
        return Level.getLevelByName(level);
    }

    private static boolean willRepair() {
        try {
            return Command.isRepair(InputView.askForRemakePair());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return willRepair();
        }
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

    private static void addToMissionRepository(Mission mission, Course course, List<Pair> pairs) {
        if (course.isFrontend()) {
            FrontendPairRepository.add(mission, pairs);
            return;
        }
        BackendPairRepository.add(mission, pairs);
    }
}
