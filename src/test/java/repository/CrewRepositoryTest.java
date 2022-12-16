package repository;

import org.junit.jupiter.api.Test;
import pairmatching.Application;
import view.BegginingInitializer;


class CrewRepositoryTest {
    @Test
    public void testInitializingRepository() {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        System.out.println(CrewRepository.crews());
    }
}