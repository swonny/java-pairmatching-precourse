package domain;

import contatants.Course;
import contatants.Level;

import java.util.HashMap;
import java.util.List;

public class FrontendPairRepository {
    private static final HashMap<Mission, List<Pair>> frontendPairs = new HashMap<>();

    public static void add(Mission mission, List<Pair> pairs) {
        frontendPairs.put(mission, pairs);
    }

    public static List<Pair> getPairByMission(Mission mission) {
        if (!frontendPairs.containsKey(mission)) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.");
        }
        return frontendPairs.get(mission);
    }

    public static void clear() {
        frontendPairs.clear();
    }

    public static boolean hasPair(Mission mission) {
        return frontendPairs.containsKey(mission);
    }

    public static boolean hasSamePair(Level level, List<Pair> pairs) {
        for (Mission mission : level.getMissionList()) {
            if (frontendPairs.containsKey(mission) && frontendPairs.get(mission).stream().anyMatch(pair -> pairs.contains(pair))) {
                return true;
            }
        }
        return false;
    }
}
