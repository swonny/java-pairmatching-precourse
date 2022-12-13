package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Course;
import constant.Level;
import constant.Mission;
import repository.CrewRepository;
import repository.PairMatchingRepository;
import repository.PairRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatchingService {

    public static List<Pair> makeNewPairs(Course course, Level level, Mission mission) {
        // TODO : 중복 검사
        List<Crew> crews = CrewRepository.crews(course);
        List<Pair> pairs = makePairs(course, mission, crews);
        PairMatchingRepository.add(course, mission, pairs);
        return pairs;
    }

    private static List<Pair> makePairs(Course course, Mission mission, List<Crew> crews) {
        for (int trial = 0; trial < 3; trial++) {
            List<Crew> shuffledCrew = Randoms.shuffle(crews);
            List<Pair> pairs = getPairs(shuffledCrew);
            if (!PairMatchingRepository.hasAnySamePairs(course, mission, pairs)) {
                PairRepository.add(pairs);
                return pairs;
            }
        }
        throw new IllegalArgumentException("3번 매칭에 실패하였습니다.");
    }

    private static List<Pair> getPairs(List<Crew> shuffledCrew) {

        List<Pair> pairs = new ArrayList<>();
        while (shuffledCrew.size() > 1) {
            pairs.add(new Pair(
                    shuffledCrew.remove(0),
                    shuffledCrew.remove(0)
            ));
        }
        if (shuffledCrew.size() > 0) {
            pairs.get(pairs.size() - 1).add(shuffledCrew.remove(0));
        }
        return pairs;
    }
}
