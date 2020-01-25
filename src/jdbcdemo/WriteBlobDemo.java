package jdbcdemo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class WriteBlobDemo {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        FileInputStream fileInputStream = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(
                    url, user, password
            );

            // 2. Prepare statement
            String sql = "UPDATE employees SET resume=? WHERE email='ercancavusoglu@yandex.com.tr'";
            preparedStatement = connection.prepareStatement(sql);

            // 3. Set parameter for resume file name

            File file = new File("sample_resume.pdf");
            fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(1, fileInputStream);
            System.out.println("Reading input file " + file.getAbsolutePath());

            // 4. Execute statement
            System.out.println("Storing resume in database " + file);
            System.out.println(sql);
            preparedStatement.executeUpdate();

            System.out.println("Completed successfully");

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            preparedStatement.close();

            connection.close();
        }
    }
}
