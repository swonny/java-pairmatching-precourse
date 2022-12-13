package repository;

import constant.Course;
import constant.Mission;
import pairmatching.Pair;

import java.util.HashMap;
import java.util.List;

public class PairRepository {
    private static final HashMap<Mission, List<Pair>> frontendPairs = new HashMap<>();
    private static final HashMap<Mission, List<Pair>> backendPairs = new HashMap<>();


    public static void add(Course course, Mission mission, List<Pair> pairs) {
        getCoursePairs(course).put(mission, pairs);
    }

    public static boolean hasPairs(Course course, Mission mission) {
        return getCoursePairs(course).containsKey(mission);
    }

    private static HashMap<Mission, List<Pair>> getCoursePairs(Course course) {
        if (Course.FRONTEND.equals(course)) {
            return frontendPairs;
        }
        return backendPairs;
    }
}
