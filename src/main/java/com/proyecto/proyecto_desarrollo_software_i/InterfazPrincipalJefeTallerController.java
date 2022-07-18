/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;

import com.proyecto.proyecto_desarrollo_software_i.modelo.Usuario;
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
public class InterfazPrincipalJefeTallerController implements Initializable {

    @FXML
    Button btn_desconectarse;
    @FXML
    Button btn_crud_cliente;
    @FXML
    Button btn_crud_vehiculoCliente;
    @FXML
    Button btn_crud_orden_de_trabajo;
    @FXML
    Button btn_crud_respuesto;
    @FXML
    Button btn_ver_reporte;
    
    public void cambioInterfaz(ActionEvent ae){
        String fxml = "";
        if(ae.getSource()==btn_desconectarse){
            fxml = "Login";
        }else if(ae.getSource()== btn_crud_cliente){
            System.out.println("crud cliente");
            fxml = "CrudCliente_JefeDeTaller";
        }else if(ae.getSource()== btn_crud_vehiculoCliente){
            System.out.println("crud vehículo del cliente");
            fxml = "Crud_VehiculoDeCliente_JefeDeTaller";
        }else if(ae.getSource()== btn_crud_orden_de_trabajo){
            System.out.println("crud orden de trabajo");
            fxml = "CrudOrdenDeTrabajo_JefeDeTaller";
        }else if(ae.getSource()== btn_crud_respuesto){
            System.out.println("crud repuesto");
            fxml = "CrudRepuesto_JefeDeTaller";
        }else if(ae.getSource()== btn_ver_reporte){
            System.out.println("ver reporte");
            fxml = "VerReportePersonal_JefeDeTaller";
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
        System.out.println("OTROOOOOOOOOO");
        Usuario a = new Usuario();
        System.out.println(a.getNombre());
    }    
    
}
