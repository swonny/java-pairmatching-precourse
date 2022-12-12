package view;

import camp.nextstep.edu.missionutils.Console;

import static constant.ViewMessage.MAIN_MENU_TITLE;

public class InputView {
    public static void read() {

    }

    public static String readMainMenu() {
        OutputView.print(MAIN_MENU_TITLE);
        return Console.readLine();
    }
}
