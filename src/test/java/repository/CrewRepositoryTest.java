package repository;

import constant.Course;
import org.junit.jupiter.api.Test;
import pairmatching.Application;
import pairmatching.Crew;
import view.BegginingInitializer;


class CrewRepositoryTest {
    @Test
    public void testInitializingRepository() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        Course course = Course.BACKEND;
        CrewRepository.crews().stream()
                .filter(crew -> course.equals(crew.getCourse()))
                .map(crew -> crew.getName() + " " + crew.getCourse())
                .forEach(System.out::println);
    }

    @Test
    public void testInitializingRepository_COURSE테스트() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        Course course = Course.BACKEND;
        Course course2 = Course.BACKEND;
        Crew crew = new Crew(Course.BACKEND, "승원");
        Crew crew2 = new Crew(Course.BACKEND, "승원");
//        CrewRepository.getCrew(course)
//                .stream().map(crew -> crew.getCourse())
//                .forEach(System.out::println);
//        System.out.println(CrewRepository.getCrew(course));
        System.out.print(course.equals(crew.getCourse()));
    }
}