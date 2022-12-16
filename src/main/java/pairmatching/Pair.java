package pairmatching;

import java.util.Arrays;
import java.util.List;

public class Pair {
    private List<Crew> crews;

    public Pair(Crew crew1, Crew crew2) {
        this.crews = Arrays.asList(crew1, crew2);
    }

    public Pair(Crew crew1, Crew crew2, Crew crew3) {
        this.crews = Arrays.asList(crew1, crew2, crew3);
    }

    public List<Crew> crews() {
        // TODO : 리턴값 변경
        return crews;
    }
}
