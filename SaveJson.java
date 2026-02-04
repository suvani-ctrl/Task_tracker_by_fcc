import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveJson {
     public static String saveJson(HashMap<String,Task> final_map){
        ArrayList <Task> final_list = new ArrayList<>(final_map.values());
        try {
            FileWriter writer = new FileWriter("MyTasks.json");
            String jsonString = "[";
            writer.write(jsonString);
           for (int i = 0; i< final_list.size(); i++){
            Task t = final_list.get(i);
            writer.write("{\"id\":\"" + t.id + "\", \"desc\":\"" + t.taskDescription + "\"}");
            if (i < final_list.size() -1){
                writer.write(",");
            }
           }
           writer.write("]");
           writer.close();
        } catch (Exception e) {
            System.out.println("error occured"+ e);
        }
        return "Sucessful saved to json";
    }   
}
