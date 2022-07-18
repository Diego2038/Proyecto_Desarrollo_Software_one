/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i.sql;

import com.proyecto.proyecto_desarrollo_software_i.modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juand
 */
public class Conectar {
    Connection con = null;
    String url = "jdbc:postgresql://ec2-3-219-229-143.compute-1.amazonaws.com:5432/da279dugkkpikd";
    String usuario = "sedldotfyfwbgd";
    String password = "fbc133b16bbbd0c6d5cf53f54bb7ccf73366fd3ab0f3b5bd2e5bc45c1bd3dddb";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,usuario,password);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al momento de conectar: " + e.getMessage());
        } return con;
    }
}
