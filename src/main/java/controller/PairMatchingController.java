package controller;

import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class PairMatchingController {

    public static void start() {
        String userInput = read(InputView::readPairMatching);
        // TODO: 페어매칭 진행
        // TODO : String 반환값 변경
        List<List<String>> result = PairMatcher.match(userInput);
        OutputView.printPairMatchingResult(result);
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
