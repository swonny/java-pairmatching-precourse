package constant;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", 0),
    FRONTEND("프론트엔드", 1);

    private final int repositoryIndex;
    private String name;

    Course(String name, int repositoryIndex) {
        this.name = name;
        this.repositoryIndex = repositoryIndex;
    }

    public static Course getCourseByName(String courseName) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("백엔드, 프론트엔드 중 입력하세요."));
    }

    public int getRepositoryIndex() {
        return this.repositoryIndex;
    }
}