package jdbcdemo;

import java.sql.*;

public class MetaDataJDBC {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        try {
            // 1. Get a connection to database
            Connection connection = DriverManager.getConnection(
                    url, user, password
            );

            // 2. Get metadata
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            // 3. Display info about database
            System.out.println("Product name " + databaseMetaData.getDatabaseProductName());
            System.out.println("Product version " + databaseMetaData.getDatabaseProductVersion());

            // 4. Display info about JDBC driver
            System.out.println("JDBC Driver Name " + databaseMetaData.getDriverName());
            System.out.println("JDBC Driver Version " + databaseMetaData.getDriverVersion());

            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {

        }
    }
}
