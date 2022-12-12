package controller;

import constant.Course;
import constant.Level;
import repository.BackendPairRepository;
import repository.FrontendPairRepository;
import pairmatching.Pair;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PairMatchingController {
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    public void run() {
        List<String> input = getInputs();
        Course course = getCourse(input.get(COURSE_INDEX));
        Level level = getLevel(input.get(LEVEL_INDEX));
        String mission = input.get(MISSION_INDEX);
        List<Pair> pairs = getPairs(course, mission);
    }

    private List<Pair> getPairs(Course course, String mission) {
        if (Course.FRONTEND.equals(course)) {
            return FrontendPairRepository.getPairsOf(mission);
        }
        return BackendPairRepository.getPairsOf(mission);
    }

    private List<String> getInputs() {
        try {
            return splitInput(InputView.readPairInformation());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getInputs();
        }
    }

    private Course getCourse(String courseName) {
        try {
            return Course.getCourseByName(courseName);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getCourse(getInputs().get(COURSE_INDEX));
        }
    }

    private Level getLevel(String levelName) {
        try {
            return Level.getLevelByName(levelName);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getLevel(getInputs().get(LEVEL_INDEX));
        }
    }

    private List<String> splitInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("정확한 정보를 입력해주세요.");
        }
        return Arrays.asList(InputView.readPairInformation().split(", "));
    }

    public void pairMatching(Course course, Level level, String mission) {
        List<Pair> pairs = null;
        OutputView.printPairMatchingResult(pairs);
    }
}
