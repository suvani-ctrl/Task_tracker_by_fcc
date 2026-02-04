
import java.util.UUID;

public class TaskIdGenerator {
    public static String generateUniqueTaskId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
