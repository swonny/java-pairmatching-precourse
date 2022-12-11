package domain;

import java.util.ArrayList;
import java.util.List;

public class PairMaker {
    public static List<Pair> make(List<String> crewNames) {
        List<Pair> pairs = new ArrayList<>();
        while (crewNames.size() > 1) {
            pairs.add(new Pair(crewNames.remove(0), crewNames.remove(0)));
        }
        // TODO : 홀수 구현
        if (crewNames.size() > 0) {
            Pair pair = pairs.get(pairs.size() - 1);
            pair.add(crewNames.remove(0));
        }
        return pairs;
    }
}
