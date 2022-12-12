package view;

import constant.ExampleViewMessage;
import pairmatching.Pair;

import java.util.List;
import java.util.stream.Collectors;

import static constant.ViewMessage.*;

public class OutputView {

    public static void print(String value) {
        System.out.println(value);
    }

    public static void printInformationForInput() {
        print(ExampleViewMessage.getExample());
    }

    public static void printPairMatchingResult(List<Pair> pairs) {
        print(NEW_LINE);
        print(PAIR_MATCHING_RESULT);
        pairs.stream()
                .map(pair -> pair.getCrews()
                        .stream().map(crew -> crew.getName()).collect(Collectors.joining(PAIR_DELIMITER)))
                .forEach(OutputView::print);
        print(NEW_LINE);
    }
}
