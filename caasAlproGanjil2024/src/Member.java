package caasAlproGanjil2024.src;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Task> tasks;

    public Member(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                task.completeTask();
                System.out.println("Task '" + taskName + "' marked as completed.");
                return;
            }
        }
        System.out.println("Task '" + taskName + "' not found.");
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
