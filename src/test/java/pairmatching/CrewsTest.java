package pairmatching;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CrewsTest {
    @Test
    void 미션을_함께_수행할_페어를_두명씩_매칭한다() {
        List<String> crewNames = CrewNameParser.getNames(Course.BACKEND);
        Crews crews = new Crews(crewNames, Course.BACKEND);

        Pair pair = crews.matchPair(new PairHistory(), Level.LEVEL1);
    }

    @Test
    void 홀수면_마지막_페어에_포함한다() {
        List<String> crewNames = new ArrayList<>();
        crewNames.add("joy");
        crewNames.add("sad");
        crewNames.add("mad");
        crewNames.add("keke");
        crewNames.add("aaa");
        Crews crews = new Crews(crewNames, Course.BACKEND);
        assertThat(crews.matchPair(new PairHistory(), Level.LEVEL1).size()).isEqualTo(2);
        assertThat(crews.matchPair(new PairHistory(), Level.LEVEL1).size()).isEqualTo(3);
    }

}
