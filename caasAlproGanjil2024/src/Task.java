package caasAlproGanjil2024.src;

import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String name, LocalDate dueDate) {
        this.name = name;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeTask() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}

