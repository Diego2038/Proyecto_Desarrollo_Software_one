/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;

import com.proyecto.proyecto_desarrollo_software_i.modelo.Usuario;
import com.proyecto.proyecto_desarrollo_software_i.sql.CrudSQL;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
public class CrudSede_GerenteController extends CrudSQL implements Initializable{

    private Usuario usuario;
    ArrayList<Node> componentesCondicion;
    ArrayList<Node> componentesBusquedaYCondicion;
    ArrayList<Labeled> componentesLabelSeleccion_Modificacion;
    ArrayList<Labeled> componentesLabelCondicion;
    ArrayList<TextField> componentesTextField;

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
    TextField txt_ciudad_condicion;
    @FXML
    TextField txt_nombre_condicion;
    @FXML
    TextField txt_direccion_condicion;
    
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
    TextField txt_nombre;
    @FXML
    TextField txt_ciudad;
    @FXML
    TextField txt_direccion;
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
    Label info_nombre;
    @FXML
    Label info_cedula;
    @FXML
    Label info_cargo;
    
    
    @FXML
    TextArea txt_area;
    
    
    
    public void accionBoton(ActionEvent ae){
        if (ae.getSource() == btn_devolverse) {
            retornarInterfaz("InterfazPrincipalGerente");
        } else if (ae.getSource() == btn_guardar_usuario) {
            info.setText("Registrando...");
            try {
                if (verificadorSizeCelda(txt_ciudad, 3, 30) && verificadorSizeCelda(txt_nombre, 4, 50)
                        && verificadorSizeCelda(txt_direccion, 5, 150)) {
                    crud_registrar("sede", "ciudad", "nombre", "direccion", txt_ciudad.getText(),
                            txt_nombre.getText(), txt_direccion.getText());
                    borrarDatosTextField(componentesTextField);
                    info.setText("Sede registrada exitosamente.");

                } else {
                    info.setText("Tamaño incorrecto de parámetros. Escriba el tamaño adecuado.");
                    txt_area.setText("TAMAÑO DE CARACTERES PARA EL REGISTRO\nCiudad 3 - 30 "
                            + "\nNombre de la sede 4 - 50"
                            + "\nDirección 5 - 150");

                }
            } catch (SQLException ex) {
                info.setText("Error parámetros de registro");
                txt_area.setText("Causa: " + ex.getMessage());
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
            
            //>>>>//
            String resultado = "";
            try {
                resultado = crud_buscar_manual(SELECCION, "sede", CONDICION,NUM_SELECCION);
                info.setText("Búsqueda realizada");
                txt_area.setText("RESULTADOS GLOBALES\n" + resultado);
                System.out.println("OJO---->" + SELECCION);
            } catch (SQLException ex) {
                info.setText("Error parámetros de búsqueda");
                txt_area.setText("Causa: " + ex.getMessage());
            }
            
            
        }else if(ae.getSource()==btn_modificar_usuario){
            
            ////////////////////////////77-->>>>>>>>>>>>>>
            
            String ACTUALIZACION = "*";
            String CONDICION = ""; 
            // ELABORACIÓN DE LA ACTUALIZACIÓN
            if(!"-".equals(cb_seleccion1.getValue()) && !(cb_seleccion1.getValue()==null)){
                ACTUALIZACION = extendPalabra(ACTUALIZACION, traducirPalabra(cb_seleccion1.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_seleccion1.getValue()))+"'", false);
            }if (!"-".equals(cb_seleccion2.getValue()) && !(cb_seleccion2.getValue() == null)) {
                ACTUALIZACION = extendPalabra(ACTUALIZACION, traducirPalabra(cb_seleccion2.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_seleccion2.getValue()))+"'", false);
            }if (!"-".equals(cb_seleccion3.getValue()) && !(cb_seleccion3.getValue() == null)) {
                ACTUALIZACION = extendPalabra(ACTUALIZACION, traducirPalabra(cb_seleccion3.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_seleccion3.getValue()))+"'", false);
            }
            // ELABORACIÓN DE LA CONDICIÓN
            if (!"-".equals(cb_condicion1.getValue()) && !(cb_condicion1.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion1.getValue())+"='"
                        +seleccionarValorSegundaColumna(traducirPalabra(cb_condicion1.getValue()))+"'", true);
                
            }if (!"-".equals(cb_condicion2.getValue()) && !(cb_condicion2.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion2.getValue())+"='"
                        +seleccionarValorSegundaColumna(traducirPalabra(cb_condicion2.getValue()))+"'", true);
            }if (!"-".equals(cb_condicion3.getValue()) && !(cb_condicion3.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion3.getValue())+"='"
                        +seleccionarValorSegundaColumna(traducirPalabra(cb_condicion3.getValue()))+"'", true);
            }
            try {
                //>>>>//
                crud_modificar_manual("sede", ACTUALIZACION, CONDICION);
                info.setText("Sede modificada exitosamente");
            } catch (SQLException ex) {
                info.setText("Error actualización");
                txt_area.setText("Causa: " + ex.getMessage());
            }
            borrarDatosTextField(componentesTextField);
        }
    }
    
    public String seleccionarValor(String nombre){
        String resultado = "";
        if("nombre".equals(nombre)){
            resultado = txt_nombre.getText();
        }else if("ciudad".equals(nombre)){
            resultado = txt_ciudad.getText();
        }else if("direccion".equals(nombre)){
            resultado = txt_direccion.getText();
        }
        return resultado;
    }
    
    
    public String seleccionarValorSegundaColumna(String nombre){
        String resultado = "";
        if("nombre".equals(nombre)){
            resultado = txt_nombre_condicion.getText();
        }else if("ciudad".equals(nombre)){
            resultado = txt_ciudad_condicion.getText();
        }else if("direccion".equals(nombre)){
            resultado = txt_direccion_condicion.getText();
        }
        return resultado;
    }
    
    
    
    public void cambiarVisibilidadRoundButton(ActionEvent ae){
        cb_condicion1.setValue("Nombre sede");
        variarVisibilidad(ae, rb_buscar_global_usuario, rb_habilitar_condicion_de_modificacion,
            btn_modificar_usuario, btn_buscar_usuario, btn_guardar_usuario, componentesCondicion,
            componentesBusquedaYCondicion, l_columna_seleccion_modificacion, 
            componentesLabelSeleccion_Modificacion);
    }
    
    
    public void retornarInterfaz(String fxml){
        try {
                //App.setRoot("InterfazPrincipalGerente");
                App.setRoot(fxml);
                System.out.println("Regreso a la interfaz principal");
            } catch (IOException ex) {
                System.err.println("Error conexión interfaz: " + ex.getMessage());
            }
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        componentesCondicion = new ArrayList<>();
        componentesCondicion.add(l_columna_condicion);
        componentesCondicion.add(txt_ciudad_condicion);
        componentesCondicion.add(txt_nombre_condicion);
        componentesCondicion.add(txt_direccion_condicion);
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
        
        componentesLabelCondicion = new ArrayList<>();
        componentesLabelCondicion.add(l_condicion1);
        componentesLabelCondicion.add(l_condicion2);
        componentesLabelCondicion.add(l_condicion3);
        
        componentesLabelSeleccion_Modificacion = new ArrayList<>();
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion1);
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion2);
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion3);
        
        componentesTextField = new ArrayList<>();
        componentesTextField.add(txt_ciudad);
        componentesTextField.add(txt_nombre);
        componentesTextField.add(txt_direccion);
        componentesTextField.add(txt_ciudad_condicion);
        componentesTextField.add(txt_nombre_condicion);
        componentesTextField.add(txt_direccion_condicion);
        
        
        String LISTA_SELECCION[] = {"-","Nombre sede","Ciudad","Dirección sede"}; 
        String LISTA_CONDICION[] = {"-","Nombre sede","Ciudad","Dirección sede"}; 
        
        
        cb_seleccion1.getItems().addAll(LISTA_CONDICION);
        cb_seleccion2.getItems().addAll(LISTA_SELECCION);
        cb_seleccion3.getItems().addAll(LISTA_SELECCION);
        cb_condicion1.getItems().addAll(LISTA_CONDICION);
        cb_condicion2.getItems().addAll(LISTA_CONDICION);
        cb_condicion3.getItems().addAll(LISTA_CONDICION);
        
        
        rb_buscar_global_usuario.setSelected(true);
        btn_modificar_usuario.setVisible(false);
        btn_guardar_usuario.setVisible(false);
        
        cb_condicion1.setValue("Nombre de la sede");
        
        //System.out.println(getUsuario().hashCode());
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        System.out.println(Usuario.getNombre());
        
        info_nombre.setText(Usuario.getNombre());
        info_cedula.setText(Usuario.getCedula());
        info_cargo.setText(Usuario.getCargo());
        // xd = new Usuario();
        //System.out.println(xd.getNombre());
    }  
    
}
