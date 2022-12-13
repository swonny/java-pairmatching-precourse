package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readMainMenu() {
        OutputView.printMainMenu();
        return read();
    }

    public static String readPairMatchingInformation() {
        OutputView.printPairMatchingInformation();
        return read();
    }

    private static String read() {
        return Console.readLine();
    }

    public static String askRetryMatching() {
        OutputView.printAskingRetryMatching();
        return null;
    }
}
