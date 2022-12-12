package contatants;

public enum Command {
    WILL_REPAIR("네"),
    WILL_NOT_REPAIR("아니오");

    private String input;

    Command(String input) {
        this.input = input;
    }

    public static boolean isRepair(String input) {
        validateInput(input);
        return WILL_REPAIR.input.equals(input);
    }

    private static boolean validateInput(String input) {
        for (Command command : Command.values()) {
            if (command.input.equals(input)) {
                return true;
            }
        }
        throw new IllegalArgumentException("네 또는 아니오 중에 선택하세요.");
    }
}
