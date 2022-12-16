package view;

import constant.MainMenu;
import pairmatching.Pair;

import java.util.List;
import java.util.stream.Collectors;

import static constant.ViewMessage.*;

public class OutputView {
    private static void println(String value) {
        System.out.println(value);
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static String integerToString(int numericValue) {
        return Integer.toString(numericValue);
    }

    private static void print(String value) {
        System.out.print(value);
    }

    private static void printFormat(String value, String formatValue) {
        System.out.printf(value, formatValue);
    }

    public static void printExceptionMessage(Exception exception) {
        println("[ERROR] " + exception.getMessage());
    }

    public static void printInfo(String value) {
        println("[INFO] " + value);
    }

    public static void printMainMenu() {
        println(SELECT_MENU);
        println(MainMenu.getWholeMenu());
    }

    public static void printWholeInformation() {
        println(INFORMATION_DELIMITER);
        println(COURSE_INFORMATION);
        println(MISSION_TITLE);
        println(MISSION1);
        println(MISSION2);
        println(MISSION3);
        println(MISSION4);
        println(MISSION5);
        println(INFORMATION_DELIMITER);
    }

    public static void printReadingMatchingInforamtion() {
        println(READ_MATCHING_INFORMATION);
        println(MATCHING_INFORMATION_EXAMPLE);
    }

    public static void printPairMatchingResult(List<Pair> pairs) {
        println(PAIR_MATCHING_RESULT);
        pairs.stream()
                .map(pair -> pair.crews())
                .map(crews -> crews.stream().map(crew -> crew.getName()).collect(Collectors.joining(PAIR_DELIMITER)))
                .forEach(pair -> println(pair));
    }

    public static void printReadingRematchCommand() {
        println(READ_REMATCH_COMMAND);
    }

    public static void printFinishedInitializing() {
        println(FINISHED_INITIALIZING);
    }
}
