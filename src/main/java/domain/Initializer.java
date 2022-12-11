package domain;

import view.OutputView;

public class Initializer {
    public static void init() {
        MissionPairRepository.clear();
        OutputView.printFinishedInit();
    }
}
