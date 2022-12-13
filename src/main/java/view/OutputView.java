package view;

import constant.ExampleViewMessage;
import constant.MainMenu;
import pairmatching.Crew;
import pairmatching.Pair;

import java.util.List;
import java.util.stream.Collectors;

import static constant.ViewMessage.*;

public class OutputView {
    public static void printMainMenu() {
        print(SELECT_MENU);
        print(MainMenu.getWholeMenu());
    }

    public static void print(String value) {
        System.out.println(value);
    }

    public static void printException(Exception exception) {
        print("[ERROR] " + exception.getMessage());
    }

    public static void printPairMatchingInformation() {
        printNewLine();
        print(ExampleViewMessage.getExample());
    }

    public static void printPairs(List<Pair> pairs) {
        printNewLine();
        print(PAIR_MATCHING_RESULT);
        for (Pair pair : pairs) {
            print(pair.getCrews().stream().map(crew-> crew.getName()).collect(Collectors.joining(CREW_DELIMITER)));
        }
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printFinishedInitializing() {
        printNewLine();
        print(FINISHED_INITIALIZING);
        printNewLine();
    }

    public static void printAskingRetryMatching() {
        print(ASK_RETRY_MATCHING1);
        print(ASK_RETRY_MATCHING2);
        printNewLine();
    }
}
