package view;

import contatants.Course;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CustomFileReaderTest {
    @Test
    public void testGetCrewNames() throws IOException {
        System.out.println(CustomFileReader.getCrewNames(Course.FRONTEND));
    }
}