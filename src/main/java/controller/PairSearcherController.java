package controller;

import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class PairSearcherController {
    public static void start() {
        String userInput = read(InputView::readPairMatching);
        List<List<String>> result = PairSearcher.getPair(userInput);
        // TODO : 형식 변경
//        OutputView.printPairMatchingResult(result);
    }

    private static <T> T read(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputReader.get();
        }
    }
}
