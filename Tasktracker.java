import java.util.Scanner;
import UUIDGenerator;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.rmi.server.UID;

public class Tasktracker {
    static HashMap <String,Task> taskMap = new HashMap<>();
    static Scanner  scanner = new Scanner (System.in);
    
    static class Task{
        String id;
        String taskDescription;
        String username;
        String displayName;
        String createdAt;
        String updatedAt;
        String status;

        public Task(
            String id,
            String taskDescription,
            String username,
            String displayName,
            String createdAt,
            String updatedAt,
            String status
        ){
            this.id = id;
            this.taskDescription = taskDescription;
            this.username = username;
            this.displayName = displayName;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.status = status;
        }
    }

    public static String taskProgress(String id, String status){
        if(!taskMap.containsKey(id)){
            System.out.println("Task with such" +id + "was not found");
        }else{
            Task t =  taskMap.get(id);
            t.status = status;
        }
        return "Task Marked + " + status + "successfully!";
    }

    public static String create_task(){
        System.out.println("Enter the username:");
        String username = scanner.nextLine();
        System.out.println("Enter the display name:");
        String displayname = scanner.nextLine();
        System.out.println("Enter the task description:");
        String taskDescription = scanner.nextLine();
        String uniqueId = UUIDGenerator.nextUID();
        String createdAt = LocalDateTime.now().toString();
        String updatedAt = createdAt;
        System.out.println("Enter the task status:");
        String status = scanner.nextLine();
        Task newTask = new Task(
            uniqueId,
            taskDescription,
            username,
            displayname,
            createdAt,
            updatedAt,
            status
        );
        taskMap.put(uniqueId,newTask);
        return "Task has just been created";
    }

    public static void main(String[] args){
        while(true){
            System.out.println("Task Tracker");
            System.out.println("1. Create a Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Update Task");
            System.out.println("4.Status of Task");
            System.out.println("5. Mark task as done");
            System.out.println("Choose:");
            String choice = scanner.nextLine();
            switch(choice){
                case "1":
                    create_task();
                    break;
                case "2":
                    listTask();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    listTask();
                    break;
                case "5":
                    System.out.println("Pass the unique task id");
                    String id = scanner.nextLine();
                    System.out.println("Update the status");
                    String status = scanner.nextLine();
                    taskProgress(id,status);
                    break;
                case "6":
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }

}

