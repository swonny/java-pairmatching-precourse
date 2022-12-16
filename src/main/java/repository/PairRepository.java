package repository;

import constant.Course;
import constant.Mission;
import pairmatching.Crew;
import pairmatching.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PairRepository {
    private static HashMap<Mission, List<Pair>> pairs = new HashMap<>();

    public static boolean hasPairs(Course course, Mission mission) {
        if (!pairs.containsKey(mission)) {
            return false;
        }
        return pairs.get(mission).stream()
                .anyMatch(pair -> pair.getCourse().equals(course));
    }

    public static List<Pair> pairs(Course course, Mission mission) {
        return pairs.get(mission).stream()
                .filter(pair -> pair.getCourse().equals(course))
                .collect(Collectors.toList());
    }

    public static void clearPairs() {
        // TODO : 로직 구현 필요
    }

    public static void addPairs(Mission mission, List<Pair> newPairs) {
        pairs.put(mission, newPairs);
    }
}
