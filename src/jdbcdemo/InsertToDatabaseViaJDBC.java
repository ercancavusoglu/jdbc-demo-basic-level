package jdbcdemo;

import java.sql.*;

public class InsertToDatabaseViaJDBC {

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
            String sql = "INSERT INTO customers" +
                    "(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit)" +
                    " values(" +
                    "'497','Java','Cavusoglu','Ercan','905381234567','Address 1','Address 2','Istanbul','Bahcelievler','34191','Turkey',123,100" +
                    ")";

            statement.executeUpdate(sql);

            System.out.println("Insert completed");

            // 4. Close the statement
            statement.close();

            // 5. Close the connection
            connection.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}
