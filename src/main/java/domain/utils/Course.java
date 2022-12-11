package domain.utils;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String get() {
        return this.name;
    }

    // 추가 기능 구현
}