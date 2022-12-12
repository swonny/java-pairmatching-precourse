package controller;

import domain.Mission;
import domain.MissionPairRepository;
import domain.MissionRepository;
import domain.Pair;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PairSearcherController {
    private static final int MISSION = 2;

    public static void start() {
        String userInput = read(InputView::readSelectingMission);
        List<String> inputs = Arrays.stream(userInput.split(", ")).collect(Collectors.toList());
        List<Pair> result = getPair(getMission(inputs.get(MISSION)));
        OutputView.printPairMatchingResult(result);
    }

    private static List<Pair> getPair(Mission mission) {
        List<Pair> pairs = Collections.emptyList();
        try {
            pairs = MissionPairRepository.getPairByMission(mission);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            start();
        }
        return pairs;
    }

    private static Mission getMission(String missionName) {
        try {
            return MissionRepository.getMissionByName(missionName);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            start();
            return getMission(missionName);
        }
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
