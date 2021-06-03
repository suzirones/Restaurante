package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public Connection getConnection() {
     try {
            return DriverManager.getConnection(
            		"jdbc:mysql://127.0.0.1:3306/restaurante?useTimezone=true&serverTimezone=UTC", "root", "mysql@2020");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   
    }
}
