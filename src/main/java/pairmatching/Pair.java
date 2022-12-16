package pairmatching;

import constant.Course;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private Course course;
    private List<Crew> crews;

    public Pair(Crew crew1, Crew crew2) {
        crews = new ArrayList<>();
        crews.add(crew1);
        crews.add(crew2);
        this.course = crew1.getCourse();
    }

    public List<Crew> crews() {
        return crews;
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public Course getCourse() {
        return course;
    }
}
