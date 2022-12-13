package pairmatching;

import java.util.*;

public class Pair {
    private final List<Crew> crews = new ArrayList<>();

    public Pair(Crew crew1, Crew crew2) {
        crews.addAll(Arrays.asList(crew1, crew2));
    }

    public void add(Crew crew) {
        crews.add(crew);
    }

    public List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return this.getCrews().containsAll(pair.getCrews());
    }
}
