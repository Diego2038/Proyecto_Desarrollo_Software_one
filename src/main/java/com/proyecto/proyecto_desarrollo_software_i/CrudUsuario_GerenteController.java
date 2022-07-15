/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;
import com.proyecto.proyecto_desarrollo_software_i.sql.CrudSQL;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class CrudUsuario_GerenteController extends CrudSQL implements Initializable {

    @FXML
    Button btn_devolverse;
    @FXML
    Button btn_guardar_usuario;
    @FXML
    Button btn_buscar_usuario;
    @FXML
    Button btn_modificar_usuario;
    
    
    @FXML
    TextField txt_password;
    @FXML
    TextField txt_estado;
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
    TextField txt_cargo;
    @FXML
    TextField txt_fecha;
    @FXML
    Label info;
    
    @FXML
    TextArea txt_area;
    
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_guardar_usuario){
            if(verificadorSizeCelda(txt_cedula, 6, 10) && verificadorSizeCelda(txt_nombre, 7, 100)){
                txt_area.setText("Usuario guardado");
                crud_registrar("usuario", "password", "estado", "nombre", "cedula", "telefono", "correo",
                        "sueldo_base", "cargo", "fecha_de_registro", txt_password.getText(), "activo",
                        txt_nombre.getText(), txt_cedula.getText(), txt_telefono.getText(),
                        txt_correo.getText(), txt_sueldo_base.getText(), txt_cargo.getText(),
                        txt_fecha.getText());
                borrarDatos();
                info.setText("Usuario registrado exitosamente.");
            }else{
                info.setText("Tamaño incorrecto de parámetros Por favor\nescriba el tamaño adecuado.");
            }
            
        }else if(ae.getSource()==btn_buscar_usuario){
            txt_area.setText("Usuario buscado");
            info.setText("Búsqueda realizada");
        }else if(ae.getSource()==btn_modificar_usuario){
            txt_area.setText("Usuario modificado");
            borrarDatos();
            info.setText("Usuario modificado exitosamente");
        }
    }
    
    public boolean verificadorSizeCelda(TextField celda, int tamanioMin, int tamanioMax){
        boolean RESULTADO = false;
        RESULTADO = celda.getText().length() >= tamanioMin && celda.getText().length() <= tamanioMax;
        return RESULTADO;
    }
    
    public void borrarDatos(){
        txt_cargo.setText("");
        txt_telefono.setText("");
        txt_sueldo_base.setText("");
        txt_password.setText("");
        txt_nombre.setText("");
        txt_fecha.setText("");
        txt_estado.setText("");
        txt_correo.setText("");
        txt_cedula.setText("");
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
        // TODO
    }    
    
}
