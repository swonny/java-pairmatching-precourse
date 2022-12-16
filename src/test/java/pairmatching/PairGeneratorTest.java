package pairmatching;

import constant.Course;
import constant.Level;
import constant.Mission;
import org.junit.jupiter.api.Test;
import repository.PairRepository;
import view.BegginingInitializer;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    public void testPairGenerator_레포지토리저장() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        PairGenerator pairGenerator = new PairGenerator();
        List<Pair> pairs = pairGenerator.generate(Course.FRONTEND, Level.LEVEL1, Mission.BASEBALL_GAME);
        pairs = PairRepository.pairs(Course.FRONTEND, Mission.BASEBALL_GAME);
        assertThat(pairs.get(0).getCourse())
                .isEqualTo(Course.FRONTEND);
    }
}