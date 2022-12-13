package repository;

import constant.Course;
import constant.Mission;
import org.junit.jupiter.api.Test;
import pairmatching.Crew;

import java.util.Arrays;
import java.util.List;

class PairMatchingRepositoryTest {
    @Test
    public void testPairRepository() {
        List<Crew> pair1 = Arrays.asList(
                new Crew(Course.BACKEND, "승원"),
                new Crew(Course.BACKEND, "최")
        );
        List<Crew> pair2 = Arrays.asList(
                new Crew(Course.BACKEND, "승원"),
                new Crew(Course.BACKEND, "최")
        );
        PairMatchingRepository.add(
                Course.BACKEND,
                Mission.CAR_RACING,
                Arrays.asList(pair1, pair2)
        );
        PairMatchingRepository.add(
                Course.BACKEND,
                Mission.LOTTO,
                Arrays.asList(pair1, pair2)
        );
        System.out.println(PairMatchingRepository.hasUniquePairsOnly(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1)));
    }
}