package pairmatching;

import java.util.Collections;
import java.util.List;

public class Pair {
    List<Crew> crews;

    public Pair(List<Crew> crews) {
        this.crews.addAll(crews);
    }

    public List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }
}
