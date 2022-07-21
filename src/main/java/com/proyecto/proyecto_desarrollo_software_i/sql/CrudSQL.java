/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i.sql;

import com.proyecto.proyecto_desarrollo_software_i.App;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

// ES POSIBLE QUE TAMBIÉN PUEDAS SOBRECARGAR LOS MÉTODOS DE BÚSQUEDA Y MODIFICACIÓN
// RECUERDA QUE MUY SEGURAMENTE DEBAS DE CREAR LA CLASE VARIABLE PARA ALMACENAR LOS DATOS DE LAS 
// VARIABLES QUE SAQUES

// RECORDAR HACER CLASE USUARIO PARA QUE EL VENDEDOR Y JEFE ALMACENEN EL ID DEL GERENTE QUE REGISTRA.

/**
 *
 * @author juand
 */
public class CrudSQL extends Conectar{
    private Statement sentencia;
    private Statement sentencia2;
    private ResultSet result;
    private ResultSet result2;
    
    /**
     * Método encargado de ingresar al usuario al sistema, o deenegarlo en caso de que
     * el usuario y/o la contraseña sean incorrectas
     * @param usuario
     * @param password
     * @return 
     */
    public int ingresarUsuario(String usuario, String password){
        int VALIDADOR = 0;
        // 1 = vendedor, 2 = jefe de taller, 3 = gerente, 0 = Usuario o password incorrecto
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT cargo FROM usuario "
                    + "WHERE cedula = '"+usuario+"' AND password = '"+password+"'"
                    + " AND estado='activo';";
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
            System.out.println(sql);
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
            String valorDato5, String valorDato6, String valorDato7, String valorDato8, String valorDato9) throws SQLException{
        
        Connection conexion = conectar();
        sentencia = conexion.createStatement();
        String sql = "INSERT INTO " + tabla + "(" + nombreDato1 + "," + nombreDato2 + "," + nombreDato3 + "," + nombreDato4 + ","
                + nombreDato5 + "," + nombreDato6 + "," + nombreDato7 + "," + nombreDato8 + "," + nombreDato9 + ") "
                + "VALUES('" + valorDato1 + "','" + valorDato2 + "','" + valorDato3 + "','" + valorDato4 + "','" + valorDato5
                + "','" + valorDato6 + "','" + valorDato7 + "','" + valorDato8 + "','" + valorDato9 + "');";
        sentencia.execute(sql);
        sentencia.close();
        conexion.close();

    }
    
