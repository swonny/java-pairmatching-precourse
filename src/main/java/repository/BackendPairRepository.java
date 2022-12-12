package repository;

import pairmatching.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackendPairRepository {
    private static List<Pair> pairs = new ArrayList<>();

    public static List<Pair> getPairsOf(String mission) {
        return Collections.unmodifiableList(pairs);
    }
}
