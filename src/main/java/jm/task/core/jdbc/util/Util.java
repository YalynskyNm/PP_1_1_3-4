package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "75091";

    public static Connection getConnection () throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection (Connection connection) throws SQLException {
        connection.close();
    }
}
