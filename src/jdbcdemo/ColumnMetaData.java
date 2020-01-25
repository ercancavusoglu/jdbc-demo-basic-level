package jdbcdemo;

import java.sql.*;

public class ColumnMetaData {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(
                    url, user, password
            );

            // 2. Run query
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employees");

            // 3. Get result set metadata
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            // 4. Display info
            int columnCount = resultSetMetaData.getColumnCount();

            for (int column = 1; column < columnCount; column++) {
                System.out.println("Column Name:" + resultSetMetaData.getColumnName(column));
                System.out.println("Column Type Name:" + resultSetMetaData.getColumnTypeName(column));
                System.out.println("Is Nullable:" + resultSetMetaData.isNullable(column));
                System.out.println("Is Auto Increment:" + resultSetMetaData.isAutoIncrement(column));
                System.out.println("--------------");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
