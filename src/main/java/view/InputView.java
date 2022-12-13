package view;

import camp.nextstep.edu.missionutils.Console;

import static constant.ViewMessage.MAIN_MENU_TITLE;

public class InputView {
    public static String read() {
        return Console.readLine();
    }

    public static String readMainMenu() {
        OutputView.print(MAIN_MENU_TITLE);
        return read();
    }

    public static String readPairInformation() {
        OutputView.printInformationForInput();
        return read();
    }

    public static String askForRetry() {
        OutputView.printAskingForRetry();
        return read();
    }
}
