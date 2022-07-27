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
    private static String id = "1";
    private static String nombre= "e";
    private static String cedula= "e";
    private static String cargo= "vendedor";
    private static String sede = "0";
    
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

    public static String getSede() {
        return sede;
    }

    public static void setSede(String sede) {
        Usuario.sede = sede;
    }
    
    
    
}
