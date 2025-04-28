package org.example.tp3;

public class User {
    private long id;
    private String name;

    // Constructor
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
