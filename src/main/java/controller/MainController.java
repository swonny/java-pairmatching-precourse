package controller;

import domain.MissionPairRepository;
import view.InputView;
import view.OutputView;
import contatants.MainMenu;

import java.util.function.Supplier;

public class MainController {
    public static void start() {
        String selection = "";
        while (!MainMenu.isQuit(selection)) {
            selection = read(InputView::readMainMenu);
            runMenu(selection);
        }
    }

    private static void runMenu(String selection) {
        try {
            if (MainMenu.FIRST.equals(selection)) {
                PairMatchingController.start();
            }
            if (MainMenu.SECOND.equals(selection)) {
                PairSearcherController.start();
            }
            if (MainMenu.THIRD.equals(selection)) {
                init();
            }
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            start();
        }
    }

    private static void init() {
        MissionPairRepository.clear();
        OutputView.printFinishedInit();
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
