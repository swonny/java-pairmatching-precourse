package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissionRepository {
    private static final List<Mission> missions = Arrays.asList(
            new Mission("자동차경주"), new Mission("로또"), new Mission("숫자야구게임"),
            new Mission("장바구니"), new Mission("결제"), new Mission("지하철노선도"),
            new Mission("성능개선"), new Mission("배포")
    );

    public static Mission getMissionByName(String name) {
        for (Mission mission : missions) {
            if (mission.getName().equals(name)) {
                return mission;
            }
        }
        throw new IllegalArgumentException("해당 미션은 존재하지 않습니다.");
    }
}
