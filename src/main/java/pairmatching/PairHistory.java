package pairmatching;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PairHistory {
    private final Map<Level, List<Pair>> pairHistory = new EnumMap<>(Level.class);

    public void save(Level level, Pair pair) {
        List<Pair> pairs = pairHistory.getOrDefault(level, new ArrayList<>());
        pairs.add(pair);
        pairHistory.put(level, pairs);
    }

    public boolean existPair(Level level, Pair pair) {
        List<Pair> pairs = pairHistory.getOrDefault(level, new ArrayList<>());
        return pairs.contains(pair);
    }
}
