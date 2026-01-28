import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Tasktracker {

    private static ArrayList<String> tasks = new ArrayList<>();

    public static void updateTask(String[] args){
    


    }

    public static void deleteTask(String[] args){

    }

    public static void editTask(String[] args){

    }
    public static void listTask(){
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
            return;
        }
        System.out.println("Your tasks: ");
        for(String task: tasks){
            System.out.println(" . "+task);
        }
    }

    public static void markTaskAsDone(){
    

    }


    private static String createuserProfile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username:");
        String username = scanner.nextLine();
        System.out.println("Enter the display name:");
        String displayname = scanner.nextLine();
        System.out.println("Enter the task Description:");
        String taskDescription = scanner.nextLine();
        System.out.println("!!! Wait while we grant you a task Id !!!");
        String createdAt = LocalDateTime.now().toString();
        String updatedAt = createdAt;
        scanner.close();
        return "Profile created for" + username;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
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
                    TaskmarkDone();
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
    }

}
