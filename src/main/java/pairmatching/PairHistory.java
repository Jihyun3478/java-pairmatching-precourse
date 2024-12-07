package pairmatching;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PairHistory {
    private final Map<Mission, List<Pair>> pairHistory = new EnumMap<>(Mission.class);

    public void save(Mission mission, Pair pair) {
        List<Pair> pairs = pairHistory.getOrDefault(mission, new ArrayList<>());
        pairs.add(pair);
        pairHistory.put(mission, pairs);
    }

    public boolean existPair(Mission mission, Pair pair) {
        return mission.getLevel().getMissions().stream()
            .anyMatch(mission1 -> pairHistory.getOrDefault(mission1, new ArrayList<>()).contains(pair));
    }

    public List<Pair> get(Course course, Level level, Mission mission) {
        return pairHistory.get(mission);
    }

    public void clear() {
        pairHistory.clear();
    }
}
