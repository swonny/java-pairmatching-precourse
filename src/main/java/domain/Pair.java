package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pair {
    private static final int FRONT = 0;
    private static final int BACK = 1;

    private List<String> pair;

    public Pair(String crew1, String crew2) {
        pair = Stream.of(crew1, crew2).collect(Collectors.toList());
    }

    public void add(String crew) {
        pair.add(crew);
    }

    public List<String> getName() {
        return pair;
    }
}
