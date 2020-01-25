package jdbcdemo;

import java.sql.*;

public class MetaDataWithTable {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String columnNamePattern = null;
        String[] types = null;

        Connection connection = null;
        ResultSet resultSet = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(
                    url, user, password
            );

            // 2. Get metadata
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            System.out.println("List of tables");
            resultSet = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("TABLE_NAME"));
            }

            System.out.println("List of columns");
            resultSet = databaseMetaData.getColumns(catalog, schemaPattern, "employees",columnNamePattern);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("COLUMN_NAME"));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {


            connection.close();
        }
    }
}
