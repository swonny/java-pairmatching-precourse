package constant;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level getLevelByName(String levelName) {
        return Arrays.stream(Level.values())
                .filter(menu -> menu.name.equals(levelName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴입니다."));
    }

    // 추가 기능 구현
}