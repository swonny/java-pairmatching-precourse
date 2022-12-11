package controller;

import domain.Mission;
import domain.MissionPairRepository;
import domain.MissionRepository;
import domain.Pair;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PairMatchingController {

    private static final int COURSE = 0;
    private static final int LEVEL = 1;
    private static final int MISSION = 2;

    public static void start() {
        String userInput = read(InputView::readPairMatching);
        List<String> inputs = Arrays.stream(userInput.split(", ")).collect(Collectors.toList());
        // TODO : 미션 네임 변경
        List<Pair> pairs = PairMatcher.match(inputs.get(COURSE));
        MissionPairRepository.add(MissionRepository.getMissionByName(inputs.get(MISSION)), pairs);
        OutputView.printPairMatchingResult(pairs);
    }

    private static <T> T read(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputReader.get();
        }
    }
}
