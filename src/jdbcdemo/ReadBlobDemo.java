package jdbcdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class ReadBlobDemo {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "1qazxsw2";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(
                    url, user, password
            );

            // 2. Prepare statement
            statement = connection.createStatement();
            String sql = "SELECT resume FROM employees WHERE email='ercancavusoglu@yandex.com.tr'";
            resultSet = statement.executeQuery(sql);

            // 3. Set parameter for resume file name

            File file = new File("resume_from_db.pdf");
            fileOutputStream = new FileOutputStream(file);

            if (resultSet.next()) {

                inputStream = resultSet.getBinaryStream("resume");
                System.out.println("Reading resume from database");

                byte[] buffer = new byte[1024];

                while (inputStream.read(buffer) > 0) {
                    fileOutputStream.write(buffer);
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (fileOutputStream != null) {
                fileOutputStream.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}
