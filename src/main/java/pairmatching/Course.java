package pairmatching;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String name) {
        return Arrays.stream(values())
            .filter(course -> course.name.equals(name))
            .findAny()
            .orElse(null);
    }

    // 추가 기능 구현
}
