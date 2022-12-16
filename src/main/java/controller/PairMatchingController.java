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
        List<Pair> pairs = getPairs(new PairGenerator());
        OutputView.printPairMatchingResult(pairs);
    }

    private List<Pair> getPairs(PairGenerator pairGenerator) {
        try {
            List<Enum> matchingInformation = getWholeInformation(InputView.readMatchingInformation());
            boolean rematchRequired = checkRematchRequirement(matchingInformation);
            if (!rematchRequired) {
                return getPairs(pairGenerator);
            }
            // TODO : 리턴값만 메소드로 분리해보기 너무 김
            return pairGenerator.generate(
                    (Course) matchingInformation.get(COURSE_NAME_INDEX),
                    (Level) matchingInformation.get(LEVEL_NAME_INDEX),
                    (Mission) matchingInformation.get(MISSION_NAME_INDEX)
            );
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getPairs(pairGenerator);
        }
    }

    private boolean checkRematchRequirement(List<Enum> matchingInformation) {
        // TODO : hasAlready() 등으로 분리하기
        if (PairRepository.hasPairs((Course) matchingInformation.get(COURSE_NAME_INDEX), (Mission) matchingInformation.get(MISSION_NAME_INDEX))) {
            return RematchCommand.WILL_REMATCH.equals(askRematch(InputView.readRematchCommand()));
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
