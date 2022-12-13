package controller;

import pairmatching.Pair;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PairSearchingController {
    public void run() {
        List<String> inputs = getInputs();
        // TODO : 정보 입력
        printPairs();
    }

    private List<String> getInputs() {
        try {
            return splitInput(InputView.readPairInformation());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getInputs();
        }
    }

    private List<String> splitInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("정확한 정보를 입력해주세요.");
        }
        return Arrays.asList(InputView.readPairInformation().split(", "));
    }

    private void printPairs() {
        List<Pair> pairs = getPairs();
        OutputView.printPairMatchingResult(pairs);
        // TODO : try-catch

    }

    private List<Pair> getPairs() {
        // TODO : 페어 조회하여 리턴
        return null;
    }
}
