package view.uitils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MainMenu {
    // TODO : substring으로 해도될듯
    TITLE("", "기능을 선택하세요."),
    FIRST("1", "1. 페어 매칭"),
    SECOND("2", "2. 페어 조회"),
    THIRD("3", "3. 페어 초기화"),
    QUIT("Q", "Q. 종료");

    private final String userSelection;
    private final String menuName;

    MainMenu(String userSelection, String menuName) {
        this.userSelection = userSelection;
        this.menuName = menuName;
    }

    public boolean equals(String selection) {
        return this.userSelection.equals(selection);
    }

    public static String getWholeMenu() {
        String result =  Arrays.stream(MainMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
        return result.concat("\n");
    }

    public static boolean isQuit(String selection) {
        return QUIT.userSelection.equals(selection);
    }
}






