/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Roberto
 */
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
