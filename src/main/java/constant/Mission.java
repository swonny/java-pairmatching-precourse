package constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
    CAR_RACING("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    NUMBER_BASEBALL_GAME("숫자야구게임", Level.LEVEL1),
    MARKET_BAG("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_MAP("지하철노선도", Level.LEVEL2),
    REFACTORING("성능개선", Level.LEVEL4),
    DISTRIBUTION("배포", Level.LEVEL4),
    ;

    private final String missionName;
    private final Level level;

    Mission(String missionName, Level level) {
        this.missionName = missionName;
        this.level = level;
    }

    public static Mission getMissionByName(String missionName) {
        return Arrays.stream(Mission.values())
                .filter(menu -> menu.missionName.equals(missionName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴입니다."));    }

    public List<Mission> getSameLevelMissions() {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.level.equals(this.level) && !mission.equals(this))
                .collect(Collectors.toList());
    }
}
