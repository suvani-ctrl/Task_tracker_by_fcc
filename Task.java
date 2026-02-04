import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;

public class Task {
        public String id;
        public String taskDescription;
        public String username;
        public String displayName;
        public String createdAt;
        public String updatedAt;
        public String status;

        public Task(
            String id,
            String taskDescription,
            String username,
            String displayName,
            String createdAt,
            String updatedAt,
            String status
        )
           { this.id = id;
            this.taskDescription = taskDescription;
            this.username = username;
            this.displayName = displayName;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.status = status;}
        
    
}
