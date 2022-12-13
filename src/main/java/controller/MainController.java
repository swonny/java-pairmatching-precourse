package controller;

import constant.MainMenu;
import view.InputView;
import view.OutputView;

public class MainController {

    public void run() {
        MainMenu selection = getSelectedMenu(InputView.readMainMenu());
        select(selection);
    }

    private void select(MainMenu selection) {
        if (MainMenu.QUIT.equals(selection)) {
            return;
        }
        if (MainMenu.FIRST.equals(selection)) {
            PairMatchingController.run();
        }
        if (MainMenu.SECOND.equals(selection)) {
            PairSearchingController.run();
        }
        if (MainMenu.THIRD.equals(selection)) {
            PairInitializingController.run();
        }
        run();
    }

    private MainMenu getSelectedMenu(String input) {
        try {
            return MainMenu.getMenuByName(input);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return getSelectedMenu(InputView.readMainMenu());
        }
    }
}
