package pairmatching;

import controller.MainController;
import view.BegginingInitializer;

public class Application {
    public static void main(String[] args) {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        MainController mainController = new MainController();
        mainController.run();
    }
}
