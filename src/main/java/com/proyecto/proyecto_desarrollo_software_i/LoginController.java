/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.proyecto.proyecto_desarrollo_software_i;
import com.proyecto.proyecto_desarrollo_software_i.modelo.Usuario;
import com.proyecto.proyecto_desarrollo_software_i.sql.CrudSQL;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                    info.setText("Usuario y/o contraseña incorrectas.\n"
                            + "Si el problema persiste comuníquese con la empresa.");
                    break;    
            }
            if(num==1 || num==2 || num==3){
                try {
                    obtenerInfoUsuario();
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
    
    public void obtenerInfoUsuario(){
        
        try {
            String id = crud_buscar_manual("id_usuario", "usuario", "cedula='"+txt_user.getText()+"'", 1);
            String nombre = crud_buscar_manual("nombre", "usuario", "cedula='"+txt_user.getText()+"'", 1);
            String cedula = crud_buscar_manual("cedula", "usuario", "cedula='"+txt_user.getText()+"'", 1);
            String cargo = crud_buscar_manual("cargo", "usuario", "cedula='"+txt_user.getText()+"'", 1);
            
            
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            //Usuario a = new Usuario();
            Usuario.conectar(id, nombre, cedula, cargo);
            System.out.println(Usuario.getNombre());
        } catch (SQLException ex) {
            info.setText("Error de búsqueda: "+ex.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
