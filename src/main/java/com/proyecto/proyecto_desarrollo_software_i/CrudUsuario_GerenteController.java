/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;
import com.proyecto.proyecto_desarrollo_software_i.modelo.Usuario;
import com.proyecto.proyecto_desarrollo_software_i.sql.CrudSQL;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                if (verificadorSizeCelda(txt_cedula, 6, 10) && verificadorSizeCelda(txt_nombre, 7, 32)
                        && verificadorSizeCelda(txt_password, 6, 50) && verificadorSizeCelda(txt_telefono, 7, 20)
                        && verificadorSizeCelda(txt_correo, 6, 60) && verificadorSizeCelda(txt_sueldo_base, 6, 9)
                        && !(cb_cargo.getValue() == null) && !(cb_estado.getValue() == null)) {

                    crud_registrar("usuario", "password", "estado", "nombre", "cedula", "telefono", "correo",
                            "sueldo_base", "cargo", "fecha_de_registro", txt_password.getText(), cb_estado.getValue(),
                            txt_nombre.getText(), txt_cedula.getText(), txt_telefono.getText(),
                            txt_correo.getText(), txt_sueldo_base.getText(), cb_cargo.getValue(),
                            dp_fecha.getValue().toString());
                    registrarCargoUsuario();
                    borrarDatosTextField(componentesTextField);
                    dp_fecha.setValue(LocalDate.now());
                    cb_estado.setValue("activo");
                    cb_cargo.setValue("vendedor");
                    info.setText("Usuario registrado exitosamente.");

                } else {
                    info.setText("Tamaño incorrecto de parámetros. Escriba el tamaño adecuado.");
                    txt_area.setText("TAMAÑO DE CARACTERES PARA EL REGISTRO\nCédula 6 - 10 \nNombre completo 7 - 32"
                            +"\nContraseña 6 - 50 \nTeléfono 7 - 20\n" +
                            "Correo 6 - 60 \nSueldo 6 - 9");

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
            // ELABORACIÓN DE CONDICIÓN DE RANGOS
            if(rb_sueldo.isSelected()){
                CONDICION = extendPalabra(CONDICION," sueldo_base>="+txt_sueldo_MIN.getText()+" AND "
                        + "sueldo_base<="+txt_sueldo_MAX.getText(), true);
            }if(rb_fecha.isSelected()){
                CONDICION = extendPalabra(CONDICION," fecha_de_registro>='"+dp_fecha_MIN.getValue().toString()
                        +"'"+" AND "+ "fecha_de_registro<='"+dp_fecha_MAX.getValue().toString()+"'", true);
            }
            //>>>>//
            String resultado = "";
            try {
                resultado = crud_buscar_manual(SELECCION, "usuario", CONDICION,NUM_SELECCION);
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
            // ELABORACIÓN DE CONDICIÓN DE RANGOS
            if(rb_sueldo.isSelected()){
                CONDICION = extendPalabra(CONDICION," sueldo_base>="+txt_sueldo_MIN.getText()+" AND "
                        + "sueldo_base<="+txt_sueldo_MAX.getText(), true);
            }if(rb_fecha.isSelected()){
                CONDICION = extendPalabra(CONDICION," fecha_de_registro>='"+dp_fecha_MIN.getValue().toString()
                        +"'"+" AND "+ "fecha_de_registro<='"+dp_fecha_MAX.getValue().toString()+"'", true);
            }
            try {
                //>>>>//
                crud_modificar_manual("usuario", ACTUALIZACION, CONDICION);
                info.setText("Usuario modificado exitosamente");
            } catch (SQLException ex) {
                info.setText("Error actualización");
                txt_area.setText("Causa: " + ex.getMessage());
            }
            borrarDatosTextField(componentesTextField);
            dp_fecha.setValue(LocalDate.now());
            cb_estado.setValue("activo");
            cb_cargo.setValue("vendedor");
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
    
    
    public String seleccionarValorSegundaColumna(String nombre){
        String resultado = "";
        if("nombre".equals(nombre)){
            resultado = txt_nombre_condicion.getText();
        }else if("cedula".equals(nombre)){
            resultado = txt_cedula_condicion.getText();
        }else if("telefono".equals(nombre)){
            resultado = txt_telefono_condicion.getText();
        }else if("correo".equals(nombre)){
            resultado = txt_correo_condicion.getText();
        }else if("cargo".equals(nombre)){
            resultado = cb_cargo_condicion.getValue();
        }else if("estado".equals(nombre)){
            resultado = cb_estado_condicion.getValue();
        }
        return resultado;
    }
    
    
    
    public void cambiarVisibilidadRoundButton(ActionEvent ae){
        cb_condicion1.setValue("Cédula");
        variarVisibilidad(ae, rb_buscar_global_usuario, rb_habilitar_condicion_de_modificacion,
            btn_modificar_usuario, btn_buscar_usuario, btn_guardar_usuario, componentesCondicion,
            componentesBusquedaYCondicion, l_columna_seleccion_modificacion, 
            componentesLabelSeleccion_Modificacion);
    }
    
    
    public void registrarCargoUsuario(){
        try {
            // Queda pendiente en ver cómo registrar a un gerente (no lo decía en el enunciado)
            String tabla = "";
            String nombreVariableId = "";
            usuario = new Usuario();
            String cargo_empleado = crud_buscar_manual("cargo", "usuario", "cedula=" + "'" + txt_cedula.getText() + "'", 1).trim();
            
            if ("jefe de taller".equals(cargo_empleado)) {
                tabla = "jefe_de_taller";
                nombreVariableId = "id_usuario_jt";
            } else if ("vendedor".equals(cargo_empleado)) {
                tabla = "vendedor";
                nombreVariableId = "id_usuario_v";
            }
            // AQUÍ TE HACE EN VERDAD MUCHA FALTA LA CLASE VARIABLES
            String id_empleado = crud_buscar_manual("id_usuario", "usuario", "cedula=" + "'" + txt_cedula.getText() + "'", 1).trim();
            
            System.out.println("tabla: " + tabla);
            System.out.println("cargo del usuario: "+cargo_empleado);
            crud_registrar(tabla, nombreVariableId, "id_usuario_g", id_empleado, usuario.getId());
        } catch (SQLException ex) {
            info.setText("Error búsqueda condició de actualización: \n" + ex.getMessage());
        }
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
        
        componentesTextField = new ArrayList<>();
        componentesTextField.add(txt_cedula);
        componentesTextField.add(txt_nombre);
        componentesTextField.add(txt_password);
        componentesTextField.add(txt_telefono);
        componentesTextField.add(txt_correo);
        componentesTextField.add(txt_sueldo_base);
        componentesTextField.add(txt_cedula_condicion);
        componentesTextField.add(txt_nombre_condicion);
        componentesTextField.add(txt_telefono_condicion);
        componentesTextField.add(txt_correo_condicion);
        
        
        String LISTA_SELECCION[] = {"-","Nombre","Cédula","Estado","Teléfono",
                "Email","Cargo","Sueldo","Contraseña"}; 
        String LISTA_CONDICION[] = {"-","Nombre","Cédula","Estado","Teléfono",
                "Email","Cargo","Sueldo"};
        
        String CARGOS[] = {"vendedor","jefe de taller"};
        String ESTADOS[] = {"activo","inactivo"};
        
        cb_cargo.getItems().addAll(CARGOS);
        cb_estado.getItems().addAll(ESTADOS);
        cb_cargo_condicion.getItems().addAll(CARGOS);
        cb_estado_condicion.getItems().addAll(ESTADOS);
        cb_seleccion1.getItems().addAll(LISTA_CONDICION);
        cb_seleccion2.getItems().addAll(LISTA_SELECCION);
        cb_seleccion3.getItems().addAll(LISTA_SELECCION);
        cb_condicion1.getItems().addAll(LISTA_CONDICION);
        cb_condicion2.getItems().addAll(LISTA_CONDICION);
        cb_condicion3.getItems().addAll(LISTA_CONDICION);
        
        dp_fecha = new DatePicker(LocalDate.now());
        rb_buscar_global_usuario.setSelected(true);
        btn_modificar_usuario.setVisible(false);
        btn_guardar_usuario.setVisible(false);
        
        cb_estado.setValue("activo");
        cb_cargo.setValue("vendedor");
        cb_condicion1.setValue("Cédula");
        
        //System.out.println(getUsuario().hashCode());
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        System.out.println(Usuario.getNombre());
        
        Usuario.setNombre("xdd");
        info_nombre.setText(Usuario.getNombre());
        info_cedula.setText(Usuario.getCedula());
        info_cargo.setText(Usuario.getCargo());
        // xd = new Usuario();
        //System.out.println(xd.getNombre());
    }    
    
}
