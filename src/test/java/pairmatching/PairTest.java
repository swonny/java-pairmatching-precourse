package pairmatching;

import constant.Course;
import org.junit.jupiter.api.Test;
import repository.CrewRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    @Test
    public void testPair() {
        Pair Pair = new Pair(Arrays.asList(
                new Crew(Course.FRONTEND, "tmdd"),
                new Crew(Course.FRONTEND, "ㅎㅇ")
        ));
        System.out.println(Pair.getCrews());
    }
}