package pairmatching.service;

import java.util.List;

import pairmatching.Course;
import pairmatching.CrewNameParser;
import pairmatching.Crews;
import pairmatching.Pair;
import pairmatching.PairHistory;
import pairmatching.dto.PairResponse;
import pairmatching.dto.StepRequest;

public class MatchingService {
    private PairHistory pairHistory = new PairHistory();
    private Crews crews = new Crews();

    public void setUp() {
        crews.clear();
        crews.addAll(CrewNameParser.getNames(Course.FRONTEND), Course.FRONTEND);
        crews.addAll(CrewNameParser.getNames(Course.BACKEND), Course.BACKEND);
    }

    public void matchPairs(StepRequest request) {
        while (!crews.isEmpty()) {
            crews.matchPair(pairHistory, request.getMission());
        }
    }

    public PairResponse findPairs(StepRequest request) {
        List<Pair> pairs = pairHistory.get(request.getCourse(), request.getLevel(), request.getMission());
        return PairResponse.from(pairs);
    }

    public void clear() {
        pairHistory.clear();
    }
}

/**
 * TODO
 * 1. ㅁㅐ 라운드가 끝나면 매칭 정보를 초기화.(진짜초기화는 아니고.. ...)
 */