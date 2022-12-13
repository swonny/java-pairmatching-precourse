package constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
    CAR_RACING(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    NUMBER_BASEBALL(Level.LEVEL1, "숫자야구게임"),
    MARKET_BAG(Level.LEVEL2, "장바구니"),
    PAYMENT(Level.LEVEL2, "결제"),
    SUBWAY_MAP(Level.LEVEL2, "지하철노선도"),
    REFACTOR(Level.LEVEL4, "성능개선"),
    DISTRIBUTE(Level.LEVEL4, "배포");

    private final Level level;
    private final String gameName;

    Mission(Level level, String gameName) {
        this.level = level;
        this.gameName = gameName;
    }

    public static Mission getCourseByName(String missionName) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.gameName.equals(missionName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 미션 이름입니다."));
    }

    public List<Mission> getSameLevelMissions() {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.level.equals(this.level) && !mission.equals(this))
                .collect(Collectors.toList());
    }
}
