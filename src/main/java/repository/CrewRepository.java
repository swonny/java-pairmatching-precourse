package repository;

import constant.Course;
import pairmatching.Crew;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CrewRepository {
    private static HashMap<Course, List<Crew>> crews = new HashMap<>();

    public static void initializeCrews(Course course, List<Crew> crews) {
        CrewRepository.crews.put(course, Collections.unmodifiableList(crews));
    }

    public static List<Crew> get(Course course) {
        return crews.get(course);
    }
}
