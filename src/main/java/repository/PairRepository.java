package repository;

import constant.Course;
import constant.Mission;
import pairmatching.Crew;

import java.util.HashMap;
import java.util.List;

public class PairRepository {
    private static final HashMap<Mission, List<List<Crew>>> frontendPairs = new HashMap<>();
    private static final HashMap<Mission, List<List<Crew>>> backendPairs = new HashMap<>();

    public static boolean hasPairOf(Course course, Mission mission) {
        return getPairsOf(course).containsKey(mission);
    }

    public static List<List<Crew>> pairs(Course course, Mission mission) {
        // TODO : [ERROR] 매칭 이력이 없습니다. 에러 발생시키기
        return null;
    }

    public static void initialize() {

    }

    public static void add(Course course, Mission mission, List<List<Crew>> pairs) {
        getPairsOf(course).put(mission, pairs);
    }

    private static HashMap<Mission, List<List<Crew>>> getPairsOf(Course course) {
        if (Course.FRONTEND.equals(course)) {
            return frontendPairs;
        }
        return backendPairs;
    }
}
