package view;

import domain.utils.Course;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest {
    @Test
    public void testGetCrewNames() throws IOException {
        System.out.println(CustomFileReader.getCrewNames(Course.FRONTEND));
    }
}