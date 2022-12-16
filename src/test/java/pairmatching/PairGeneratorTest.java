package pairmatching;

import constant.Course;
import constant.Level;
import constant.Mission;
import org.junit.jupiter.api.Test;
import view.BegginingInitializer;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PairGeneratorTest {
    @Test
    public void testPairGenerator() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        PairGenerator pairGenerator = new PairGenerator();
        List<Pair> pairs = pairGenerator.generate(Course.BACKEND, Level.LEVEL1, Mission.BASEBALL_GAME);
        pairs.stream()
                .map(pair -> pair.crews().stream().map(crew -> crew.getName()).collect(Collectors.joining(" : ")))
                .forEach(System.out::println);
    }

    @Test
    public void testPairGenerator_프론트엔드() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        PairGenerator pairGenerator = new PairGenerator();
        List<Pair> pairs = pairGenerator.generate(Course.FRONTEND, Level.LEVEL1, Mission.BASEBALL_GAME);
        pairs.stream()
                .map(pair -> pair.crews().stream().map(crew -> crew.getName()).collect(Collectors.joining(" : ")))
                .forEach(System.out::println);
    }
}