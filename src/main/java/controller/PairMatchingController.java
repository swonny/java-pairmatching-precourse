package controller;

import constant.Course;
import constant.Level;
import constant.Mission;
import constant.RematchCommand;
import pairmatching.Pair;
import pairmatching.PairGenerator;
import repository.PairRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatchingController {
    private static final String INFORMATION_SPLIT_DELIMITER = ", ";
    private static final int INFORMATION_SIZE = 3;
    private static final int COURSE_NAME_INDEX = 0;
    private static final int LEVEL_NAME_INDEX = 1;
    private static final int MISSION_NAME_INDEX = 2;

    public void run() {
        OutputView.printWholeInformation();
        List<Enum> matchingInformation = getWholeInformation(InputView.readMatchingInformation());
        Course course = (Course) matchingInformation.get(COURSE_NAME_INDEX);
        Level level = (Level) matchingInformation.get(LEVEL_NAME_INDEX);
        Mission mission = (Mission) matchingInformation.get(MISSION_NAME_INDEX);
        boolean newInformationRequired = checkRematchRequirement(course, mission);
        if (newInformationRequired) {
            // TODO : matchingInformation만 반복되게구현
            run();
        }
        List<Pair> pairs = getPairs(new PairGenerator(), course, mission);
        OutputView.printPairMatchingResult(pairs);
    }

    private List<Pair> getPairs(PairGenerator pairGenerator, Course course, Mission mission) {
        try {
            return pairGenerator.generate(course, mission);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getPairs(pairGenerator, course, mission);
        }
    }

    private boolean checkRematchRequirement(Course course, Mission mission) {
        if (PairRepository.hasPairs(course, mission)) {
            return RematchCommand.WILL_NOT_REMATCH.equals(askRematch(InputView.readRematchCommand()));
        }
        return false;
    }

    private RematchCommand askRematch(String rematchCommand) {
        try {
            return RematchCommand.getRematchCommandByName(rematchCommand);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return askRematch(InputView.readRematchCommand());
        }
    }

    private List<Enum> getWholeInformation(String input) {
        try {
            List<Enum> informationResult = new ArrayList<>();
            List<String> matchingInformation = getSplitInformation(input);
            informationResult.add(getCourse(matchingInformation));
            informationResult.add(getLevel(matchingInformation));
            informationResult.add(getMission(matchingInformation));
            return informationResult;
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getWholeInformation(InputView.readMatchingInformation());
        }
    }

    private Mission getMission(List<String> matchingInformation) {
        // TODO : 잘못된 레벨의 미션 선택 유효성 검사 추가하기
        return Mission.getMissionByName(matchingInformation.get(MISSION_NAME_INDEX));
    }

    private Level getLevel(List<String> matchingInformation) {
        return Level.getLevelByName(matchingInformation.get(LEVEL_NAME_INDEX));
    }

    private Course getCourse(List<String> matchingInformation) {
        return Course.getCourseByName(matchingInformation.get(COURSE_NAME_INDEX));
    }

    private List<String> getSplitInformation(String matchingInformation) {
        List<String> splitInformation = Arrays.asList(matchingInformation.split(INFORMATION_SPLIT_DELIMITER));
        validateSplitInformation(splitInformation);
        return splitInformation;
    }

    private void validateSplitInformation(List<String> splitInformation) {
        if (splitInformation.size() < INFORMATION_SIZE) {
            throw new IllegalArgumentException("과정, 레벨, 미션 모두 입력해주세요.");
        }
    }
}
