
public class DatabaseConnection {

    // Single instance
    private static volatile DatabaseConnection instance;

    private String connectionId;

    // Private constructor
    private DatabaseConnection() {
        connectionId = "DB-" + System.currentTimeMillis();
        System.out.println("Database Connection Created: " + connectionId);
    }

    // Thread-safe Singleton
    public static DatabaseConnection getInstance() {

        if (instance == null) { // First check

            synchronized (DatabaseConnection.class) {

                if (instance == null) { // Second check
                    instance = new DatabaseConnection();
                }
            }
        }

        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("[" + connectionId + "] Executing Query: " + query);
    }

    public String getConnectionId() {
        return connectionId;
    }
}
