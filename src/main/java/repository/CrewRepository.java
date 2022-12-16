package repository;

import constant.Course;
import pairmatching.Crew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    static private List<Crew> crews = new ArrayList<>();

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static List<Crew> crews() {
        return Collections.unmodifiableList(crews);
    }

    public static List<Crew> getCrew(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .collect(Collectors.toList());
    }

    public static List<String> getCrewNames() {
        return crews().stream()
                .map(crew -> crew.getName())
                .collect(Collectors.toList());
    }

    public static Crew getCrewByName(String crewName) {
        return crews.stream()
                .filter(crew -> crew.getName().equals(crewName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("찾는 크루가 없습니다."));
    }
}
