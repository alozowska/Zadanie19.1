package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String description;
    private Person person;
    private int points;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime localDateTime;

    public Task() {
    }

    public Task(Long id,String description, Person person, int points, LocalDateTime localDateTime) {
        this.id = id;
        this.description = description;
        this.person = person;
        this.points = points;
        this.localDateTime = localDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }
}
