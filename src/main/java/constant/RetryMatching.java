package constant;

import java.util.Arrays;

public enum RetryMatching {
    RETRY("네"),
    QUIT("아니오");

    private final String command;

    RetryMatching(String command) {
        this.command = command;
    }

    public static RetryMatching getRetryCommand(String retryCommand) {
        return Arrays.stream(RetryMatching.values())
                .filter(retryMatching -> retryMatching.command.equals(retryCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("네 | 아니오 중 하나를 입력하세요"));
    }
}
