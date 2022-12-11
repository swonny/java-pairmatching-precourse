package domain;

import contatants.Level;

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

    public static void clear() {
        missionsMatchingPairs.clear();
    }

    public static boolean hasPair(Mission mission) {
        return missionsMatchingPairs.containsKey(mission);
    }

    public static boolean hasSamePair(Level level, List<Pair> pairs) {
        for (Mission mission : level.getMissionList()) {
            if (missionsMatchingPairs.containsKey(mission) && missionsMatchingPairs.get(mission).stream().anyMatch(pair -> pairs.contains(pair))) {
                return true;
            }
        }
        return false;
    }
}
