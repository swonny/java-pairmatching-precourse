package contatants;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourseByName(String name) {
        for (Course course : Course.values()) {
            if (course.name.equals(name)) {
                return course;
            }
        }
        throw new IllegalArgumentException("백엔드, 프론트엔드 중 입력하세요.");
    }

    public String getName() {
        return this.name;
    }

    public boolean isFrontend() {
        return this == FRONTEND;
    }
}