package pairmatching;

import constant.Course;
import controller.MainController;
import repository.CrewRepository;
import view.CustomFileReader;
import view.OutputView;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        initializeCrews();
        MainController mainController = new MainController();
        mainController.run();
    }

    private static void initializeCrews() {
        try {
            List<Crew> backendCrews = makeCrews(Course.BACKEND, CustomFileReader.getCrewNames(Course.BACKEND));
            List<Crew> frontendCrews = makeCrews(Course.FRONTEND, CustomFileReader.getCrewNames(Course.FRONTEND));
            CrewRepository.initializeCrews(Course.BACKEND, backendCrews);
            CrewRepository.initializeCrews(Course.FRONTEND, frontendCrews);
        } catch (IOException exception) {
            OutputView.printException(exception);
        }
    }

    private static List<Crew> makeCrews(Course course, List<String> crewNames) {
        return crewNames.stream()
                .map(crewName -> new Crew(course, crewName))
                .collect(Collectors.toList());
    }
}
