package controller;

import constant.MainMenu;
import view.InputView;
import view.OutputView;

public class MainController {
    private PairMatchingController pairMatchingController;
    private PairSearchingController pairSearchingController;
    private PairInitializingController pairInitializingController;

    public MainController() {
        pairMatchingController = new PairMatchingController();
        pairSearchingController = new PairSearchingController();
        pairInitializingController = new PairInitializingController();
    }

    public void run() {
        OutputView.print(MainMenu.getWholeMenu());
        MainMenu selectedMenu = getMenu(InputView.readMainMenu());
        select(selectedMenu);
    }

    private MainMenu getMenu(String input) {
        try {
            return MainMenu.getMenu(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getMenu(InputView.readMainMenu());
        }
    }

    public void select(MainMenu selection) {
        if (MainMenu.QUIT.equals(selection)) {
            return;
        }
        if (MainMenu.FIRST.equals(selection)) {
            pairMatchingController.run();
        }
        if (MainMenu.SECOND.equals(selection)) {
            pairSearchingController.run();
        }
        if (MainMenu.THIRD.equals(selection)) {
            pairInitializingController.run();
        }
        run();
    }
}
