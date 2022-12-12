package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    public static String getWholeLevel() {
        return Arrays.stream(Level.values())
                .map(level -> level.name)
                .collect(Collectors.joining("\n"));
    }
}