/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;

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
    TextField t_user;
    
    @FXML
    PasswordField t_password;
    
    @FXML
    Button btn_ingresar;
    
    public void ingresar(ActionEvent ae){
        if(ae.getSource()==btn_ingresar){
            System.out.println(t_user.getText() + " " + t_password.getText());
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
