package domain.utils;

import domain.Mission;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1(
            "레벨1",
            Arrays.asList(new Mission("자동차경주"),new Mission("로또"), new Mission("숫자야구게임"))
    ),
    LEVEL2(
            "레벨2",
            Arrays.asList(new Mission("장바구니"), new Mission("결제"), new Mission("지하철노선도"))
    ),
    LEVEL3(
            "레벨3",
            Collections.emptyList()
    ),
    LEVEL4(
            "레벨4",
            Arrays.asList( new Mission("성능개선"), new Mission("배포"))
    ),
    LEVEL5(
            "레벨5",
            Collections.emptyList()
    );

    private List<Mission> missionList;
    private String name;

    Level(String name, List<Mission> missionList) {
        this.name = name;
        this.missionList = missionList;
    }

    public static Level getLevelByName(String levelName) {
        for (Level level : Level.values()) {
            if (level.name.equals(levelName)) {
                return level;
            }
        }
        return null;
    }

    public List<Mission> getMissionList() {
        return this.missionList;
    }
}
