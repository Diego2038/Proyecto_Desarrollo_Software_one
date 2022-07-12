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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class CrudVentalVehiculo_VendedorController implements Initializable {

    
    @FXML
    Button btn_devolverse;
    
    
    @FXML
    Button btn_registrar_venta;
    @FXML
    Button btn_modificar_venta;
    @FXML
    Button btn_buscar_venta;
    @FXML
    TextField txt_id_auto;
    @FXML
    TextField txt_cedula_cliente;
    @FXML
    TextField txt_cedula_vendedor;
    @FXML
    TextArea txt_area;
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_buscar_venta){
            txt_area.setText("Buscar Venta");
        }else if(ae.getSource()==btn_modificar_venta){
            txt_area.setText("Modificar venta");
        }else if(ae.getSource()==btn_registrar_venta){
            txt_area.setText("Registrar venta");
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
