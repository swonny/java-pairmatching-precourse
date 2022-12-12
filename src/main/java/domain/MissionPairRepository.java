package domain;

import contatants.Course;
import contatants.Level;

import java.util.HashMap;
import java.util.List;

public class MissionPairRepository {
    private static final BackendPairRepository backendPairRepository;
    private static final HashMap<Mission, List<Pair>> BackendPairs = new HashMap<>();

    public static void add(Mission mission, Course course, List<Pair> pairs) {
        frontendPairs.put(mission, pairs);
    }

    public static List<Pair> getPairByMision(Mission mission) {
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
