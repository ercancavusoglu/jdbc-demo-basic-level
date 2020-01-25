package jdbcdemo;

import java.sql.*;

public class CallingSqlStoredProceduresFromDatabaseViaJDBC {

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "root", "1qazxsw2"
            );

            String theDepartment = "Engineering";
            int theIncreaseAmount = 1000;

            System.out.println("Salaries Before");

            callableStatement = connection.prepareCall("{call increase_salaries_for_department(?,?)}");
            callableStatement.setString(1, theDepartment);
            callableStatement.setDouble(2, theIncreaseAmount);

            System.out.println("Calling stored procedure. ");
            callableStatement.execute();
            System.out.println("Finished calling stored procedure");

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            callableStatement.close();
            connection.close();
        }
    }
}
