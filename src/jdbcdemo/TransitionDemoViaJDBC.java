package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransitionDemoViaJDBC {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        try {
            // 1. Get a connection to database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Turn off auto commit
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            statement.executeUpdate("DELETE FROM employees WHERE firstName='Ercan'");

            statement.executeUpdate("UPDATE employees SET firstName='Azize' WHERE firstName='Ercan'");

            boolean ok = true;

            if (ok) {
                connection.commit();
            } else {
                connection.rollback();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
