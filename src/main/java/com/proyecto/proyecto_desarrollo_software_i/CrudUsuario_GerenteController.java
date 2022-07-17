/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;
import com.proyecto.proyecto_desarrollo_software_i.sql.CrudSQL;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Diego
 */
public class CrudUsuario_GerenteController extends CrudSQL implements Initializable {
    
    ArrayList<Node> componentesCondicion;
    ArrayList<Node> componentesBusquedaYCondicion;
    ArrayList<Labeled> componentesLabelSeleccion_Modificacion;
    ArrayList<Labeled> componentesLabelCondicion;

    @FXML
    Button btn_devolverse;
    @FXML
    Button btn_guardar_usuario;
    @FXML
    Button btn_buscar_usuario;
    @FXML
    RadioButton rb_buscar_global_usuario;
    @FXML
    RadioButton rb_habilitar_condicion_de_modificacion;
    @FXML
    Button btn_modificar_usuario;
    
    /////
    @FXML
    TextField txt_cedula_condicion;
    @FXML
    ChoiceBox<String> cb_estado_condicion;
    @FXML
    TextField txt_nombre_condicion;
    @FXML
    TextField txt_telefono_condicion;
    @FXML
    TextField txt_correo_condicion;
    @FXML
    ChoiceBox<String> cb_cargo_condicion;
    
    @FXML
    Label l_columna_seleccion_modificacion;
    @FXML
    Label l_seleccion_modificacion1;
    @FXML
    Label l_seleccion_modificacion2;
    @FXML
    Label l_seleccion_modificacion3;
    @FXML
    Label l_columna_condicion;
    @FXML
    Label l_condicion1;
    @FXML
    Label l_condicion2;
    @FXML
    Label l_condicion3;
    
    ////
    
    @FXML
    TextField txt_password;
    @FXML
    ChoiceBox<String> cb_estado;
    @FXML
    TextField txt_nombre;
    @FXML
    TextField txt_cedula;
    @FXML
    TextField txt_telefono;
    @FXML
    TextField txt_correo;
    @FXML
    TextField txt_sueldo_base;
    @FXML
    TextField txt_sueldo_MIN;
    @FXML
    TextField txt_sueldo_MAX;
    @FXML
    ChoiceBox<String> cb_cargo;
    @FXML
    DatePicker dp_fecha;
    @FXML
    DatePicker dp_fecha_MIN;
    @FXML
    DatePicker dp_fecha_MAX;
    @FXML
    RadioButton rb_sueldo;
    @FXML
    RadioButton rb_fecha;
    @FXML
    Label info;
    
    @FXML
    ChoiceBox<String> cb_seleccion1;
    @FXML
    ChoiceBox<String> cb_seleccion2;
    @FXML
    ChoiceBox<String> cb_seleccion3;
    @FXML
    ChoiceBox<String> cb_condicion1;
    @FXML
    ChoiceBox<String> cb_condicion2;
    @FXML
    ChoiceBox<String> cb_condicion3;
    
