package pairmatching.dto;

import pairmatching.Course;
import pairmatching.Level;
import pairmatching.Mission;

public class StepRequest {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public StepRequest(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static StepRequest of(String input) {
        String[] split = input.split(", ");
        return new StepRequest(
            Course.from(split[0]),
            Level.from(split[1]),
            Mission.from(split[2]));
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
