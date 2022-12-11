package controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PairMatcherTest {
    @Test
    public void testMatch() {
        assertThat(PairMatcher.match("프론트엔드")).isEqualTo("a");
    }
}