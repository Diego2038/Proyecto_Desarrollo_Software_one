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
public class VerReportePersonal_VendedorController implements Initializable {

    @FXML
    Button btn_devolverse;
    
    @FXML
    Button btn_ventas;
    @FXML
    Button btn_vehiculos;
    @FXML
    Button btn_solicitud_traslado;
    @FXML
    TextField txt_fecha_inicio;
    @FXML
    TextField txt_fecha_final;
    @FXML
    TextArea txt_area;
    
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_ventas){
            txt_area.setText("Resultados ventas");
        }else if(ae.getSource()==btn_vehiculos){
            txt_area.setText("Resultado vehículos vendidos");
        }else if(ae.getSource()==btn_solicitud_traslado){
            txt_area.setText("resultado vehículos trasladados");
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
