package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@SpringBootApplication
public class DemoApplication {
    private static final String URL = "jdbc:mysql://localhost:3306/your_db_name";
    private static final String USER = "root";
    private static final String PASSWORD = "myNewPass@123";
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}