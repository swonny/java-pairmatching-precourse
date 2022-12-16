package repository;

import constant.Course;
import constant.Mission;
import pairmatching.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
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
        if (!hasPairs(course, mission)) {
            throw new NoSuchElementException("매칭 이력이 없습니다.");
        }
        return pairs.get(mission).stream()
                .filter(pair -> pair.getCourse().equals(course))
                .collect(Collectors.toList());
    }

    public static void clearPairs() {
        pairs.clear();
        pairs = new HashMap<>();
    }

    public static void addPairs(Mission mission, List<Pair> newPairs) {
        pairs.put(mission, newPairs);
    }

    public static boolean hasSamePair(Course course, List<Pair> pairs, Mission mission) {
        // TODO : 구현해보기
        return false;
    }
}
