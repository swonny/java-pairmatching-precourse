package repository;

import constant.Course;
import constant.Mission;
import pairmatching.Crew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingRepository {
    private static final HashMap<Mission, List<List<Crew>>> frontendPairs = new HashMap<>();
    private static final HashMap<Mission, List<List<Crew>>> backendPairs = new HashMap<>();

    public static void add(Course course, Mission mission, List<List<Crew>> pairs) {
        getCoursePairs(course).put(mission, pairs);
    }

    public static boolean hasPairs(Course course, Mission mission) {
        return getCoursePairs(course).containsKey(mission);
    }

    private static HashMap<Mission, List<List<Crew>>> getCoursePairs(Course course) {
        if (Course.FRONTEND.equals(course)) {
            return frontendPairs;
        }
        return backendPairs;
    }

    public static List<List<Crew>> pairs(Course course, Mission mission) {
        if (!getCoursePairs(course).containsKey(mission)) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.");
        }
        return getCoursePairs(course).get(mission);
    }

    public static void initialize() {
        frontendPairs.clear();
        backendPairs.clear();
    }

    public static boolean hasUniquePairsOnly(Course course, Mission mission, List<List<Crew>> pairs) {
        List<Mission> sameLevelMissions = getSameLevelMissions(mission);
        List<List<Crew>> sameLevelPairs = new ArrayList<>();
        for (Mission sameLevelMission : sameLevelMissions) {
            if (hasPairs(course, sameLevelMission)) {
                getCoursePairs(course).get(sameLevelMission).stream()
                        .forEach(pair -> sameLevelPairs.add(pair));
            }
        }
        return sameLevelPairs.stream().anyMatch(pair -> pairs.contains(pair));
    }

    private static List<Mission> getSameLevelMissions(Mission mission) {
        return mission.getSameLevelMissions();
    }
}
