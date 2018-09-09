package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<Task> tasks = taskRepository.getAll();
        model.addAttribute("tasks", tasks);
        return "homepage";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("task", new Task());
        return "save";
    }

    @GetMapping("/update")
    public String update(Model model) {
        model.addAttribute("IdDto", new IdDto());
        return "searchTask";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute IdDto id,Model model) {
        Task task = taskRepository.find(id.getId());
        model.addAttribute("taskToUpdate",task);

        return "update";
    }

    //task ktory updatujesz, zapisujesz poprostu na nowo tutaj
    @PostMapping("/save-task")
    public String save(@ModelAttribute Task task, Model model) {
        taskRepository.save(task);
        List<Task> tasks = taskRepository.getAll();
        model.addAttribute("tasks", tasks);
        return "homepage";
    }
}
