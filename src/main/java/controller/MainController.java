package controller;

import constant.MainMenu;
import view.InputView;
import view.OutputView;

public class MainController {

    private final PairMatchingController pairMatchingController;
    private final PairSearchingController pairSearchingController;
    private final PairInitializingController pairInitializingController;

    public MainController() {
        this.pairMatchingController = new PairMatchingController();
        this.pairSearchingController = new PairSearchingController();
        this.pairInitializingController = new PairInitializingController();
    }
    public void run() {
        MainMenu selectedMenu = getSelectedMenu(InputView.readMainMenu());
        runMenu(selectedMenu);
    }

    private void runMenu(MainMenu selectedMenu) {
        if (MainMenu.QUIT.equals(selectedMenu)) {
            return;
        }
        if (MainMenu.FIRST.equals(selectedMenu)) {
            pairMatchingController.run();
        }
        if (MainMenu.SECOND.equals(selectedMenu)) {
            pairSearchingController.run();
        }
        if (MainMenu.THIRD.equals(selectedMenu)) {
            pairInitializingController.run();
        }
        run();
    }

    private MainMenu getSelectedMenu(String selectedMenu) {
        try {
            return MainMenu.getMenuByName(selectedMenu);
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception);
            return getSelectedMenu(InputView.readMainMenu());
        }
    }
}
