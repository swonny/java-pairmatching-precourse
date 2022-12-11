package domain;

import contatants.Level;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MissionPairRepositoryTest {
    @Test
    public void testMissionPairRepository() {
        Pair pair1 = new Pair("a", "b");
        Pair pair2 = new Pair("c", "d");
        Pair pair3 = new Pair("e", "f");
        MissionPairRepository.add(
                MissionRepository.getMissionByName("자동차경주게임"),
                Arrays.asList(pair1, pair2, pair3)
        );
        assertThat(MissionPairRepository.hasSamePair(Level.LEVEL1, Arrays.asList(pair1, pair2)))
                .isEqualTo("a");

    }

}