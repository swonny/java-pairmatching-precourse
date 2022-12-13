package repository;

import constant.Course;
import constant.Mission;
import pairmatching.Crew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairRepository {
    private static final HashMap<Mission, List<List<Crew>>> frontendPairs = new HashMap<>();
    private static final HashMap<Mission, List<List<Crew>>> backendPairs = new HashMap<>();

    public static boolean hasPairsOf(Course course, Mission mission) {
        return getPairsOf(course).containsKey(mission);
    }

    public static List<List<Crew>> pairs(Course course, Mission mission) {
        if (getPairsOf(course).containsKey(mission)) {
            return getPairsOf(course).get(mission);
        }
        throw new IllegalArgumentException("매칭 이력이 없습니다.");
    }

    public static void initialize() {
        frontendPairs.clear();
        backendPairs.clear();
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

    public static boolean hasAnySamePairs(Course course, Mission mission, List<List<Crew>> pairs) {
        List<Mission> sameLevelMissions = mission.getSameLevelMissions();
        List<List<Crew>> sameLevelPairs = new ArrayList<>();
        for (Mission sameLevelMission : sameLevelMissions) {
            if (hasPairsOf(course, sameLevelMission)) {
                sameLevelPairs.addAll(pairs(course, sameLevelMission));
            }
        }
        for (List<Crew> pair : sameLevelPairs) {
            if (pairs.contains(pair)) {
                System.out.println(pairs);
                System.out.println(pair);

                return true;
            }
        }
        return false;
    }
}
