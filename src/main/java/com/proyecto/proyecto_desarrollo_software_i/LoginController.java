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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author juand
 */
public class LoginController implements Initializable {
    
    @FXML
    TextField txt_user;
    
    @FXML
    PasswordField txt_password;
    
    @FXML
    Button btn_ingresar;
    
    public void ingresar(ActionEvent ae){
        if(ae.getSource()==btn_ingresar){
            
            try {
                String fxml = "";
            int num = Integer.parseInt(txt_user.getText());
            System.out.println(txt_user.getText() + " " + txt_password.getText());
            if(num == 1){
                fxml = "InterfazPrincipalVendedor";
            }else if(num == 2){
                fxml = "InterfazPrincipalJefeTaller";
            }else if(num == 3){
                fxml = "InterfazPrincipalGerente";
            }
            
            if(num == 1 || num == 2 || num == 3){
                System.out.println("Cumple para entrar");
                try {
                    App.setRoot(fxml);
                } catch (IOException ex) {
                    System.err.println("Error con búsqueda de Interfaces: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
            } catch (Exception e) {
                System.out.println("El login por ahora son números\n"
                        + "Debido a que no es posible realizar comparaciones con\n"
                        + "Strings debido a que son objetos, por eso se utilizan números");
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
