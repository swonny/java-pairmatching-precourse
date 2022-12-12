package controller;

import constant.Course;
import constant.Level;
import pairmatching.Pair;
import view.OutputView;

import java.util.List;

public class PairMatchingController {
    public void run() {
        OutputView.printInformationForInput();
        // TODO : 정보 입력
    }

    public void pairMatching(Course course, Level level, String mission) {
        List<Pair> pairs = null;
        OutputView.printPairMatchingResult(pairs);
    }
}
