package pairmatching;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {

    private final List<String> crews = new ArrayList<>();

    public Crews(List<String> names) {
        crews.addAll(names);
    }

    public List<String> shuffle() {
        return Randoms.shuffle(crews);
    }
}
