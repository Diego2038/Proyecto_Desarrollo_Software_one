/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;
import com.proyecto.proyecto_desarrollo_software_i.sql.CrudSQL;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author juand
 */
public class LoginController extends CrudSQL implements Initializable {
    
    @FXML
    TextField txt_user;
    
    @FXML
    PasswordField txt_password;
    
    @FXML
    Button btn_ingresar;
    
    @FXML
    Label info;
    
    public void ingresar(ActionEvent ae){
        if(ae.getSource()==btn_ingresar){
            String fxml = "";
            System.out.println(txt_user.getText() + " " + txt_password.getText());
            int num = ingresarUsuario(txt_user.getText(), txt_password.getText());
            System.out.println(">>>" + num);
            
            switch(num){
                case 1:
                    fxml = "InterfazPrincipalVendedor";
                    break;
                case 2:
                    fxml = "InterfazPrincipalJefeTaller";
                    break;
                case 3:
                    fxml = "InterfazPrincipalGerente";
                    break;
                case 0:
                    info.setText("Usuario y/o contraseña incorrectas\n"
                            + "Por favor intente nuevamente.");
                    break;    
            }
            if(num==1 || num==2 || num==3){
                try {
                    App.setRoot(fxml);
                } catch (IOException ex) {
                    System.err.println("Error con búsqueda de Interfaces: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
            
            
            /*try {
                String fxml = "";  
            int num = Integer.parseInt(txt_user.getText());
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
            }*/
            
            
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
