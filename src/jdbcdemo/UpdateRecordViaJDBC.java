package jdbcdemo;

import java.sql.*;

public class UpdateRecordViaJDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        try {
            // 1. Get a connection to database
            Connection connection = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Execute sql query
            String sql = "UPDATE `employees` SET " +
                    "`lastName`='Cavusoglu'," +
                    "`firstName`='Ercan'," +
                    "`email`='ercancavusoglu@yandex.com.tr'," +
                    "`jobTitle`='Software Developer' " +
                    "WHERE employeeNumber=1002";

            statement.executeUpdate(sql);

            System.out.println("Update completed");

            // 4. Close the statement
            statement.close();

            // 5. Close the connection
            connection.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
