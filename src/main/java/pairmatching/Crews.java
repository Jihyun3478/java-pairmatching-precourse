package pairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {

    private List<Crew> crews = new ArrayList<>();

    public void addAll(List<String> names, Course course) {
        for(String name : names) {
            crews.add(new Crew(course, name));
        }
    }

    public Pair matchPair(PairHistory pairHistory, Mission mission, Course course) {
        int count = 0;
        Pair pair = null;
        List<Crew> result;
        if (crews.size() == 3) {
            do {
                count++;
                if (count > 3) {
                    throw new IllegalStateException();
                }
                result = new ArrayList<>();
                result.add(crews.get(0));
                result.add(crews.get(1));
                result.add(crews.get(2));
                pair = new Pair(result);
                if (pairHistory.existPair(mission, pair)) {
                    shuffle(course);
                }
            } while (pairHistory.existPair(mission, pair));
            pairHistory.save(mission, pair);
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
            result = new ArrayList<>();
            result.add(crews.get(0));
            result.add(crews.get(1));
            pair = new Pair(result);
            if (pairHistory.existPair(mission, pair)) {
                shuffle(course);
            }
        } while (pairHistory.existPair(mission, pair));
        pairHistory.save(mission, pair);
        crews.remove(0);
        crews.remove(0);
        return pair;
    }

    public void clear() {
        crews.clear();
    }

    public boolean isEmpty() {
        return crews.isEmpty();
    }

    public void shuffle(Course course) {
        List<String> shuffle = Randoms.shuffle(getNames());
        crews = new ArrayList<>();
        for(String name : shuffle) {
            crews.add(new Crew(course, name));
        }
    }

    public List<String> getNames() {
        return crews.stream().map(Crew::getName)
            .collect(Collectors.toList());
    }
}
