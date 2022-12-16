package constant;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourseByName(String courseName) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(courseName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("프론트엔드, 백엔드 중 하나를 입력하세요."));
    }

}
