package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Course;
import constant.Level;
import constant.Mission;
import repository.CrewRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatchingService {

    public static List<List<Crew>> getNewPairs(Course course, Level level, Mission mission) {
        // TODO : 중복 검사
        List<Crew> crews = CrewRepository.crews(course);
        List<Crew> shuffledCrew = Randoms.shuffle(crews);
        List<List<Crew>> pairs = getPairs(shuffledCrew);
        return pairs;
    }

    private static List<List<Crew>> getPairs(List<Crew> shuffledCrew) {
        List<List<Crew>> pairs = new ArrayList<>();
        while (shuffledCrew.size() > 1) {
            pairs.add(Arrays.asList(
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
