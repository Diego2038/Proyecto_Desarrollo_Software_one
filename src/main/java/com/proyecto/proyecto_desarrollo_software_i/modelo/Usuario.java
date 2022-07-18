/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit template
 */
package com.proyecto.proyecto_desarrollo_software_i.modelo;

/**
 *
 * @author juand
 */
// Patrón Singleton
public class Usuario {
    
    private static Usuario instance;
    private static String id;
    private static String nombre;
    private static String cedula;
    private static String cargo;
    
    public static Usuario getInstance(){
        return new Usuario();
    }
    
    public static void conectar(String id, String nombre, String cedula,
            String cargo){
        Usuario.id = id;
        Usuario.nombre = nombre;
        Usuario.cedula = cedula;
        Usuario.cargo = cargo;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Usuario.id = id;
    }

    public static String getCedula() {
        return cedula;
    }

    public static void setCedula(String cedula) {
        Usuario.cedula = cedula;
    }

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        Usuario.cargo = cargo;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Usuario.nombre = nombre;
    }
    
    
    
}
