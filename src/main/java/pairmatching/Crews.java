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
        if (crews.size() == 3) {
            List<Crew> result = new ArrayList<>();
            result.add(crews.remove(0));
            result.add(crews.remove(0));
            result.add(crews.remove(0));
            return new Pair(result);
        }
        List<Crew> result = new ArrayList<>();
        result.add(crews.remove(0));
        result.add(crews.remove(0));
        return new Pair(result);
    }
}
