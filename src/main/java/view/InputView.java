package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readMainMenu() {
        OutputView.printMainMenu();
        return read();
    }

    private static String read() {
        return Console.readLine();
    }

    public static String readMatchingInformation() {
        OutputView.printReadingMatchingInforamtion();
        return read();
    }

    public static String readRematchCommand() {
        OutputView.printReadingRematchCommand();
        return read();
    }
}
