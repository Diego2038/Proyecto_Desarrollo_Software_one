/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i.modelo;

import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class Variable {
    private static Variable instance;
    // Datos Usuario
    private static ArrayList<String> usuario_id_usuario;
    private static ArrayList<String> usuario_password;
    private static ArrayList<String> usuario_estado;
    private static ArrayList<String> usuario_nombre;
    private static ArrayList<String> usuario_cedula;
    private static ArrayList<String> usuario_telefono;
    private static ArrayList<String> usuario_correo;
    private static ArrayList<String> usuario_sueldo_base;
    private static ArrayList<String> usuario_cargo;
    private static ArrayList<String> usuario_fecha_de_registro;
    
    // Datos Usuario desvinculado;
    private static ArrayList<String> usuario_desvinculado_id_usuario;
    private static ArrayList<String> usuario_desvinculado_fecha_desvinculacion;
    
    //
    
    //
    public static Variable getInstance(){
        return new Variable();
    }

    public static ArrayList<String> getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public static ArrayList<String> getUsuario_password() {
        return usuario_password;
    }

    public static ArrayList<String> getUsuario_estado() {
        return usuario_estado;
    }

    public static ArrayList<String> getUsuario_nombre() {
        return usuario_nombre;
    }

    public static ArrayList<String> getUsuario_cedula() {
        return usuario_cedula;
    }

    public static ArrayList<String> getUsuario_telefono() {
        return usuario_telefono;
    }

    public static ArrayList<String> getUsuario_correo() {
        return usuario_correo;
    }

    public static ArrayList<String> getUsuario_sueldo_base() {
        return usuario_sueldo_base;
    }

    public static ArrayList<String> getUsuario_cargo() {
        return usuario_cargo;
    }

    public static ArrayList<String> getUsuario_fecha_de_registro() {
        return usuario_fecha_de_registro;
    }

    public static ArrayList<String> getUsuario_desvinculado_id_usuario() {
        return usuario_desvinculado_id_usuario;
    }

    public static ArrayList<String> getUsuario_desvinculado_fecha_desvinculacion() {
        return usuario_desvinculado_fecha_desvinculacion;
    }
    
    
    
}
