package controller;

import view.InputView;
import view.OutputView;
import view.uitils.MainMenu;

import java.util.function.Function;
import java.util.function.Supplier;

public class MainController {
    public static void start() {
        String selection = "";
        while (!MainMenu.isQuit(selection)) {
            selection = read(InputView::readMainMenu);
        }
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
