package controller;

import domain.Mission;
import domain.MissionPairRepository;
import domain.Pair;
import view.OutputView;

import java.util.List;

public class PairSearcher {
    public static List<Pair> getPair(Mission mission) throws IllegalArgumentException {
        return MissionPairRepository.getPairByMission(mission);
    }
}
