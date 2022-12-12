package controller;

import pairmatching.Pair;
import view.OutputView;

import java.util.List;

public class PairSearchingController {
    public void run() {
        OutputView.printInformationForInput();
        // TODO : 정보 입력
        printPairs();
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
