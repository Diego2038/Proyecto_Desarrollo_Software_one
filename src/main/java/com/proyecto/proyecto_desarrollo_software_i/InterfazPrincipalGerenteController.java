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

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class InterfazPrincipalGerenteController implements Initializable {
    
    @FXML
    Button btn_desconectarse;
    @FXML
    Button btn_crud_usuario;
    @FXML
    Button btn_crud_sede;
    @FXML
    Button btn_crud_vehiculo;
    @FXML
    Button btn_autorizacion_traslado;
    @FXML
    Button btn_ver_reporte_totales;
    
    public void cambioInterfaz(ActionEvent ae){
        String fxml = "";
        if(ae.getSource()==btn_desconectarse){
            fxml = "Login";
        }else if(ae.getSource()== btn_crud_usuario){
            System.out.println("crud usuario");
            fxml = "CrudUsuario_Gerente";
        }else if(ae.getSource()== btn_crud_sede){
            System.out.println("crud sede");
            fxml = "CrudSede_Gerente";
        }else if(ae.getSource()== btn_crud_vehiculo){
            System.out.println("crud vehiculo");
            fxml = "CrudVehiculo_Gerente";
        }else if(ae.getSource()== btn_autorizacion_traslado){
            System.out.println("autorizar traslado");
            fxml = "AutorizacionTrasladoVehiculo_Gerente";
        }else if(ae.getSource()== btn_ver_reporte_totales){
            System.out.println("ver todos los reportes");
            fxml = "ReportesGenerales_Gerente";
        }
        try {
            App.setRoot(fxml);
            System.out.println("Regreso al login");
            } catch (IOException ex) {
                System.err.println("Error conexión interfaz: " + ex.getMessage());
                ex.printStackTrace();
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
