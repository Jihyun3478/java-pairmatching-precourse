package pairmatching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
    자동차경주(Level.LEVEL1),
    로또(Level.LEVEL1),
    숫자야구게임(Level.LEVEL1),

    장바구니(Level.LEVEL2),
    결제(Level.LEVEL2),
    지하철노선도(Level.LEVEL2),

    성능개선(Level.LEVEL4),
    배포(Level.LEVEL4),
    ;

    private final Level level;

    Mission(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public static List<Mission> from(Level level) {
        return Arrays.stream(values())
            .filter(mission -> mission.getLevel().equals(level))
            .collect(Collectors.toList());
    }
}
