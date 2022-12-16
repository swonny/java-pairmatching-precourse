package constant;

import java.util.Arrays;

public enum RematchCommand {
    WILL_REMATCH("네"),
    WILL_NOT_REMATCH("아니오");

    private final String command;

    RematchCommand(String command) {
        this.command = command;
    }

    public static RematchCommand getRematchCommandByName(String input) {
        return Arrays.stream(RematchCommand.values())
                .filter(command -> command.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("네 아니오 중 입력하세요."));
    }
}
