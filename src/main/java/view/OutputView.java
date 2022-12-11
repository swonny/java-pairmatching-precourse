package view;

import domain.Pair;
import view.uitils.MainMenu;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ERROR = "[ERROR] ";
    private static final String MISSION_INFORMATION_DELIMITER = "#############################################";
    private static final String COURSE = "과정: 백엔드 | 프론트엔드";
    private static final String MISSION = "미션:";
    private static final String LEVEL_1 = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임";
    private static final String LEVEL_2 = "  - 레벨2: 장바구니 | 결제 | 지하철노선도";
    private static final String LEVEL_3 = "  - 레벨3: ";
    private static final String LEVEL_4 = "  - 레벨4: 성능개선 | 배포";
    private static final String LEVEL_5 = "  - 레벨5: ";
    private static final String LEVEL_MISSION_SELECTION_MESSAGE = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
    private static final String NEWLINE = "\n";
    private static final String PAIR_RESULT = "페어 매칭 결과입니다.";
    private static final String PAIR_DELIMITER = " : ";
    private static final String FINISHED_INIT = "초기화 되었습니다.";
    private static final String REPAIR = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" + "네 | 아니오";

    public static void printMainMenu() {
        print(MainMenu.getWholeMenu());
    }

    private static void print(String value) {
        System.out.println(value);
    }

    public static void printErrorMessage(String errorMessage) {
        print(ERROR + errorMessage);
    }

    public static void printInputExample() {
        // TODO : enum 변경
        StringBuilder information = new StringBuilder();
        information.append(MISSION_INFORMATION_DELIMITER + NEWLINE);
        information.append(COURSE + NEWLINE);
        information.append(MISSION + NEWLINE);
        information.append(
                LEVEL_1 + NEWLINE + LEVEL_2 + NEWLINE + LEVEL_3 + NEWLINE + LEVEL_4 + NEWLINE + LEVEL_5 + NEWLINE
        );
        information.append(MISSION_INFORMATION_DELIMITER);
        information.append(LEVEL_MISSION_SELECTION_MESSAGE);
        print(information.toString());
    }

    public static void printPairMatchingResult(List<Pair> pairs) {
        print(PAIR_RESULT);
        pairs.stream()
                .map(Pair::getName)
                .map(pair -> pair.stream().collect(Collectors.joining(PAIR_DELIMITER)))
                .forEach(OutputView::print);
        print(NEWLINE);
    }

    public static void printFinishedInit() {
        print(FINISHED_INIT);
    }

    public static void printAskingRemakePair() {
        print(REPAIR);
    }
}
