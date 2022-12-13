package pairmatching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pair {
    List<Crew> crews = new ArrayList<>();

    public Pair(List<Crew> crews) {
        this.crews.addAll(crews);
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void add(Crew crew) {
        crews.add(crew);
    }
}
