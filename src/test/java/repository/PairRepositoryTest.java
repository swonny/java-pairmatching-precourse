package repository;

import constant.Course;
import constant.Mission;
import org.junit.jupiter.api.Test;
import pairmatching.PairGenerator;
import view.BegginingInitializer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PairRepositoryTest {
    @Test
    void testPairRepository() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        PairGenerator pairGenerator = new PairGenerator();
        pairGenerator.generate(Course.BACKEND, Mission.BASEBALL_GAME);
        assertThat(PairRepository.hasPairs(Course.BACKEND, Mission.BASEBALL_GAME))
                .isTrue();
    }

    @Test
    void testPairRepository_과정달라서_매칭이력없는경우() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        PairGenerator pairGenerator = new PairGenerator();
        pairGenerator.generate(Course.BACKEND, Mission.BASEBALL_GAME);
        assertThat(PairRepository.hasPairs(Course.FRONTEND, Mission.BASEBALL_GAME))
                .isFalse();
    }

    @Test
    void testPairRepository_미션달라서_매칭이력없는경우() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        PairGenerator pairGenerator = new PairGenerator();
        pairGenerator.generate(Course.BACKEND, Mission.BASEBALL_GAME);
        assertThat(PairRepository.hasPairs(Course.BACKEND, Mission.CART_RACING))
                .isFalse();
    }
}