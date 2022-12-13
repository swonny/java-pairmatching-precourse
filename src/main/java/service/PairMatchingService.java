package service;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Course;
import constant.Level;
import constant.Mission;
import pairmatching.Crew;
import pairmatching.Pair;
import repository.CrewRepository;
import repository.PairRepository;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingService {

    private static final int MAXIMUM_TRIAL = 3;

    public List<Pair> makePairs(Course course, Level level, Mission mission) {
        List<Crew> shuffledCrew = Randoms.shuffle(CrewRepository.get(course));
        List<Pair> pairs = getNewPairs(shuffledCrew);
        PairRepository.add(course, mission, pairs);
        return pairs;
        // TODO : 중복 검사 및 재시도 3번 구현
//        for (int trial = 0; trial < MAXIMUM_TRIAL; trial++) {
//            try {
//                return getPairs();
//            } catch (IllegalArgumentException exception) {
//                OutputView.printException(exception);
//            }
//        }
    }

    private List<Pair> getNewPairs(List<Crew> shuffledCrew) {
        List<Pair> pairs = new ArrayList<>();
        while (shuffledCrew.size() > 1) {
            pairs.add(new Pair(Arrays.asList(shuffledCrew.remove(0), shuffledCrew.remove(0))));
        }
        if (shuffledCrew.size() != 0) {
            pairs.get(pairs.size() - 1).add(shuffledCrew.remove(0));
        }
        return pairs;
    }

//    private List<Pair> getPairs() {
//
//    }
}
