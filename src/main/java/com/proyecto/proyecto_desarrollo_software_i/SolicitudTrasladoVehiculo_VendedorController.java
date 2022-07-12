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
public class SolicitudTrasladoVehiculo_VendedorController implements Initializable {

    @FXML
    Button btn_devolverse;
    
    @FXML
    Button btn_realizar_solicitud;
    @FXML
    TextField txt_id_auto;
    @FXML
    TextField txt_sede_origen; // La sede de donde lo traen
    TextField txt_sede_destino; // La sede del vendedor
    @FXML
    TextField txt_cedula_vendedor;
    
    
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_realizar_solicitud){
            System.out.println("Pedido realizado exitosamente");
        }
    }
    
    
    
    public void retorno(ActionEvent ae){
        if(ae.getSource()==btn_devolverse){
            try {
                App.setRoot("InterfazPrincipalVendedor");
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
