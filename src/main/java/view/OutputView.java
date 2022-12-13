package view;

import constant.ExampleViewMessage;
import pairmatching.Crew;

import java.util.List;
import java.util.stream.Collectors;

import static constant.ViewMessage.*;

public class OutputView {

    private static final String ERROR = "[ERROR] ";

    public static void print(String value) {
        System.out.println(value);
    }

    public static void printInformationForInput() {
        print(ExampleViewMessage.getExample());
    }

    public static void printPairMatchingResult(List<List<Crew>> pairs) {
        printNewLine();
        pairs.stream()
                .map(crews -> crews.stream().map(crew -> crew.getName()).collect(Collectors.joining(PAIR_DELIMITER)))
                .forEach(OutputView::print);
        printNewLine();
    }

    public static void printException(Exception exception) {
        print(ERROR + exception.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printAskingForRetry() {
        printNewLine();
        print(ASK_RETRY_PAIR_MATCHING);
        print(RETRY_COMMAND);
        printNewLine();
    }

    public static void printFinishedInitializing() {
        printNewLine();
        print(FINISHED_INIT);
        printNewLine();
    }
}
