package jdbcdemo;

import java.sql.*;

public class GetResultSetFromDatabaseViaJDBC {

    public static void main(String[] args) {

        try {
            // 1. Get a connection to database
            Connection myConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "root", "1qazxsw2"
            );

            // 2. Create a statement
            Statement myStatement = myConnection.createStatement();

            // 3. Execute sql query
            ResultSet resultSet = myStatement.executeQuery("SELECT * FROM employees");

            // 4. Process the result set
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("lastName") + " " + resultSet.getString("firstName")
                );
            }

            resultSet.close();
            myConnection.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
