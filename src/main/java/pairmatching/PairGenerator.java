package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import constant.Course;
import constant.Level;
import constant.Mission;
import repository.CrewRepository;
import repository.PairRepository;

import java.util.ArrayList;
import java.util.List;

public class PairGenerator {
    private static final int MAX_TRIAL = 3;

    public List<Pair> generate(Course course, Mission mission) {
        List<Crew> crews = CrewRepository.getCrew(course);
        List<Crew> shuffledCrews = Randoms.shuffle(crews);
        List<Pair> pairs;
        for (int trial = 0; trial < MAX_TRIAL; trial++) {
            pairs = getPairs(shuffledCrews);
            if (!pairs.isEmpty()) {
                PairRepository.addPairs(mission, pairs);
                return pairs;
            }
        }
        throw new IllegalArgumentException("페어 매칭 3회 시도 후 실패하였습니다.");
    }

    private List<Pair> getPairs(List<Crew> shuffledCrews) {
        List<Pair> pairs = new ArrayList<>();
        for (int crewIndex = 0; crewIndex < shuffledCrews.size() - 1; crewIndex++) {
            pairs.add(new Pair(shuffledCrews.get(crewIndex), shuffledCrews.get(crewIndex + 1)));
        }
        if (shuffledCrews.size() % 2 != 0) {
            pairs.get(pairs.size() - 1).addCrew(shuffledCrews.remove(0));
        }
        // TODO : 중복검사 후 중복되면 emptylist return하긴
        return pairs;
    }
}
