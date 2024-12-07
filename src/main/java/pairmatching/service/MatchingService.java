package pairmatching.service;

import java.util.List;

import pairmatching.Course;
import pairmatching.CrewNameParser;
import pairmatching.Crews;
import pairmatching.Level;
import pairmatching.Mission;
import pairmatching.Pair;
import pairmatching.PairHistory;

public class MatchingService {
    private PairHistory pairHistory = new PairHistory();
    private Crews crews;

    public void setUp() {
        crews.addAll(CrewNameParser.getNames(Course.FRONTEND), Course.FRONTEND);
        crews.addAll(CrewNameParser.getNames(Course.BACKEND), Course.BACKEND);
    }

    public void matchPairs(Course course, Level level, Mission mission) {
        crews.matchPair(pairHistory, mission);
    }

    public List<Pair> findPairs(Course course, Level level, Mission mission) {
        return pairHistory.get(course, level, mission);
    }

    public void clear() {
        pairHistory.clear();
    }
}
