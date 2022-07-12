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
public class InterfazPrincipalVendedorController implements Initializable {

    @FXML
    Button btn_desconectarse;
    @FXML
    Button btn_crud_cliente;
    @FXML
    Button btn_crud_ventavehiculo;
    @FXML
    Button btn_buscar_vehiculo;
    @FXML
    Button btn_solicitar_traslado;
    @FXML
    Button btn_ver_reporte;
    
    public void cambioInterfaz(ActionEvent ae){
        String fxml = "";
        if(ae.getSource()==btn_desconectarse){
            fxml = "Login";
        }else if(ae.getSource()== btn_crud_cliente){
            System.out.println("crud cliente");
            fxml = "CrudCliente_Vendedor";
        }else if(ae.getSource()== btn_crud_ventavehiculo){
            System.out.println("crud ventavehiculo");
            fxml = "CrudVentalVehiculo_Vendedor";
        }else if(ae.getSource()== btn_buscar_vehiculo){
            System.out.println("buscar vehiculo");
            fxml = "BuscarVehiculoEspecificaciones_Vendedor";
        }else if(ae.getSource()== btn_solicitar_traslado){
            System.out.println("solicitar traslado");
            fxml = "SolicitudTrasladoVehiculo_Vendedor";
        }else if(ae.getSource()== btn_ver_reporte){
            System.out.println("ver reporte");
            fxml = "VerReportePersonal_Vendedor";
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
