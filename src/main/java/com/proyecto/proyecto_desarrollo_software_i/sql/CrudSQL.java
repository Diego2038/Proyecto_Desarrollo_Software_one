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
        int VALIDADOR = 0;
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
                String OP1 = "vendedor";
                String OP2 = "jefe de taller";
                String OP3 = "gerente";
                if(cargo.equals(OP1)){
                    VALIDADOR = 1;  
                }else if(cargo.equals(OP2)){
                    VALIDADOR = 2;
                }else if(cargo.equals(OP3)){
                    VALIDADOR = 3;
                }
            }else{
                System.out.println("Usuario y/o password incorrecto");
            }
            
        } catch (SQLException e) {
            System.err.println("Error de consulta: " + e.getMessage());
        }
        return VALIDADOR;
    }
    
    // Hay que sobrecargar este método (ELIMINAR ESTO CUANDO SE PRUEBEN crud_registrar
    public void gerente_registrarUsuario(String password, String nombre, String cedula, String telefono,
            String correo, String sueldo_base, String cargo, String fecha_de_registro){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO usuario(password,estado,nombre,cedula,telefono,correo,"
                    + "sueldo_base,cargo,fecha_de_registro) VALUES('"+password+"','activo',"
                    + "'"+nombre+"','"+cedula+"','"+telefono+"','"+correo+"','"+sueldo_base+"',"
                    + "'"+cargo+"','"+fecha_de_registro+"')";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    /**
     * 
     * @param tabla
     * @param nombreDato1
     * @param nombreDato2
     * @param valorDato1
     * @param valorDato2 
     * Método encargado de registrar una tupla en la base de datos según el nombre de
     * la tabala a la que se le ingrese.
     */
    public void crud_registrar(String tabla, String nombreDato1, String nombreDato2,
            String valorDato1, String valorDato2){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO "+tabla+"("+nombreDato1+","+nombreDato2+") "
                    + "VALUES('"+valorDato1+"','"+valorDato2+"');";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    // Ingresar 3 datos
    public void crud_registrar(String tabla, String nombreDato1, String nombreDato2,
            String nombreDato3, String valorDato1, String valorDato2, String valorDato3){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO "+tabla+"("+nombreDato1+","+nombreDato2+","+nombreDato3+") "
                    + "VALUES('"+valorDato1+"','"+valorDato2+"','"+valorDato3+"');";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    // Ingresar 4 datos
    public void crud_registrar(String tabla, String nombreDato1, String nombreDato2,
            String nombreDato3, String nombreDato4, String valorDato1, String valorDato2, 
            String valorDato3, String valorDato4){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO "+tabla+"("+nombreDato1+","+nombreDato2+","+nombreDato3+","+nombreDato4+") "
                    + "VALUES('"+valorDato1+"','"+valorDato2+"','"+valorDato3+"','"+valorDato4+"');";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    // Ingresar 5 datos
    public void crud_registrar(String tabla, String nombreDato1, String nombreDato2, String nombreDato3, 
            String nombreDato4, String nombreDato5, String valorDato1, String valorDato2, String valorDato3, 
            String valorDato4, String valorDato5){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO "+tabla+"("+nombreDato1+","+nombreDato2+","+nombreDato3+","+nombreDato4+","
                    +nombreDato5+") "+ "VALUES('"+valorDato1+"','"+valorDato2+"','"+valorDato3+"','"+valorDato4
                    +"','"+valorDato5+"');";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    // Ingresar 6 datos
    public void crud_registrar(String tabla, String nombreDato1, String nombreDato2, String nombreDato3, 
            String nombreDato4, String nombreDato5, String nombreDato6, String valorDato1, String valorDato2, 
            String valorDato3, String valorDato4, String valorDato5, String valorDato6){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO "+tabla+"("+nombreDato1+","+nombreDato2+","+nombreDato3+","+nombreDato4+","
                    +nombreDato5+","+nombreDato6+") "+ "VALUES('"+valorDato1+"','"+valorDato2+"','"+valorDato3+"','"
                    +valorDato4+"','"+valorDato5+"','"+valorDato6+"');";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    // Ingresar 7 datos
    public void crud_registrar(String tabla, String nombreDato1, String nombreDato2, String nombreDato3, 
            String nombreDato4, String nombreDato5, String nombreDato6, String nombreDato7, String valorDato1, 
            String valorDato2, String valorDato3, String valorDato4, String valorDato5, String valorDato6,
            String valorDato7){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO "+tabla+"("+nombreDato1+","+nombreDato2+","+nombreDato3+","+nombreDato4+","
                    +nombreDato5+","+nombreDato6+","+nombreDato7+") "+ "VALUES('"+valorDato1+"','"+valorDato2+"','"
                    +valorDato3+"','"+valorDato4+"','"+valorDato5+"','"+valorDato6+"','"+valorDato7+"');";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    // Ingresar 9 datos
    public void crud_registrar(String tabla, String nombreDato1, String nombreDato2, String nombreDato3, 
            String nombreDato4, String nombreDato5, String nombreDato6, String nombreDato7, String nombreDato8,
            String nombreDato9, String valorDato1, String valorDato2, String valorDato3, String valorDato4, 
            String valorDato5, String valorDato6, String valorDato7, String valorDato8, String valorDato9){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO "+tabla+"("+nombreDato1+","+nombreDato2+","+nombreDato3+","+nombreDato4+","
                    +nombreDato5+","+nombreDato6+","+nombreDato7+","+nombreDato8+","+nombreDato9+") "
                    +"VALUES('"+valorDato1+"','"+valorDato2+"','"+valorDato3+"','"+valorDato4+"','"+valorDato5
                    +"','"+valorDato6+"','"+valorDato7+"','"+valorDato8+"','"+valorDato9+"');";
            sentencia.execute(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    // Se puede reutilizar múltiples veces
    public void crud_modificar(String tabla, String condicion, String actualizacion, 
            String nombreDato, String valorDato){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql;
            sql = "UPDATE "+tabla+" SET "+condicion+" = "+actualizacion+" "
                        + "WHERE "+nombreDato+" = '"+valorDato+"'";
            sentencia.executeUpdate(sql);
            System.out.println("La actualización se hizo correctamente");
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    // Se puede reutilizar múltiples veces
    public String crud_buscar(String tabla, String nombreVariable,
            String valorVariable, String extensionBusqueda){
        String resultado = "";
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM "+tabla+" WHERE "+nombreVariable+"='"+valorVariable+"';";
            result = sentencia.executeQuery(sql);
            if(extensionBusqueda.equals("global")){
                resultado = "RESULTADOS GLOBALES\n";
                // OJO, AQUÍ TE VA TOCAR QUE CREAR UNA CLASE PARA GUARDAR LAS VARIABLES
                // ASÍ PODRÁS MOSTRARLAS TODAS EN UNA TABLA MÁS BONITA
                while(result.next()){
                    resultado = resultado+result.getString("nombre")+" "+result.getString("cedula")+
                            result.getString("cargo")+" "+result.getString("telefono")+"\n";
                }
            }else{
                if(result.next()){
                    resultado = result.getString("nombre")+" "+result.getString("cedula")+
                            result.getString("cargo")+" "+result.getString("telefono");
                }else{
                    resultado = "Usuario no encontrado";
                }
            }
        } catch (SQLException e) {
            System.err.println("Error búsqueda: " + e.getMessage());
        }
        return resultado;
    }
    
    // PODRÍAS PONER UN SCROLL DE BÚSQUEDAS, PARA QUE NO TENGAS QUE PREOCUPARTE POR NOMBRES 
    // INCOMPLETOS, O TENGAS LAS ID'S
    
    
    
}
