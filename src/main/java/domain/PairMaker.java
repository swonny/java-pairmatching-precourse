package domain;

import java.util.ArrayList;
import java.util.List;

public class PairMaker {
    public static List<Pair> make(List<String> crewNames) {
        List<Pair> pairs = new ArrayList<>();
        while (crewNames.size() > 0) {
            pairs.add(new Pair(crewNames.remove(0), crewNames.remove(0)));
        }
        // TODO : 홀수 구현
        return pairs;
    }
}
