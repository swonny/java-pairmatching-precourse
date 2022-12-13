package repository;

import constant.Course;
import constant.Mission;
import org.junit.jupiter.api.Test;
import pairmatching.Crew;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PairRepositoryTest {
    @Test
    public void testRepository() {
        List<Crew> pair1 = Arrays.asList(
                new Crew(Course.BACKEND, "tmd"),
                new Crew(Course.BACKEND, "tmd")
        );
        List<Crew> pair2 = Arrays.asList(
                new Crew(Course.BACKEND, "tmd"),
                new Crew(Course.BACKEND, "tmd")
        );
        List<List<Crew>> pairs1 = Arrays.asList(pair1);
        List<List<Crew>> pairs2 = Arrays.asList(pair2);

        PairRepository.add(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1));
        System.out.println(PairRepository.hasAnySamePairs(Course.BACKEND, Mission.CAR_RACING, pairs1));
        System.out.println(PairRepository.hasAnySamePairs(Course.BACKEND, Mission.CAR_RACING, pairs2));
    }

    @Test
    public void testHasPairOf() {
        List<Crew> pair1 = Arrays.asList(
                new Crew(Course.BACKEND, "tmd"),
                new Crew(Course.BACKEND, "tmd")
        );
        List<Crew> pair2 = Arrays.asList(
                new Crew(Course.BACKEND, "tmd"),
                new Crew(Course.BACKEND, "tmd")
        );
        PairRepository.add(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1));
        System.out.println(PairRepository.hasPairsOf(Course.BACKEND, Mission.CAR_RACING));

    }

    @Test
    public void testCourse() {
        List<Crew> pair1 = Arrays.asList(
                new Crew(Course.BACKEND, "tmd"),
                new Crew(Course.BACKEND, "tmd")
        );
        List<Crew> pair2 = Arrays.asList(
                new Crew(Course.BACKEND, "tmd"),
                new Crew(Course.BACKEND, "tmd")
        );
        PairRepository.add(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1));
        System.out.println(PairRepository.pairs(Course.BACKEND, Mission.CAR_RACING));
        assertThat(PairRepository.pairs(Course.BACKEND, Mission.CAR_RACING))
                .isEqualTo(pair1);
    }
}