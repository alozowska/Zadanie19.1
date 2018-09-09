package com.example.demo;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository() {
        tasks = new ArrayList<>();
        tasks.add(new Task(1L, "Mycie podłóg", new Person("Janek"), 3, LocalDateTime.of(2018, 10, 7, 18, 0)));
        tasks.add(new Task(2L, "Malowanie", new Person("Zosia"), 10, LocalDateTime.of(2018, 12, 1, 18, 0)));
        tasks.add(new Task(3L, "Wyniesienie śmieci", new Person("Zosia"), 1, LocalDateTime.of(2018, 9, 9, 9, 0)));
    }

    public void save(Task task) {
        tasks.add(task);
    }

    public Task find(Long id){
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findAny().get();
    }

    public List<Task> getAll() {
        return tasks;
    }
}