    /**
     * Método encargado de modificar un valor con una condición
     * @param tabla
     * @param condicion
     * @param actualizacion
     * @param nombreDato1
     * @param valorDato1 
     */
    public void crud_modificar(String tabla, String condicion, String actualizacion, 
            String nombreDato1, String valorDato1){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql;
            sql = "UPDATE "+tabla+" SET "+condicion+" = "+actualizacion+" "
                        + "WHERE "+nombreDato1+" = '"+valorDato1+"';";
            sentencia.executeUpdate(sql);
            System.out.println("La actualización se hizo correctamente");
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    /**
     * Método encargado de modificar un valor con dos condiciones
     * @param tabla
     * @param condicion
     * @param actualizacion
     * @param nombreDato1
     * @param valorDato1
     * @param nombreDato2
     * @param valorDato2 
     */
    public void crud_modificar(String tabla, String condicion, String actualizacion, 
            String nombreDato1, String valorDato1, String nombreDato2, String valorDato2){
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql;
            sql = "UPDATE "+tabla+" SET "+condicion+" = "+actualizacion+" "
                        + "WHERE "+nombreDato1+" = '"+valorDato1+"'"
                    +" AND "+nombreDato2+"='"+valorDato2+"';";
            sentencia.executeUpdate(sql);
            System.out.println("La actualización se hizo correctamente");
        } catch (SQLException e) {
            System.err.println("Sucedió un error: " + e.getMessage());
        }
    }
    
    
    /**
     * Método encargado de encontrar una/s tupla/s con una condición de búsqueda
     * @param tabla
     * @param nombreVariable1
     * @param valorVariable1
     * @param extensionBusqueda
     * @return 
     */
    public String crud_buscar(String tabla, String nombreVariable1,
            String valorVariable1, String extensionBusqueda){
        String resultado = "";
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM "+tabla+" WHERE "+nombreVariable1+"='"+valorVariable1+"';";
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
    
    /**
     * Método encargado de encontrar una/s tupla/s con dos condiciones de búsqueda
     * @param tabla
     * @param nombreVariable1
     * @param valorVariable1
     * @param nombreVariable2
     * @param valorVariable2
     * @param extensionBusqueda
     * @return 
     */
    public String crud_buscar(String tabla, String nombreVariable1, String valorVariable1, 
            String nombreVariable2, String valorVariable2, String extensionBusqueda){
        String resultado = "";
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM "+tabla+" WHERE "+nombreVariable1+"='"+valorVariable1+"'"
                    + " AND "+nombreVariable2+"='"+valorVariable2+"';";
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
    
    /**
     * Método encargado de encontrar una/s tupla/s con tres condiciones de búsqueda
     * @param tabla
     * @param nombreVariable1
     * @param valorVariable1
     * @param nombreVariable2
     * @param valorVariable2
     * @param nombreVariable3
     * @param valorVariable3
     * @param extensionBusqueda
     * @return 
     */
    public String crud_buscar(String tabla, String nombreVariable1, String valorVariable1, 
            String nombreVariable2, String valorVariable2, String nombreVariable3,
            String valorVariable3, String extensionBusqueda){
        String resultado = "";
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM "+tabla+" WHERE "+nombreVariable1+"='"+valorVariable1+"'"
                    + " AND "+nombreVariable2+"='"+valorVariable2+"'"
                    + " AND "+nombreVariable3+"='"+valorVariable3+"';";
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
    
    /**
     * Método encargado de filtrar una búsqueda a través de un rango de números
     * @param tabla
     * @param nombreVariable1
     * @param numMenor
     * @param nombreVariable2
     * @param numMayor
     * @return 
     */
    public String crud_buscar_rangoNumeros(String tabla, String nombreVariable1, String numMenor, 
            String nombreVariable2, String numMayor){
        String resultado = "";
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM "+tabla+" WHERE "+nombreVariable1+">'"+numMenor+"'"
                    + " AND "+nombreVariable2+"<'"+numMayor+"';";
            result = sentencia.executeQuery(sql);
            resultado = "RESULTADOS GLOBALES\n";
            // OJO, AQUÍ TE VA TOCAR QUE CREAR UNA CLASE PARA GUARDAR LAS VARIABLES
            // ASÍ PODRÁS MOSTRARLAS TODAS EN UNA TABLA MÁS BONITA
            while (result.next()) {
                resultado = resultado + result.getString("nombre") + " " + result.getString("cedula")
                        + result.getString("cargo") + " " + result.getString("telefono") + "\n";
            }
        } catch (SQLException e) {
            System.err.println("Error búsqueda: " + e.getMessage());
        }
        return resultado;
    }
    
    /**
     * Método encargado de filtrar una búsqueda a través de un rango de números y
     * una condición
     * @param tabla
     * @param nombreVariable1
     * @param numMenor
     * @param nombreVariable2
     * @param numMayor
     * @param nombreVariable3
     * @param condicion3
     * @return 
     */
    public String crud_buscar_rangoNumeros(String tabla, String nombreVariable1, String numMenor, 
            String nombreVariable2, String numMayor, String nombreVariable3, String condicion3){
        String resultado = "";
        try {
            Connection conexion = conectar();
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM "+tabla+" WHERE "+nombreVariable1+">'"+numMenor+"'"
                    + " AND "+nombreVariable2+"<'"+numMayor+"';";
            result = sentencia.executeQuery(sql);
            resultado = "RESULTADOS GLOBALES\n";
            // OJO, AQUÍ TE VA TOCAR QUE CREAR UNA CLASE PARA GUARDAR LAS VARIABLES
            // ASÍ PODRÁS MOSTRARLAS TODAS EN UNA TABLA MÁS BONITA
            while (result.next()) {
                resultado = resultado + result.getString("nombre") + " " + result.getString("cedula")
                        + result.getString("cargo") + " " + result.getString("telefono") + "\n";
            }
        } catch (SQLException e) {
            System.err.println("Error búsqueda: " + e.getMessage());
        }
        return resultado;
    }
    
    
    public String crud_buscar_manual(String seleccion, String tabla, String condicion, 
            int numSeleccion) throws SQLException{
        System.out.println("numcantidadColumnas>>> " + Integer.toString(numSeleccion));
        String resultado = "";
        String sql = "";
        int NUM = numSeleccion;

        Connection conexion = conectar();
        sentencia = conexion.createStatement();

        if (NUM == 0) {// Si es 0, significa que es toda la selección
            sentencia2 = conexion.createStatement();
            String sql2 = "SELECT COUNT(*)\n"
                    + "FROM INFORMATION_SCHEMA.COLUMNS\n"
                    + "WHERE table_catalog = 'da279dugkkpikd' -- the database\n"
                    + "AND table_name = '" + tabla + "';";
            result2 = sentencia2.executeQuery(sql2);
            if (result2.next()) {
                NUM = result2.getInt(1);
                System.out.println(NUM);
            } else {
                System.err.println("Ha sucedido un error grave!!!!");
            }
        }
        if (condicion.length() == 0) {
            sql = "SELECT " + seleccion + " FROM " + tabla + ";";
        } else {
            sql = "SELECT " + seleccion + " FROM " + tabla + " WHERE " + condicion + ";";
        }

        result = sentencia.executeQuery(sql);

        resultado = "";
        // OJO, AQUÍ TE VA TOCAR QUE CREAR UNA CLASE PARA GUARDAR LAS VARIABLES
        // ASÍ PODRÁS MOSTRARLAS TODAS EN UNA TABLA MÁS BONITA
        while (result.next()) {
            for (int i = 1; i <= NUM; i++) {
                resultado = resultado + result.getString(i) + " ";
            }
            resultado = resultado + "\n";
        }
        resultado = resultado.trim();
        System.out.println(sql);
        return resultado;
    }
    
    
    public void crud_modificar_manual (String tabla, String cambios, String condicion) throws SQLException{
        
           Connection conexion = conectar();
        sentencia = conexion.createStatement();
        String sql;
        if (condicion.length() == 0) {
            sql = "UPDATE " + tabla + " SET " + cambios + ";";
        } else {
            sql = "UPDATE " + tabla + " SET " + cambios + " WHERE " + condicion + ";";
        }

        System.out.println("MIRA ESE SQL PAPÁ!! >> " + sql);
        sentencia.executeUpdate(sql);
        System.out.println("La actualización se hizo correctamente");
            
        
    }
    
    // Métodos para la manipulación de la interfaz
    /// Métodos a trasladar /////
    
    public void variarVisibilidad(ActionEvent ae, RadioButton rb_opcBusqueda, RadioButton rb_opcModificar,
            Button btn_modificar, Button btn_buscar, Button btn_registrar, ArrayList<Node> componentes_condicion,
            ArrayList<Node> componentes_busqueda, Label label_primera_columna, 
            ArrayList<Labeled> componentesLabel_terceraColumna){
        if (!rb_opcBusqueda.isSelected() // Aquí registra usuario // rb_opcBusqueda
                && !rb_opcModificar.isSelected()) { // rb_opcModificar
            btn_modificar.setVisible(false); // btn_modificar
            btn_buscar.setVisible(false); // btn_buscar
            btn_registrar.setVisible(true); // btn_registrar
            modificarVisibilidadComponentesJavaFX(componentes_condicion, false); // componentes_condicion
            modificarVisibilidadComponentesJavaFX(componentes_busqueda, false); // componentes_busqueda
            label_primera_columna.setText("Valores de registro"); // segunda_columna
            
        } else {
            if (ae.getSource() == rb_opcBusqueda) { // Aquí busca usuario
                rb_opcModificar.setSelected(false);
                btn_modificar.setVisible(false);
                btn_buscar.setVisible(true);
                btn_registrar.setVisible(false);
                modificarVisibilidadComponentesJavaFX(componentes_condicion, false);
                modificarVisibilidadComponentesJavaFX(componentes_busqueda, true);
                label_primera_columna.setText("Condiciones de búsqueda");
                modificarPalabrasLabeledComponentesJavaFX(componentesLabel_terceraColumna, "Selección",true);
            } else if (ae.getSource() == rb_opcModificar) {
                rb_opcBusqueda.setSelected(false);
                btn_modificar.setVisible(true);
                btn_buscar.setVisible(false);
                btn_registrar.setVisible(false);
                modificarVisibilidadComponentesJavaFX(componentes_condicion, true);
                modificarVisibilidadComponentesJavaFX(componentes_busqueda, true);
                label_primera_columna.setText("Valores de cambio");
                modificarPalabrasLabeledComponentesJavaFX(componentesLabel_terceraColumna, "Cambio",true);
            }
        }
    }
    
    public void borrarDatosTextField(ArrayList<TextField> obj){
        for (TextField tf : obj) {
            tf.setText("");
        }
    }
    
     
    public boolean verificadorSizeCelda(TextField celda, int tamanioMin, int tamanioMax){
        boolean RESULTADO = false;
        RESULTADO = celda.getText().length() >= tamanioMin && celda.getText().length() <= tamanioMax;
        return RESULTADO;
    }
    
    
    public void modificarVisibilidadComponentesJavaFX(ArrayList<Node> grupo, boolean visibilidad){
        for(Node obj : grupo){
            obj.setVisible(visibilidad);
        }
    }
    
    public void modificarPalabrasLabeledComponentesJavaFX(ArrayList<Labeled> grupo, String palabra,
            boolean enumerar){
            String ENUMERADOR = "";
        if(enumerar) ENUMERADOR =" #";
        int NUM = 1;
        for(Labeled obj : grupo){
            obj.setText(palabra+ENUMERADOR+Integer.toString(NUM));
            NUM++;
        }
    }
    
    public String extendPalabra(String palabra, String adicion, boolean condicion){
        String resultado = "";
        if(condicion){
            if(palabra.length()==0){
                palabra = adicion;
            }else{
                palabra = palabra+" AND "+adicion; 
            }
        }else{ // Este de aquí sería para la selección
            if(palabra.length()==1){
                System.out.println("LLEGUÉ A SELECCIÓN <3");  
                palabra = adicion;
                System.out.println(palabra + "  Palabra <3");
            }else{
                palabra = palabra+", "+adicion;
            }
        }
        System.out.println("OJO-(resultado)--> "+resultado);
        return palabra;
    }
    
    
    /**
     * Función que se encarga de traducir el nombre de los atributos de la interfaz
     * en sus respectivos nombres en la base de datos.
     * @param atributo El nombre a traducir
     * @return String de la traducción
     */
    public String traducirPalabra(String atributo){
        String resultado = "";
        switch (atributo){
            case "Nombre": 
                System.out.println("estoy en el nombre <3");
                resultado = "nombre";
                break;
            case "Cédula": 
                resultado = "cedula";
                break;
            case "Estado": 
                resultado = "estado";
                break;
            case "Teléfono": 
                resultado = "telefono";
                break;
            case "Email": 
                resultado = "correo";
                break;
            case "Cargo": 
                resultado = "cargo";
                break;
            case "Sueldo": 
                resultado = "sueldo_base";
                break;
            case "Contraseña": 
                resultado = "password";
                break;
        }
        System.out.println("resultado de traducción>>>>"+resultado);
        return resultado;
    }
    
}
