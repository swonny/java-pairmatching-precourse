package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public static String readMainMenu() {
        OutputView.printMainMenu();
        return Console.readLine();
    }

    public static String readSelectingMission() {
        OutputView.printInputExample();
        return Console.readLine();
    }

    public static String readPairMatching() {
        OutputView.printInputExample();
        return Console.readLine();
    }

    public static String askForRemakePair() {
        OutputView.printAskingRemakePair();
        return Console.readLine();
    }
}
