package pairmatching.dto;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.Pair;

public class PairResponse {
    private final List<InnerPair> pairs;

    public PairResponse(List<InnerPair> pairs) {
        this.pairs = pairs;
    }

    public List<InnerPair> getPairs() {
        return pairs;
    }

    public static PairResponse from(List<Pair> pairs) {
        return new PairResponse(
            pairs.stream()
                .map(pair -> new InnerPair(pair.getNames()))
                .collect(Collectors.toList())
        );
    }

    public static class InnerPair {
        private final List<String> names;

        public InnerPair(List<String> names) {
            this.names = names;
        }

        public List<String> getNames() {
            return names;
        }
    }
}
