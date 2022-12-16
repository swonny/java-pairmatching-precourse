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
                .filter(level -> level.name.equals(levelName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("레벨 1 ~ 5 중 하나를 입력하세요."));
    }

}