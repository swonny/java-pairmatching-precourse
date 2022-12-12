package domain;

import camp.nextstep.edu.missionutils.Randoms;
import contatants.Course;
import view.CustomFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
    public static List<Pair> match(Course course) {
        List<String> crewNames = getCrewNames(course.getName());
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        return PairMaker.make(new ArrayList<>(shuffledCrew));
    }

    private static List<String> getCrewNames(String course) {
        try {
            return getCrewNamesFromFile(course);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getCrewNamesFromFile(String course) throws IOException {
        if (Course.FRONTEND.getName().equals(course)) {
            return CustomFileReader.getCrewNames(Course.FRONTEND);
        }
        return CustomFileReader.getCrewNames(Course.BACKEND);
    }
}
