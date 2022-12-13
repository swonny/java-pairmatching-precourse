package controller;

import constant.Course;
import constant.Level;
import constant.Mission;
import constant.RetryCommand;
import pairmatching.Crew;
import repository.PairMatchingRepository;
import service.PairMatchingService;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PairMatchingController {
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private PairMatchingService pairMatchingService;

    public PairMatchingController() {
        pairMatchingService = new PairMatchingService();
    }

    public void run() {
        List<Enum> input = getInputs(InputView.readPairInformation());
        Course course = (Course) input.get(COURSE_INDEX);
        Level level = (Level) input.get(LEVEL_INDEX);
        Mission mission = (Mission) input.get(MISSION_INDEX);
        if (PairMatchingRepository.hasPairs(course, mission) && RetryCommand.WILL_NOT_RETRY.equals(willMakeNewPair())) {
            run();
            return;
        }
        List<List<Crew>> pairs = getNewPairs(course, level, mission);
        OutputView.printPairMatchingResult(pairs);
    }

    private List<Enum> getInputs(String input) {
        try {
            List<String> inputs = splitInput(input);
            Course course = Course.getCourseByName(inputs.get(COURSE_INDEX));
            Level level = Level.getLevelByName(inputs.get(LEVEL_INDEX));
            Mission mission = Mission.getMissionByName(inputs.get(MISSION_INDEX));
            return Arrays.asList(course, level, mission);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getInputs(InputView.readPairInformation());
        }
    }

    private RetryCommand willMakeNewPair() {
        try {
            return RetryCommand.getRetryCommand(InputView.askForRetry());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return willMakeNewPair();
        }
    }

    private List<List<Crew>> getNewPairs(Course course, Level level, Mission mission) {
        try {
            return pairMatchingService.makePairs(course, level, mission);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getNewPairs(course, level, mission);
        }
    }

    private List<String> splitInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("정확한 정보를 입력해주세요.");
        }
        return Arrays.asList(input.split(", "));
    }
}
