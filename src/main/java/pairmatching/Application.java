package pairmatching;

import constant.Course;
import controller.MainController;
import repository.CrewRepository;
import view.BegginingInitializer;

public class Application {
    public static void main(String[] args) {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        MainController mainController = new MainController();
        mainController.run();
    }
}
