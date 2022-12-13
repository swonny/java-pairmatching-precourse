package constant;

import java.util.Arrays;

public enum RetryCommand {
    WILL_RETRY("네"),
    WILL_NOT_RETRY("아니오");

    private final String userInput;

    RetryCommand(String userInput) {
        this.userInput = userInput;
    }

    public static String getRetryCommandExample() {
        return WILL_RETRY.userInput + " | " + WILL_NOT_RETRY.userInput;
    }

    public static RetryCommand getRetryCommand(String askForRetry) {
        return Arrays.stream(RetryCommand.values())
                .filter(command -> command.userInput.equals(askForRetry))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("네 또는 아니오 중에 입력하세요."));
    }
}
