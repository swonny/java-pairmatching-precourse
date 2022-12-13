

package view;

import constant.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReader {
    private static final String frontFilePath = "src/main/resources/frontend-crew.md";
    private static final String backFilePath = "src/main/resources/backend-crew.md";
    private static File file;

    public static List<String> getCrewNames(Course course) throws IOException {
        setFile(course);
        List<String> crewNames = new ArrayList<>();
        BufferedReader reader;
        try {
            String line;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                crewNames.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        reader.close();
        return crewNames;
    }

    private static void setFile(Course course) {
        if (Course.FRONTEND == course) {
            file = new File(frontFilePath);
            return;
        }
        file = new File(backFilePath);
    }
}