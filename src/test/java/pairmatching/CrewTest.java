package pairmatching;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CrewTest {
    /*@Test
    void 미션을_함께_수행할_페어를_두명씩_매칭한다() {

    }*/

    @Test
    void 크루_이름을_불러온다() {
        List<String> frontCrews = CrewNameParser.getNames(Course.FRONTEND);
        assertThat(frontCrews.size()).isGreaterThan(0);

        List<String> backendCrews = CrewNameParser.getNames(Course.BACKEND);
        assertThat(backendCrews.size()).isGreaterThan(0);
    }
}
