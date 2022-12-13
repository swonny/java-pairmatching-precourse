package repository;

import pairmatching.Pair;

import java.util.ArrayList;
import java.util.List;

public class PairRepository {
    private static final List<Pair> pairs = new ArrayList<>();

    public static void add(List<Pair> pair) {
        pairs.addAll(pair);
    }
}
