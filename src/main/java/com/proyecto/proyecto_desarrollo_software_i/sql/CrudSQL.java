/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juand
 */
public class CrudSQL extends Conectar{
    private Statement sentencia;
    private ResultSet result;
    
    public int ingresarUsuario(String usuario, String password){
        int validador = 0;
        // 1 = vendedor, 2 = jefe de taller, 3 = gerente, 0 = Usuario o password incorrecto
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT cargo FROM usuario "
                    + "WHERE cedula = '"+usuario+"' AND password = '"+password+"';";
            result = sentencia.executeQuery(sql);
            if(result.next()){
                System.out.println("Login correcto, el usuario es un " + result.getString("cargo"));
                String cargo = result.getString("cargo");
                String op1 = "vendedor";
                String op2 = "jefe de taller";
                String op3 = "gerente";
                if(cargo.equals(op1)){
                    validador = 1;  
                }else if(cargo.equals(op2)){
                    validador = 2;
                }else if(cargo.equals(op3)){
                    validador = 3;
                }
            }else{
                System.out.println("Usuario y/o password incorrecto");
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta: " + e.getMessage());
        }
        return validador;
    }
    
}
