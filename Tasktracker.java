import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Tasktracker {

    
    static class Task{
        long id;
        String taskDescription;
        String username;
        String displayName;
        String createdAt;
        String updatedAt;

        public Task(
            long id,
            String taskDescription,
            String username,
            String displayName,
            String createdAt,
            String updatedAt
        ){
            this.id = id;
            this.taskDescription = taskDescription;
            this.username = username;
            this.displayName = displayName;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }
    }


      public static String listTask(){
        if(Tasks.isEmpty()){
            System.out.println("No tasks found");
            return "No tasks fond";
        }
        try (FileWriter fw = new FileWriter("tasks.json")){
            fw.write("[");
            for (int i = 0 ; i<Tasks.size(); i++){
                Task t = Tasks.get(i);
                fw.write("{\"id\":" + t.id +
                     ",\"description\":\"" + t.taskDescription + "\"" +
                     ",\"username\":\"" + t.username + "\"}");
                     if (i < Tasks.size() - 1) fw.write(",");
            }
            fw.write("]");
            System.out.println("Tasks saved to json");
            
        } catch (Exception e) {
                e.printStackTrace();
        }
        return "Tasks are listed";
    }
        

    public static String markTaskAsDone(){

        return "Task Marked As Done";
    }


    private static String UserProfile(){
       String username = scanner.nextLine();
          System.out.println("Enter the username:");
       System.out.println("Enter the display name:");
        String displayname = scanner.nextLine();
        System.out.println("Enter the task Description:");
        String taskDescription = scanner.nextLine();
        System.out.println("!!! Wait while we grant you a task Id !!!");
        String createdAt = LocalDateTime.now().toString();
        String updatedAt = createdAt;
        return "Profile created for" + username + "with display name of"+ displayname + "named"+ taskDescription + "created at"+createdAt+"updated at last:" + updatedAt;
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
                    String message = createuserProfile();
                    System.out.println(message);
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
                    markTaskAsDone();
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

