package controller;

import constant.MainMenu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
    @Test
    public void testMainControllerTest() {
        MainController mainController = new MainController();
        mainController.select(MainMenu.FIRST);
        mainController.select(MainMenu.SECOND);
        mainController.select(MainMenu.THIRD);
        mainController.select(MainMenu.QUIT);
    }

}