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
public class CrudRepuesto_JefeDeTallerController implements Initializable {

    @FXML
    Button btn_devolverse;
    @FXML
    Button btn_buscar_repuesto;
    @FXML
    Button btn_guardar_repuesto;
    @FXML
    Button btn_modificar_repuesto;
    @FXML
    TextField txt_id_repuesto;
    @FXML
    TextField txt_nombreRepuesto;
    @FXML
    TextField txt_precio;
    @FXML
    TextField txt_cantidad;
    @FXML
    TextArea txt_area;
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_buscar_repuesto){
            txt_area.setText("Buscar repuesto");
        }else if(ae.getSource()==btn_modificar_repuesto){
            txt_area.setText("modificar repuesto");
        }else if(ae.getSource()==btn_guardar_repuesto){
            txt_area.setText("guardar repuesto");
        }
    }
    
    
    public void retorno(ActionEvent ae){
        if(ae.getSource()==btn_devolverse){
            try {
                App.setRoot("InterfazPrincipalJefeTaller");
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
