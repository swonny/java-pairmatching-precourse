package domain;

import java.util.HashMap;
import java.util.List;

public class MissionPairRepository {
    private static final HashMap<Mission, List<Pair>> missionsMatchingPairs = new HashMap<>();

    public static void add(Mission mission, List<Pair> pairs) {
        missionsMatchingPairs.put(mission, pairs);
    }

    public static List<Pair> getPairByMission(Mission mission) {
        if (!missionsMatchingPairs.containsKey(mission)) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.");
        }
        return missionsMatchingPairs.get(mission);
    }
}
