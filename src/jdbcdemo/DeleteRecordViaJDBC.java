package jdbcdemo;

import java.sql.*;

public class DeleteRecordViaJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String sql = "DELETE FROM employees WHERE firstName='Ercan'";

            int rowsAffected = statement.executeUpdate(sql);

            System.out.println("Rows affected:" + rowsAffected);

            System.out.println("Delete complete");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
