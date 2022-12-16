package constant;

public enum Mission {
    CART_RACING("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL_GAME("숫자야구게임", Level.LEVEL1),
    SHOPPING_BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_MAP("지하철노선도", Level.LEVEL2),
    REFACTOR("성능개선", Level.LEVEL4),
    DISTRIBUTE("배포", Level.LEVEL4);

    private final String missionName;
    private final Level level;

    Mission(String missionName, Level level) {
        this.missionName = missionName;
        this.level = level;
    }
}
