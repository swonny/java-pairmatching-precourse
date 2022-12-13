package service;

import constant.Course;
import constant.Level;
import constant.Mission;
import org.junit.jupiter.api.Test;
import pairmatching.Application;

import static org.junit.jupiter.api.Assertions.*;

class PairMatchingServiceTest {
    @Test
    public void testMakePairs() {
        PairMatchingService pairMatchingService = new PairMatchingService();
        System.out.println(pairMatchingService.makePairs(Course.FRONTEND, Level.LEVEL1, Mission.CAR_RACING));
    }
}