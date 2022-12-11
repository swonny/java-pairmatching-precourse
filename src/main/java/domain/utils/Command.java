package domain.utils;

public enum Command {
    WILL_REPAIR("예"),
    WILL_NOT_REPAIR("아니오");

    private String input;

    Command(String input) {
        this.input = input;
    }

    public static boolean isRepair(String input) {
        if (!WILL_REPAIR.input.equals(input) && !WILL_NOT_REPAIR.input.equals(input)) {
            throw new IllegalArgumentException("예 또는 아니오 중에 선택하세요.");
        }
        return WILL_REPAIR.input.equals(input);
    }
}
