package constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissionTest {
    @Test
    public void testGetSameLevelMission() {
        System.out.println(Mission.LOTTO.getSameLevelMissions());
    }
}