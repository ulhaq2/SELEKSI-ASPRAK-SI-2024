package caasAlproGanjil2024.src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskListApp {
    private List<Member> members;

    public TaskListApp() {
        this.members = new ArrayList<>();
    }

    public void addMember(String name) {
        members.add(new Member(name));
        System.out.println("Member '" + name + "' added.");
    }

    public void addTask(String memberName, String taskName, LocalDate dueDate) {
        for (Member member : members) {
            if (member.getName().equals(memberName)) {
                member.addTask(new Task(taskName, dueDate));
                System.out.println("Task '" + taskName + "' added to member '" + memberName + "'.");
                return;
            }
        }
        System.out.println("Member '" + memberName + "' not found.");
    }

    public void markTaskAsCompleted(String memberName, String taskName) {
        for (Member member : members) {
            if (member.getName().equals(memberName)) {
                member.markTaskAsCompleted(taskName);
                return;
            }
        }
        System.out.println("Member '" + memberName + "' not found.");
    }

    public void displayTasks(String memberName) {
        for (Member member : members) {
            if (member.getName().equals(memberName)) {
                System.out.println("Tasks for member '" + memberName + "':");
                for (Task task : member.getTasks()) {
                    System.out.println(task);
                }
                return;
            }
        }
        System.out.println("Member '" + memberName + "' not found.");
    }

    public static void main(String[] args) {
        TaskListApp app = new TaskListApp();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\nTask List Application");
            System.out.println("1. Add Member");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    app.addMember(memberName);
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();

                    LocalDate dueDate = null;
                    while (dueDate == null) {
                        System.out.print("Enter due date (yyyy-MM-dd): ");
                        String dueDateStr = scanner.nextLine();
                        try {
                            dueDate = LocalDate.parse(dueDateStr, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                        }
                    }

                    app.addTask(memberName, taskName, dueDate);
                    break;

                case 3:
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    System.out.print("Enter task name: ");
                    taskName = scanner.nextLine();
                    app.markTaskAsCompleted(memberName, taskName);
                    break;

                case 4:
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    app.displayTasks(memberName);
                    break;

                case 5:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
