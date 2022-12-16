package pairmatching;

import constant.Course;
import controller.MainController;
import repository.CrewRepository;
import view.BegginingInitializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BegginingInitializer begginingInitializer = new BegginingInitializer();
        begginingInitializer.initializeCrewRepository();
        MainController mainController = new MainController();
        mainController.run();
    }
}
