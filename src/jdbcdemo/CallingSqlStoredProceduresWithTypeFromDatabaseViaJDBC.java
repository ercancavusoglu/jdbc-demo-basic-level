package jdbcdemo;

import java.sql.*;

public class CallingSqlStoredProceduresWithTypeFromDatabaseViaJDBC {

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        CallableStatement callableStatement = null;

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(
                    url, user, password
            );

            String theDepartment = "Engineering";

            System.out.println("Salaries Before");

            callableStatement = connection.prepareCall("{call increase_salaries_for_department(?)}");

            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(1, theDepartment);

            System.out.println("Calling stored procedure. ");
            callableStatement.execute();
            System.out.println("Finished calling stored procedure");

            String theResult = callableStatement.getString(1);
            System.out.println("The result = " + theResult);

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            callableStatement.close();
            connection.close();
        }
    }
}
