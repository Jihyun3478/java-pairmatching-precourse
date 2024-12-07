package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final List<Crew> pair = new ArrayList<>();

    public Pair(List<Crew> crews) {
        pair.addAll(crews);
    }
}
