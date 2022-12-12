package controller;

import contatants.Course;
import domain.PairMatcher;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PairMatcherTest {
    @Test
    public void testMatch() {
        assertThat(PairMatcher.match(Course.FRONTEND)).isEqualTo("a");
    }
}