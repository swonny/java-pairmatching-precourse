package pairmatching;

import constant.Course;

import java.util.ArrayList;
import java.util.List;

public class PairGenerator {
    public List<Pair> generate(List<Enum> matchingInformation) {
        // TODO : return값 변경하기
        List<Pair> pairs = new ArrayList<>();
        Pair pair1 = new Pair(new Crew(Course.BACKEND, "승원"), new Crew(Course.BACKEND, "하영"));
        Pair pair2 = new Pair(new Crew(Course.BACKEND, "승원"), new Crew(Course.BACKEND, "하영"), new Crew(Course.BACKEND, "하영"));
        pairs.add(pair1);
        pairs.add(pair2);
        return pairs;
    }
}
