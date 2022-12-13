package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MainMenu {
    FIRST("1", "1. 페어 매칭"),
    SECOND("2", "2. 페어 조회"),
    THIRD("3", "3. 페어 초기화"),
    QUIT("Q", "Q. 종료");


    private final String command;
    private final String menuName;

    MainMenu(String command, String menuName) {
        this.command = command;
        this.menuName = menuName;
    }

    public static String getWholeMenu() {
        return Arrays.stream(MainMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }

    public static MainMenu getMenuByName(String input) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> menu.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴입니다."));
    }
}
