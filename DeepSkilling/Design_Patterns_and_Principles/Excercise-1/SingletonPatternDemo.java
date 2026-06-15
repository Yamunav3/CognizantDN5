public class SingletonPatternDemo {

        public static void main(String[] args) {

                DatabaseConnection db1 = DatabaseConnection.getInstance();

                DatabaseConnection db2 = DatabaseConnection.getInstance();

                db1.executeQuery("SELECT * FROM USERS");

                System.out.println("Connection ID 1: "
                                + db1.getConnectionId());

                System.out.println("Connection ID 2: "
                                + db2.getConnectionId());

                System.out.println("Same Object? "
                                + (db1 == db2));
        }
}