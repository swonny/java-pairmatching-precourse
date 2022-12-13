package controller;

import constant.Course;
import constant.Level;
import constant.Mission;
import constant.RetryMatching;
import pairmatching.Crew;
import pairmatching.PairMatchingService;
import repository.PairRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingController {
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    public static void run() {
        List<Enum> inputs = getInputs(InputView.readPairMatchingInformation());
        Course course = (Course) inputs.get(COURSE_INDEX);
        Level level = (Level) inputs.get(LEVEL_INDEX);
        Mission mission = (Mission) inputs.get(MISSION_INDEX);
        if (PairRepository.hasPairOf(mission) && !willRetryMatching(InputView.askRetryMatching())) {
            run();
            return;
        }
        List<List<Crew>> pairs = getPairs(course, level, mission);
        OutputView.printPairs(pairs);
    }

    private static boolean willRetryMatching(String input) {
        try {
            return RetryMatching.RETRY.equals(RetryMatching.getRetryCommand(input));
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return willRetryMatching(InputView.askRetryMatching());
        }
    }

    private static List<List<Crew>> getPairs(Course course, Level level, Mission mission) {
        try {
            return PairMatchingService.getNewPairs(course, level, mission);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return Collections.emptyList();
        }
    }

    private static List<Enum> getInputs(String input) {
        try {
            List<String> splitInput = split(input);
            Course course = Course.getCourseByName(splitInput.get(COURSE_INDEX));
            Level level = Level.getLevelByName(splitInput.get(LEVEL_INDEX));
            Mission mission = Mission.getMissionByName(splitInput.get(MISSION_INDEX));
            return Arrays.asList(course, level, mission);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getInputs(InputView.readPairMatchingInformation());
        }
    }

    private static List<String> split(String input) {
        return Arrays.stream(input.split(", ")).collect(Collectors.toList());
    }
}
