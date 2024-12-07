package pairmatching.service;

import java.util.List;

import pairmatching.Course;
import pairmatching.CrewNameParser;
import pairmatching.Crews;
import pairmatching.Level;
import pairmatching.Mission;
import pairmatching.Pair;
import pairmatching.PairHistory;
import pairmatching.dto.PairResponse;
import pairmatching.dto.StepRequest;

public class MatchingService {
    private PairHistory pairHistory = new PairHistory();
    private Crews crews;

    public void setUp() {
        crews.addAll(CrewNameParser.getNames(Course.FRONTEND), Course.FRONTEND);
        crews.addAll(CrewNameParser.getNames(Course.BACKEND), Course.BACKEND);
    }

    public void matchPairs(StepRequest request) {
        crews.matchPair(pairHistory, request.getMission());
    }

    public PairResponse findPairs(StepRequest request) {
        List<Pair> pairs = pairHistory.get(request.getCourse(), request.getLevel(), request.getMission());
        return PairResponse.from(pairs);
    }

    public void clear() {
        pairHistory.clear();
    }
}
