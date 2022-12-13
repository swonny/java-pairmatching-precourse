package controller;

import repository.PairMatchingRepository;
import view.OutputView;

public class PairInitializingController {
    public static void run() {
        PairMatchingRepository.initialize();
        OutputView.printFinishedInitializing();
    }
}
