package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MainMenu {
    FIRST("1", "1. 페어 매칭"),
    SECOND("2", "2. 페어 조회"),
    THIRD("3", "3. 페어 초기화"),
    QUIT("Q", "Q. 종료");

    private final String userInput;
    private final String menuName;

    MainMenu(String userInput, String menuName) {
        this.userInput = userInput;
        this.menuName = menuName;
    }

    public static String getWholeMenu() {
        return Arrays.stream(MainMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public static boolean isFirstMenu(String selection) {
        return FIRST.userInput.equals(selection);
    }

    public static boolean isSecondMenu(String selection) {
        return SECOND.userInput.equals(selection);
    }

    public static boolean isThirdMenu(String selection) {
        return THIRD.userInput.equals(selection);
    }

    public static MainMenu getMenu(String readMainMenu) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> menu.userInput.equals(readMainMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴입니다."));
    }
}
