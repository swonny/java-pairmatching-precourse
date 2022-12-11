package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Pair;
import domain.PairMaker;
import domain.utils.Course;
import view.CustomFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
    public static List<Pair> match(String course) {
        List<String> crewNames; // 파일에서 로드한 크루 이름 목록
        try {
            crewNames = getCrewNames(course);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // TODO : 중복되는 페어 있는ㄴ지 검사
        System.out.println(crewNames);
        List<String> shuffledCrew = Randoms.shuffle(crewNames); // 섞인 크루 이름 목록
        List<Pair> pairs = PairMaker.make(shuffledCrew);
        return pairs;
    }

    private static List<String> getCrewNames(String course) throws IOException {
        if (Course.FRONTEND.get().equals(course)) {
            return CustomFileReader.getCrewNames(Course.FRONTEND);
        }
        return CustomFileReader.getCrewNames(Course.BACKEND);
    }
}
