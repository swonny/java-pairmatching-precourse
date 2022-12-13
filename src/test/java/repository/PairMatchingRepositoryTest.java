package repository;

import constant.Course;
import constant.Mission;
import org.junit.jupiter.api.Test;
import pairmatching.Crew;
import pairmatching.Pair;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PairMatchingRepositoryTest {
    @Test
    public void testRepository() {
//        Crew crew1 = new Crew(Course.BACKEND, "tmd");
//        Crew crew2 = new Crew(Course.BACKEND, "tmd");
//        List<Crew> pair1 = Arrays.asList(
//                crew1,
//                crew2
//        );
//        List<Crew> pair2 = Arrays.asList(
//                new Crew(Course.BACKEND, "tmd"),
//                new Crew(Course.BACKEND, "tmd")
//        );
//        List<List<Crew>> pairs2 = Arrays.asList(pair2);
//
//        PairMatchingRepository.add(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1));
//        System.out.println(PairMatchingRepository.hasAnySamePairs(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1)));
//        System.out.println(PairMatchingRepository.hasAnySamePairs(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair2)));
    }

    @Test
    public void test() {
        Crew crew1 = new Crew(Course.BACKEND, "승");
        Crew crew2 = new Crew(Course.BACKEND, "원");
        Crew crew3 = new Crew(Course.BACKEND, "승");
        Crew crew4 = new Crew(Course.BACKEND, "원");

        Pair pair1 = new Pair(crew1, crew2);
        Pair pair2 = new Pair(crew1, crew2);
        PairMatchingRepository.add(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1));

        System.out.println(PairMatchingRepository.hasAnySamePairs(Course.BACKEND, Mission.LOTTO ,Arrays.asList(pair2)));
//        List<Crew> a = Arrays.asList(crew1, crew2);
//        List<Crew> b = Arrays.asList(crew2, crew1);
//        List<Crew> c = Arrays.asList(crew3, crew4);
//        List<List<Crew>> pairs = Arrays.asList(a, b, c);
//        System.out.println(pair2.getCrews().containsAll(pair1.getCrews()));
//        System.out.println(pair2.equals(pair2));


    }

    @Test
    public void testHasPairOf() {
//        List<Crew> pair1 = Arrays.asList(
//                new Crew(Course.BACKEND, "tmd"),
//                new Crew(Course.BACKEND, "tmd")
//        );
//        List<Crew> pair2 = Arrays.asList(
//                new Crew(Course.BACKEND, "tmd"),
//                new Crew(Course.BACKEND, "tmd")
//        );
//        PairMatchingRepository.add(Course.BACKEND, Mission.CAR_RACING, Arrays.asList(pair1));
//        System.out.println(PairMatchingRepository.hasPairsOf(Course.BACKEND, Mission.CAR_RACING));

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
//        PairMatchingRepository.add(Course.BACKEND, Mission.CAR_RACING,
//        Arrays.asList(pair1));
        System.out.println(PairMatchingRepository.pairs(Course.BACKEND, Mission.CAR_RACING));
        assertThat(PairMatchingRepository.pairs(Course.BACKEND, Mission.CAR_RACING))
                .isEqualTo(pair1);
    }
}