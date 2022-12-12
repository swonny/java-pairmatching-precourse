package constant;

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
}
