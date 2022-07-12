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
public class CrudVehiculo_GerenteController implements Initializable {

    @FXML
    Button btn_devolverse;
    @FXML
    Button btn_buscar_auto;
    @FXML
    Button btn_registrar_auto;
    @FXML
    Button btn_modificar_auto;
    @FXML
    TextField txt_id_auto;
    @FXML
    TextField txt_precio;
    @FXML
    TextField txt_garantia;
    @FXML
    TextField txt_modelo;
    @FXML
    TextField txt_marca;
    @FXML
    TextField txt_agno;
    @FXML
    TextField txt_color;
    @FXML
    TextArea txt_area;
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_buscar_auto){
            txt_area.setText("Buscar Auto");
        }else if(ae.getSource()==btn_modificar_auto){
            txt_area.setText("Modificar Auto");
        }else if(ae.getSource()==btn_registrar_auto){
            txt_area.setText("Registrar Auto");
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
