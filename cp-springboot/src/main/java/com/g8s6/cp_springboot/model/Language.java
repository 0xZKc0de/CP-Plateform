package com.g8s6.cp_springboot.model;

public enum Language {
    JAVA("Java", "OpenJDK 17"),
    PYTHON("Python", "Python 3.10"),
    CPP("C++", "GNU GCC 17"),
    JAVASCRIPT("JavaScript", "Node.js 18"),
    C("C", "GNU GCC 17"),
    RUBY("Ruby", "Ruby 3.1"),
    GO("Go", "Go 1.20"),
    KOTLIN("Kotlin", "Kotlin 1.7"),
    SWIFT("Swift", "Swift 5.7"),
    PASCAL("Pascal", "Free Pascal 3.2"),
    PHP("PHP", "PHP 8.1");

    private final String displayName;
    private final String version;

    Language(String displayName, String version) {
        this.displayName = displayName;
        this.version = version;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getVersion() {
        return version;
    }
}
