package view;

import constant.Course;
import pairmatching.Crew;
import repository.CrewRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BegginingInitializer {

    public void initializeCrewRepository() {
        initialize(Course.BACKEND, "src/main/resources/backend-crew.md");
        initialize(Course.BACKEND, "src/main/resources/frontend-crew.md");
    }

    private void initialize(Course course, String filePath) {
        try {
            File backendCrews = new File(filePath);
            FileReader fileReader = new FileReader(backendCrews);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String crewName = "";
            while ((crewName = bufReader.readLine()) != null) {
                CrewRepository.addCrew(new Crew(course, crewName));
            }
            bufReader.close();
        } catch (IOException exception) {
        }
    }
}
