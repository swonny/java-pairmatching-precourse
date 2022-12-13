package constant;

public enum ExceptionMessage {
    PAIR_DOES_NOT_EXIST("매칭 이력이 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = "[ERROR] "+ message;
    }

}
