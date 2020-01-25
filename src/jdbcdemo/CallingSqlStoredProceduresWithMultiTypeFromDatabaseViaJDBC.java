package jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallingSqlStoredProceduresWithMultiTypeFromDatabaseViaJDBC {

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

            callableStatement = connection.prepareCall("{call increase_salaries_for_department(?,?)}");

            callableStatement.setString(1, theDepartment);
            callableStatement.registerOutParameter(2, Types.INTEGER);

            System.out.println("Calling stored procedure. ");
            callableStatement.execute();
            System.out.println("Finished calling stored procedure");

            int theCount = callableStatement.getInt(2);
            System.out.println("The count = " + theCount);

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            callableStatement.close();
            connection.close();
        }
    }
}