    @FXML
    TextArea txt_area;
    
    
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_guardar_usuario){
            info.setText("Registrando...");
            if(verificadorSizeCelda(txt_cedula, 6, 10) && verificadorSizeCelda(txt_nombre, 7, 50)
                    && verificadorSizeCelda(txt_password, 6, 50) && verificadorSizeCelda(txt_telefono, 7, 20)
                    && verificadorSizeCelda(txt_correo, 6, 60) && verificadorSizeCelda(txt_sueldo_base, 6,9)
                    && !(cb_cargo.getValue()==null) && !(cb_estado.getValue()==null)){
                txt_area.setText("Usuario guardado");
                crud_registrar("usuario", "password", "estado", "nombre", "cedula", "telefono", "correo",
                        "sueldo_base", "cargo", "fecha_de_registro", txt_password.getText(), cb_estado.getValue(),
                        txt_nombre.getText(), txt_cedula.getText(), txt_telefono.getText(),
                        txt_correo.getText(), txt_sueldo_base.getText(), cb_cargo.getValue(),   
                        dp_fecha.getValue().toString());
                borrarDatos();
                info.setText("Usuario registrado exitosamente.");
            }else{
                info.setText("Tamaño incorrecto de parámetros.\nEscriba el tamaño adecuado.");
                
            }
            
        }else if(ae.getSource()==btn_buscar_usuario){
            int NUM_SELECCION = 0;
            String SELECCION = "*";
            String CONDICION = ""; 
            // ELABORACIÓN DE LA SELECCIÓN
            if(!"-".equals(cb_seleccion1.getValue()) && !(cb_seleccion1.getValue()==null)){
                NUM_SELECCION++;
                SELECCION = extendPalabra(SELECCION, traducirPalabra(cb_seleccion1.getValue()), false);
            }if (!"-".equals(cb_seleccion2.getValue()) && !(cb_seleccion2.getValue() == null)) {
                NUM_SELECCION++;
                SELECCION = extendPalabra(SELECCION, traducirPalabra(cb_seleccion2.getValue()), false);
            }if (!"-".equals(cb_seleccion3.getValue()) && !(cb_seleccion3.getValue() == null)) {
                NUM_SELECCION++;
                SELECCION = extendPalabra(SELECCION, traducirPalabra(cb_seleccion3.getValue()), false);
            }
            // ELABORACIÓN DE LA CONDICIÓN
            if (!"-".equals(cb_condicion1.getValue()) && !(cb_condicion1.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion1.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_condicion1.getValue()))+"'", true);
                
            }if (!"-".equals(cb_condicion2.getValue()) && !(cb_condicion2.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion2.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_condicion2.getValue()))+"'", true);
            }if (!"-".equals(cb_condicion3.getValue()) && !(cb_condicion3.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion3.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_condicion3.getValue()))+"'", true);
            }
            // ELABORACIÓN DE CONDICIÓN DE RANGOS
            if(rb_sueldo.isSelected()){
                CONDICION = extendPalabra(CONDICION," sueldo_base>="+txt_sueldo_MIN.getText()+" AND "
                        + "sueldo_base<="+txt_sueldo_MAX.getText(), true);
            }if(rb_fecha.isSelected()){
                CONDICION = extendPalabra(CONDICION," fecha_de_registro>='"+dp_fecha_MIN.getValue().toString()
                        +"'"+" AND "+ "fecha_de_registro<='"+dp_fecha_MAX.getValue().toString()+"'", true);
            }
            //>>>>//
            String resultado = crud_buscar_manual(SELECCION, "usuario", CONDICION,
                    rb_buscar_global_usuario.isSelected(),NUM_SELECCION);
            info.setText("Búsqueda realizada");
            txt_area.setText(resultado);
            System.out.println("OJO---->" +SELECCION);
            
        }else if(ae.getSource()==btn_modificar_usuario){
            txt_area.setText("Usuario modificado");
            borrarDatos();
            info.setText("Usuario modificado exitosamente");
            cb_estado.setValue("activo");
            
        }
    }
    
    public String seleccionarValor(String nombre){
        String resultado = "";
        if("nombre".equals(nombre)){
            resultado = txt_nombre.getText();
        }else if("cedula".equals(nombre)){
            resultado = txt_cedula.getText();
        }else if("telefono".equals(nombre)){
            resultado = txt_telefono.getText();
        }else if("correo".equals(nombre)){
            resultado = txt_correo.getText();
        }else if("sueldo_base".equals(nombre)){
            resultado = txt_sueldo_base.getText();
        }else if("cargo".equals(nombre)){
            resultado = cb_cargo.getValue();
        }else if("password".equals(nombre)){
            resultado = txt_password.getText();
        }else if("estado".equals(nombre)){
            resultado = cb_estado.getValue();
        }
        return resultado;
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
                resultado = "sueldo_base";
                break;
        }
        System.out.println("resultado de traducción>>>>"+resultado);
        return resultado;
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
    
    public void modificarPalabrasLabeledComponentesJavaFX(ArrayList<Labeled> grupo, String palabra){
        int NUM = 1;
        for(Labeled obj : grupo){
            obj.setText(palabra+" #"+Integer.toString(NUM));
            NUM++;
        }
    }
    
    
    //public void cambiarNombresLabelComponentesJavaFX(A)
    
    public void borrarDatos(){
        txt_telefono.setText("");
        txt_sueldo_base.setText("");
        txt_password.setText("");
        txt_nombre.setText("");
        dp_fecha.setValue(LocalDate.now());
        
        txt_correo.setText("");
        txt_cedula.setText("");
    }
  
    public void cambiarEstadoRoundButton(ActionEvent ae) {
        if (!rb_buscar_global_usuario.isSelected() // Aquí registra usuario
                && !rb_habilitar_condicion_de_modificacion.isSelected()) {
            btn_modificar_usuario.setDisable(true);
            btn_buscar_usuario.setDisable(true);
            btn_guardar_usuario.setDisable(false);
            modificarVisibilidadComponentesJavaFX(componentesCondicion, false);
            modificarVisibilidadComponentesJavaFX(componentesBusquedaYCondicion, false);
            l_columna_seleccion_modificacion.setText("Valores de registro");
            
        } else {
            if (ae.getSource() == rb_buscar_global_usuario) { // Aquí busca usuario
                rb_habilitar_condicion_de_modificacion.setSelected(false);
                btn_modificar_usuario.setDisable(true);
                btn_buscar_usuario.setDisable(false);
                btn_guardar_usuario.setDisable(true);
                modificarVisibilidadComponentesJavaFX(componentesCondicion, false);
                modificarVisibilidadComponentesJavaFX(componentesBusquedaYCondicion, true);
                l_columna_seleccion_modificacion.setText("Valores de búsqueda");
                modificarPalabrasLabeledComponentesJavaFX(componentesLabelSeleccion_Modificacion, "Selección");
            } else if (ae.getSource() == rb_habilitar_condicion_de_modificacion) {
                rb_buscar_global_usuario.setSelected(false);
                btn_modificar_usuario.setDisable(false);
                btn_buscar_usuario.setDisable(true);
                btn_guardar_usuario.setDisable(true);
                modificarVisibilidadComponentesJavaFX(componentesCondicion, true);
                modificarVisibilidadComponentesJavaFX(componentesBusquedaYCondicion, true);
                l_columna_seleccion_modificacion.setText("Valores de cambio");
                modificarPalabrasLabeledComponentesJavaFX(componentesLabelSeleccion_Modificacion, "Cambio");
            }
        }

    }
    
    
    
    
    
    public void retorno(ActionEvent ae){
        if(ae.getSource()==btn_devolverse){
            try {
                App.setRoot("InterfazPrincipalGerente");
                System.out.println("Regreso a la interfaz principal");
            } catch (IOException ex) {
                System.err.println("Error conexión interfaz: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        componentesCondicion = new ArrayList<>();
        componentesCondicion.add(l_columna_condicion);
        componentesCondicion.add(txt_cedula_condicion);
        componentesCondicion.add(txt_correo_condicion);
        componentesCondicion.add(txt_nombre_condicion);
        componentesCondicion.add(txt_telefono_condicion);
        componentesCondicion.add(cb_estado_condicion);
        componentesCondicion.add(cb_cargo_condicion);
        modificarVisibilidadComponentesJavaFX(componentesCondicion, false);
        
        componentesBusquedaYCondicion = new ArrayList<>();
        componentesBusquedaYCondicion.add(l_condicion1);
        componentesBusquedaYCondicion.add(l_condicion2);
        componentesBusquedaYCondicion.add(l_condicion3);
        componentesBusquedaYCondicion.add(cb_seleccion1);
        componentesBusquedaYCondicion.add(cb_seleccion2);
        componentesBusquedaYCondicion.add(cb_seleccion3);
        componentesBusquedaYCondicion.add(l_seleccion_modificacion1);
        componentesBusquedaYCondicion.add(l_seleccion_modificacion2);
        componentesBusquedaYCondicion.add(l_seleccion_modificacion3);
        componentesBusquedaYCondicion.add(cb_condicion1);
        componentesBusquedaYCondicion.add(cb_condicion2);
        componentesBusquedaYCondicion.add(cb_condicion3);
        componentesBusquedaYCondicion.add(rb_sueldo);
        componentesBusquedaYCondicion.add(rb_fecha);
        componentesBusquedaYCondicion.add(txt_sueldo_MIN);
        componentesBusquedaYCondicion.add(txt_sueldo_MAX);
        componentesBusquedaYCondicion.add(dp_fecha_MIN);
        componentesBusquedaYCondicion.add(dp_fecha_MAX);
        
        componentesLabelCondicion = new ArrayList<>();
        componentesLabelCondicion.add(l_condicion1);
        componentesLabelCondicion.add(l_condicion2);
        componentesLabelCondicion.add(l_condicion3);
        
        componentesLabelSeleccion_Modificacion = new ArrayList<>();
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion1);
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion2);
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion3);
        
        
        String LISTA_SELECCION[] = {"-","Nombre","Cédula","Estado","Teléfono",
                "Email","Cargo","Sueldo","Contraseña"}; 
        String LISTA_CONDICION[] = {"-","Nombre","Cédula","Estado","Teléfono",
                "Email","Cargo","Sueldo"}; 
        
        String CARGOS[] = {"vendedor","jefe de taller","gerente"};
        String ESTADOS[] = {"activo","inactivo"};
        
        cb_cargo.getItems().addAll(CARGOS);
        cb_estado.getItems().addAll(ESTADOS);
        cb_cargo_condicion.getItems().addAll(CARGOS);
        cb_estado_condicion.getItems().addAll(ESTADOS);
        cb_seleccion1.getItems().addAll(LISTA_SELECCION);
        cb_seleccion2.getItems().addAll(LISTA_SELECCION);
        cb_seleccion3.getItems().addAll(LISTA_SELECCION);
        cb_condicion1.getItems().addAll(LISTA_CONDICION);
        cb_condicion2.getItems().addAll(LISTA_CONDICION);
        cb_condicion3.getItems().addAll(LISTA_CONDICION);
        
        String valor = cb_seleccion1.getValue();
        dp_fecha = new DatePicker(LocalDate.now());
        rb_buscar_global_usuario.setSelected(true);
        btn_modificar_usuario.setDisable(true);
        btn_guardar_usuario.setDisable(true);
    }    
    
}
