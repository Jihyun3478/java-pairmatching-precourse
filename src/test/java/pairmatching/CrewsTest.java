package pairmatching;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CrewsTest {
    @Test
    void 미션을_함께_수행할_페어를_두명씩_매칭한다() {
        List<String> crewNames = CrewNameParser.getNames(Course.BACKEND);
        Crews crews = new Crews(crewNames, Course.BACKEND);

        Pair pair = crews.matchPair();
    }
}
