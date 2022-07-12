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
public class VerReportePersonal_JefeDeTallerController implements Initializable {

    @FXML
    Button btn_devolverse;
    @FXML
    Button btn_ordenes;
    @FXML
    Button btn_repuestos;
    @FXML
    TextField txt_fecha_inicio;
    @FXML
    TextField txt_fecha_final;
    @FXML
    TextArea txt_area;
    
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_ordenes){
            txt_area.setText("Resultados ordenes");
        }else if(ae.getSource()==btn_repuestos){
            txt_area.setText("Resultado repuestos");
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
