package repository;

import constant.Course;
import pairmatching.Crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewRepository {
    private static List<Crew> frontendCrews = new ArrayList<>();
    private static List<Crew> backendCrews = new ArrayList<>();

    public static void initializeCrews(Course course, List<Crew> crews) {
        getCrewOf(course).addAll(crews);
    }

    private static List<Crew> getCrewOf(Course course) {
        if (Course.FRONTEND.equals(course)) {
            return frontendCrews;
        }
        return backendCrews;
    }

    public static List<Crew> crews(Course course) {
        return Collections.unmodifiableList(getCrewOf(course));
    }
}
