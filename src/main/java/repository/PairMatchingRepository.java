package repository;

import constant.Course;
import constant.Mission;
import pairmatching.Crew;
import pairmatching.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairMatchingRepository {
    private static final HashMap<Mission, List<Pair>> frontendPairs = new HashMap<>();
    private static final HashMap<Mission, List<Pair>> backendPairs = new HashMap<>();

    public static boolean hasPairsOf(Course course, Mission mission) {
        return getPairsOf(course).containsKey(mission);
    }

    public static List<Pair> pairs(Course course, Mission mission) {
        if (getPairsOf(course).containsKey(mission)) {
            return getPairsOf(course).get(mission);
        }
        throw new IllegalArgumentException("매칭 이력이 없습니다.");
    }

    public static void initialize() {
        frontendPairs.clear();
        backendPairs.clear();
    }

    public static void add(Course course, Mission mission, List<Pair> pairs) {
        getPairsOf(course).put(mission, pairs);
    }

    private static HashMap<Mission, List<Pair>> getPairsOf(Course course) {
        if (Course.FRONTEND.equals(course)) {
            return frontendPairs;
        }
        return backendPairs;
    }

    public static boolean hasAnySamePairs(Course course, Mission mission, List<Pair> pairs) {
        List<Mission> sameLevelMissions = mission.getSameLevelMissions();
        List<Pair> sameLevelPairs = new ArrayList<>();
        // 같은 레벨 미션의 페어 모으기
        for (Mission sameLevelMission : sameLevelMissions) {
            if (hasPairsOf(course, sameLevelMission)) {
                sameLevelPairs.addAll(pairs(course, sameLevelMission));
            }
        }
        // 같은 페어 검사
        for (Pair pair : sameLevelPairs) {
            if (pairs.stream().anyMatch(newPair -> newPair.equals(pair))) {
                return true;
            }
        }
        return false;
    }
}
