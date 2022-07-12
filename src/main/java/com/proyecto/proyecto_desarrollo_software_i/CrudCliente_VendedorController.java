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
public class CrudCliente_VendedorController implements Initializable {

    @FXML
    Button btn_devolverse;
    @FXML
    Button btn_agregar_cliente;
    @FXML
    Button btn_modificar_cliente;
    @FXML
    Button btn_buscar_cliente;
    @FXML
    TextField txt_cedula_cliente;
    @FXML
    TextField txt_nombre_cliente;
    @FXML
    TextField txt_telefono_cliente;
    @FXML
    TextField txt_correo_electronico_cliente;
    @FXML
    Label info;
    @FXML
    TextArea txt_area;
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
    
    public void accionBoton(ActionEvent ae){
        if(ae.getSource()==btn_agregar_cliente){
            System.out.println("Cliente agregado");
            info.setText("Cliente agregado");
            txt_area.setText("agregado");
        }else if(ae.getSource()==btn_modificar_cliente){
            System.out.println("Cliente modificado");
            info.setText("Cliente modificado");
            txt_area.setText("modificado");
        }else if(ae.getSource()==btn_buscar_cliente){
            System.out.println("Cliente buscado");
            info.setText("Cliente buscado");
            txt_area.setText("buscado");
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.info = new Label();
    }    
    
}
