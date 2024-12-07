package pairmatching;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PairHistoryTest {
    @Test
    void 같은_레벨에서_이미_페어로_만난적이_있는지_확인한다() {
        List<Crew> crews = new ArrayList<>();
        crews.add(new Crew(Course.BACKEND, "포비"));
        crews.add(new Crew(Course.BACKEND, "제임스"));
        PairHistory pairHistory = new PairHistory();
        pairHistory.save(Level.LEVEL1, new Pair(crews));

        List<Crew> existCrews = new ArrayList<>();
        existCrews.add(new Crew(Course.BACKEND, "제임스"));
        existCrews.add(new Crew(Course.BACKEND, "포비"));

        assertThat(pairHistory.existPair(Level.LEVEL1, new Pair(existCrews))).isTrue();
        assertThat(pairHistory.existPair(Level.LEVEL2, new Pair(existCrews))).isFalse();
    }
}
