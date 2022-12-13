package controller;

import constant.Course;
import constant.Mission;
import pairmatching.Crew;
import repository.PairMatchingRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PairSearchingController {
    private static final int COURSE_INDEX = 0;
    private static final int MISSION_INDEX = 2;

    public void run() {
        List<List<Crew>> pairs = getNewPairs(InputView.readPairInformation());
        OutputView.printPairMatchingResult(pairs);
    }

    private List<List<Crew>> getNewPairs(String input) {
        try {
            List<String> inputs = splitInput(input);
            Course course = Course.getCourseByName(inputs.get(COURSE_INDEX));
            Mission mission = Mission.getCourseByName(inputs.get(MISSION_INDEX));
            return PairMatchingRepository.pairs(course, mission);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getNewPairs(InputView.readPairInformation());
        }
    }

    private List<String> splitInput(String input) {
        validateInput(input);
        List<String> inputs = Arrays.asList(input.split(", "));
        validateInputSize(inputs);
        return inputs;
    }

    private void validateInputSize(List<String> inputs) {
        if (inputs.size() < 3) {
            throw new IllegalArgumentException("정확한 정보를 입력해주세요.");
        }
    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("정확한 정보를 입력해주세요.");
        }
    }
}
