package controller;

import domain.utils.Course;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PairMatcherTest {
    @Test
    public void testMatch() {
        assertThat(PairMatcher.match(Course.FRONTEND)).isEqualTo("a");
    }
}