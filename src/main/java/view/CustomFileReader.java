package view;

import domain.utils.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReader {
    private static final String frontFilePath = "/Users/choeseung-won/woowa-precourse-5/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
    private static final String backFilePath = "/Users/choeseung-won/woowa-precourse-5/java-pairmatching-precourse/src/main/resources/resources/backend-crew.md";
    private static File file;

    public static List<String> getCrewNames(Course course) throws IOException {
        //TODO : 파일 입출력
        setFile(course);
        List<String> crewNames = new ArrayList<>();
        String line = null;
        if(file.exists()){ // 파일이 존재하면
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    crewNames.add(line);
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            reader.close();
        }
        return crewNames;
    }

    private static void setFile(Course course) {
        if (Course.FRONTEND.equals(course)) {
            file = new File(frontFilePath);
            return;
        }
        file = new File(backFilePath);
    }
}
