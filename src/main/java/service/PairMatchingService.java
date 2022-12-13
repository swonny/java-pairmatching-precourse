package service;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Course;
import constant.Level;
import constant.Mission;
import pairmatching.Crew;
import repository.CrewRepository;
import repository.PairMatchingRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatchingService {

    private static final int MAXIMUM_TRIAL = 3;

    public List<List<Crew>> makePairs(Course course, Level level, Mission mission) {
        for (int trial = 0; trial < MAXIMUM_TRIAL; trial++) {
            List<Crew> shuffledCrew = Randoms.shuffle(CrewRepository.get(course));
            List<List<Crew>> pairs = getNewPairs(shuffledCrew);
            if (PairMatchingRepository.hasUniquePairsOnly(course, mission, pairs)) {
                PairMatchingRepository.add(course, mission, pairs);
                return pairs;
            }
        }
        throw new IllegalArgumentException("매칭에 실패했습니다.");
    }

    private List<List<Crew>> getNewPairs(List<Crew> shuffledCrew) {
        List<List<Crew>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>());
        pairs.add(new ArrayList<>());
        while (shuffledCrew.size() > 1) {
            pairs.add(Arrays.asList(shuffledCrew.remove(0), shuffledCrew.remove(0)));
        }
        if (shuffledCrew.size() != 0) {
            pairs.get(pairs.size() - 1).add(shuffledCrew.remove(0));
        }
        return pairs;
    }
}
