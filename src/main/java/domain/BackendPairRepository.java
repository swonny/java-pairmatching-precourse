package domain;

import contatants.Course;
import contatants.Level;

import java.util.HashMap;
import java.util.List;

public class BackendPairRepository {
    private static final HashMap<Mission, List<Pair>> backendPairs = new HashMap<>();

    public static void add(Mission mission, List<Pair> pairs) {
        backendPairs.put(mission, pairs);
    }

    public static List<Pair> getPairByMission(Mission mission) {
        if (!backendPairs.containsKey(mission)) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.");
        }
        return backendPairs.get(mission);
    }

    public static void clear() {
        backendPairs.clear();
    }

    public static boolean hasPairs(Mission mission) {
        return backendPairs.containsKey(mission);
    }

    public static boolean hasSamePair(Level level, List<Pair> pairs) {
        for (Mission mission : level.getMissionList()) {
            if (backendPairs.containsKey(mission) && backendPairs.get(mission).stream().anyMatch(pair -> pairs.contains(pair))) {
                return true;
            }
        }
        return false;
    }
}
