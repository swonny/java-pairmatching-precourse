package domain;

import java.util.HashMap;
import java.util.List;

public class MissionPairRepository {
    private static final HashMap<Mission, List<Pair>> missionsMatchingPairs = new HashMap<>();

    public static void add(Mission mission, List<Pair> pairs) {
        missionsMatchingPairs.put(mission, pairs);
    }
}
