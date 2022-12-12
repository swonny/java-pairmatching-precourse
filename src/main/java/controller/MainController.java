package controller;

import constant.MainMenu;
import service.PairMatchingService;
import view.InputView;
import view.OutputView;

public class MainController {
    private PairMatchingController pairMatchingController;
    private PairSearchingController pairSearchingController;
    private PairMatchingService pairMatchingService;
    private PairInitializingController pairInitializingController;

    public MainController() {
        pairMatchingController = new PairMatchingController();
        pairSearchingController = new PairSearchingController();
        pairInitializingController = new PairInitializingController();
        pairMatchingService = new PairMatchingService();
    }

    public void run() {
        OutputView.print(MainMenu.getWholeMenu());
        // TODO : try-catch 필요
        MainMenu selectedMenu = MainMenu.getMenu(InputView.readMainMenu());
        select(selectedMenu);
    }

    public void select(MainMenu selection) {
        if (MainMenu.FIRST.equals(selection)) {
            pairMatchingController.run();
        }
        if (MainMenu.SECOND.equals(selection)) {
            pairSearchingController.run();
        }
        if (MainMenu.THIRD.equals(selection)) {
            pairInitializingController.run();
        }
    }
}
