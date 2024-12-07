package pairmatching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pair {
    private final Set<Crew> pair = new HashSet<>();

    public Pair(List<Crew> crews) {
        pair.addAll(crews);
    }

    public int size() {
        return pair.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair1 = (Pair)o;
        return Objects.equals(pair, pair1.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pair);
    }
}
