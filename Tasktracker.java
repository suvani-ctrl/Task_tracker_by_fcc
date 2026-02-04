import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Tasktracker {
    static HashMap <String,Task> taskMap = new HashMap<>();
    static Scanner  scanner = new Scanner (System.in);
    

    public static void listTask(){

        if(new File("MyTasks.json").isFile())
        {

        }
        else{
            System.out.println("No tasks found");
            return;
        }

    }

    public static String deleteTask(String id){

           if( taskMap.remove(id) == null ){
            return "Task with such id was not found";
           }
           
        return "Task deletion successfull!";
    }

    public static String updateTask(String id,String taskDescription){

        if(!taskMap.containsKey(id)){
            return "Task with such id was not found";
        }
            Task t = taskMap.get(id);
            t.taskDescription = taskDescription;
            t.updatedAt = LocalDateTime.now().toString();
            return "Task update successfull";
    
    }


    public static String taskProgress(String id, String status){
        if(!taskMap.containsKey(id)){
            return "Task with such is not found";
        }else{
            Task t =  taskMap.get(id);
            t.updatedAt = LocalDateTime.now().toString();
            t.status = status;
            return "Task Markeded successfull";
        }
    }

    public static String create_task(){
        System.out.println("Enter the username:");
        String username = scanner.nextLine();
        System.out.println("Enter the display name:");
        String displayname = scanner.nextLine();
        System.out.println("Enter the task description:");
        String taskDescription = scanner.nextLine();
        String uniqueId = TaskIdGenerator.generateUniqueTaskId();
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
        File file = new File("MyTasks.json");
        if(file.isFile()){
            System.out.println("Found the file!");
        }else{
            System.out.println("No previous file found");
        }
        boolean program_start = true;

        while(program_start){
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
                    System.out.println(create_task());
                    SaveJson.saveJson(taskMap);
                    break;
                case "2":
                    listTask();
                    break;
                case "3":
                    System.out.println("Enter the unique task id :");
                    String id2 = scanner.nextLine();
                    System.out.println("New task description:");
                    String task_now = scanner.nextLine();
                    updateTask(id2,task_now);
                    SaveJson.saveJson(taskMap);
                    break;
                case "4":
                    System.out.println("Enter the unique task id:");
                    String id1 = scanner.nextLine();
                    deleteTask(id1);
                    SaveJson.saveJson(taskMap);
                    break;
                
                case "5":
                    System.out.println("Pass the unique task id");
                    String id3 = scanner.nextLine();
                    System.out.println("Update the status");
                    String status = scanner.nextLine();
                    System.out.println(taskProgress(id3, status));
                    SaveJson.saveJson(taskMap);
                    break;

                case "6":
                    System.out.println("Bye");
                    System.exit(0);
                    program_start = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}

