package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissionRepositoryTest {
    @Test
    public void testMissionRepo() {
        System.out.println(MissionRepository.getMissionByName("자동차경주").getName());
    }
}