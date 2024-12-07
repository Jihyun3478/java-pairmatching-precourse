package pairmatching;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static Level from(String name) {
        return Arrays.stream(values())
            .filter(level -> level.name.equals(name))
            .findAny()
            .orElse(null);
    }

    public List<Mission> getMissions() {
        return Mission.from(this);
    }
}
