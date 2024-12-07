package pairmatching;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CrewsTest {
    /*@Test
    void 미션을_함께_수행할_페어를_두명씩_매칭한다() {

    }*/

    @Test
    void 크루_목록_순서를_랜덤으로_섞는다() {
        List<String> crewNames = CrewNameParser.getNames(Course.BACKEND);
        Crews crews = new Crews(new ArrayList<>(crewNames));
        List<String> shuffled = crews.shuffle();
    }
}
