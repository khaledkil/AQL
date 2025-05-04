
package org.example.tp3;


import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    public Task() {}

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    // equals & hashCode pour les tests
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return title.equals(task.title) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + description.hashCode();
    }

    public String getName() {
        return this.title;
    }
}
