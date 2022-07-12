/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class CrudUsuario_GerenteController implements Initializable {

    @FXML
    Button btn_devolverse;
    @FXML
    Button btn_guardar_usuario;
    @FXML
    Button btn_buscar_usuario;
    @FXML
    Button btn_modificar_usuario;
    
    @FXML
    TextField txt_id_usuario;
    @FXML
    TextField txt_password;
    @FXML
    TextField txt_estado;
    @FXML
    TextField txt_nombre;
    @FXML
    TextField txt_cedula;
    @FXML
    TextField txt_sede;
    @FXML
    TextField txt_telefono;
    @FXML
    TextField txt_correo;
    @FXML
    TextField txt_sueldo_base;
    @FXML
    TextField txt_cargo;
    
    @FXML
    TextArea txt_area;
    
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_guardar_usuario){
            txt_area.setText("Usuario guardado");
        }else if(ae.getSource()==btn_buscar_usuario){
            txt_area.setText("Usuario buscado");
        }else if(ae.getSource()==btn_modificar_usuario){
            txt_area.setText("Usuario modificado");
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
        // TODO
    }    
    
}
