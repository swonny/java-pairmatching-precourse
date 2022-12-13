package constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ExampleViewMessage {
    INFORMATION_START_DELIMITER("#############################################"),
    COURSE_INFORMATION("과정: 백엔드 | 프론트엔드"),
    MISSION_TITLE("과정: "),
    LEVEL_1("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임"),
    LEVEL_2("  - 레벨2: 장바구니 | 결제 | 지하철노선도"),
    LEVEL_3("  - 레벨3: "),
    LEVEL_4("  - 레벨4: 성능개선 | 배포"),
    LEVEL_5("  - 레벨5: "),
    SELECTION_MESSAGE("과정, 레벨, 미션을 선택하세요."),
    SELECTION_EXAMPLE("ex) 백엔드, 레벨1, 자동차경주"),
    INFORMATION_END_DELIMITER("#############################################");

    private final String message;

    ExampleViewMessage(String message) {
        this.message = message;
    }

    public static String getExample() {
        return Arrays.stream(ExampleViewMessage.values())
                .map(line -> line.message)
                .collect(Collectors.joining("\n"));
    }
}