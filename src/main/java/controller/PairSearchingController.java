package controller;

import constant.Course;
import constant.Level;
import constant.Mission;
import pairmatching.Crew;
import repository.PairRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairSearchingController {
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    public static void run() {
        List<Enum> inputs = getInputs(InputView.readPairMatchingInformation());
        Course course = (Course) inputs.get(COURSE_INDEX);
        Mission mission = (Mission) inputs.get(MISSION_INDEX);
        printPairs(course, mission);
    }

    private static void printPairs(Course course, Mission mission) {
        try {
            OutputView.printPairs(PairRepository.pairs(course, mission));
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
        }
    }

    private static List<Enum> getInputs(String input) {
        try {
            List<String> splitInput = split(input);
            Course course = Course.getCourseByName(splitInput.get(COURSE_INDEX));
            Mission mission = Mission.getMissionByName(splitInput.get(MISSION_INDEX));
            return Arrays.asList(course, Level.LEVEL1, mission); // LEVEL1은 인덱스땐문에 하드코딩
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getInputs(InputView.readPairMatchingInformation());
        }
    }

    private static List<String> split(String input) {
        return Arrays.stream(input.split(", ")).collect(Collectors.toList());
    }
}
