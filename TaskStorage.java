import java.io.FileWriter;
import java.util.ArrayList;

//To add the tasks on Tasks.json
public class TaskStorage {
    public static String saveToFile( ArrayList<Tasktracker.Task> tasks){
    StringBuilder jsonBuilder = new StringBuilder();
    jsonBuilder.append("[\n");
    for (int i=0; i<tasks.size(); i++){
        Tasktracker.Task t = tasks.get(i);
        jsonBuilder.append("  { \"id\": ").append(t.id)
                  .append(", \"desc\": \"").append(t.taskDescription)
                  .append("\" }");
        if (i < tasks.size() -1 ){
            jsonBuilder.append(",");
        }
        jsonBuilder.append("\n");
    }
    jsonBuilder.append("]");
    try (FileWriter writer = new FileWriter("Tasks.json")){
        writer.write(jsonBuilder.toString());
    } catch (Exception e) {
        return "Error:" + e.getMessage();
    }
return "File saved successfully";
}
}


