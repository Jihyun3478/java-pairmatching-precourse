package pairmatching;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {

    private final List<Crew> crews = new ArrayList<>();

    public Crews(List<String> names, Course course) {
        for(String name : names) {
            crews.add(new Crew(course, name));
        }
    }

    public Pair matchPair() {
        Randoms.shuffle(crews);
        return new Pair(crews.subList(0, 1));
    }
}
