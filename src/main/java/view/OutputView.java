package view;

import view.uitils.MainMenu;

public class OutputView {

    private static final String ERROR = "[ERROR] ";

    public static void printMainMenu() {
        print(MainMenu.getWholeMenu());
    }

    private static void print(String value) {
        System.out.println(value);
    }

    public static void printErrorMessage(String errorMessage) {
        print(ERROR + errorMessage);
    }
}
