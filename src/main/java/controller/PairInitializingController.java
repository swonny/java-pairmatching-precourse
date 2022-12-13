package controller;

import repository.PairRepository;
import view.OutputView;

public class PairInitializingController {
    public static void run() {
        PairRepository.initialize();
        OutputView.printFinishedInitializing();
    }
}
