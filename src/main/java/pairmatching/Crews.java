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

    public Pair matchPair(PairHistory pairHistory, Level level) {
        int count = 0;
        Pair pair = null;
        List<Crew> result;
        if (crews.size() == 3) {
            do {
                count++;
                if (count > 3) {
                    throw new IllegalStateException();
                }
                Randoms.shuffle(crews);
                result = new ArrayList<>();
                result.add(crews.get(0));
                result.add(crews.get(1));
                result.add(crews.get(2));
                pair = new Pair(result);
            } while (pairHistory.existPair(level, pair));
            pairHistory.save(level, pair);
            crews.remove(0);
            crews.remove(0);
            crews.remove(0);
            return pair;
        }
        do {
            count++;
            if (count > 3) {
                throw new IllegalStateException();
            }
            Randoms.shuffle(crews);
            result = new ArrayList<>();
            result.add(crews.get(0));
            result.add(crews.get(1));
            pair = new Pair(result);
        } while (pairHistory.existPair(level, pair));
        pairHistory.save(level, pair);
        crews.remove(0);
        crews.remove(0);
        return pair;
    }
}
