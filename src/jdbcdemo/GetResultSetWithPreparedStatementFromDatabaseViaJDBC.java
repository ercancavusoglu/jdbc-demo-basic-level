package jdbcdemo;

import java.sql.*;

public class GetResultSetWithPreparedStatementFromDatabaseViaJDBC {

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "root", "1qazxsw2"
            );

            // 2. Create a statement
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employees WHERE officeCode > ? and jobTitle = ?"
            );

            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Sales Rep");

            // 3. Execute sql query
            resultSet = preparedStatement.executeQuery();

            // 4. Process the result set
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("lastName") + " " + resultSet.getString("firstName")
                );
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            resultSet.close();
            connection.close();
        }
    }
}
