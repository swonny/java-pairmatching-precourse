package domain.utils;

import domain.Mission;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LevelMissionRepository {
    private HashMap<Level, List<Mission>> levelIncludingMission = new HashMap<>();

    public LevelMissionRepository() {
        levelIncludingMission.put(
                Level.LEVEL1,
                Arrays.asList(new Mission("자동차경주"), new Mission("로또"), new Mission("숫자야구게임"))
        );
        levelIncludingMission.put(
                Level.LEVEL2,
                Arrays.asList(new Mission("장바구니"), new Mission("결제"), new Mission("지하철노선도"))
        );
        levelIncludingMission.put(
                Level.LEVEL3,
                Arrays.asList(null)
        );
        levelIncludingMission.put(
                Level.LEVEL4,
                Arrays.asList(new Mission("성능개선"), new Mission("배포"))
        );
        levelIncludingMission.put(
                Level.LEVEL5,
                Arrays.asList(null)
        );
    }
}
