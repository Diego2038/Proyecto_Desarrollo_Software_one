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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

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
    Button btn_cerrar;
    @FXML
    Label info;
    
    public void ingresar(ActionEvent ae){
        if(ae.getSource()==btn_ingresar){
            String fxml = "";
            System.out.println(txt_user.getText().trim() + " " + txt_password.getText());
            int num = ingresarUsuario(txt_user.getText().trim(), txt_password.getText());
            System.out.println(">>>" + num);
            
            if(num==1 || num==2 || num==3){
                fxml = "CrudUsuario_Gerente"; // OJO, debe estar en los clientes, por el momento
            }else{
                info.setText("Usuario y/o contraseña incorrectas.\n"
                            + "Si el problema persiste comuníquese con la empresa.");
            }
            /*
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
            */
            
            
            if (num == 1 || num == 2 || num == 3) {
                try {
                    obtenerInfoUsuario();
                    ///
                    try {
                        String idGerente = "";
                        switch (num) {
                            case 1:
                                idGerente = crud_buscar_manual("id_usuario_g", "vendedor", "id_usuario_v='" + Usuario.getId() + "'", 1);
                                break;
                            case 2:
                                idGerente = crud_buscar_manual("id_usuario_g", "jefe_de_taller", "id_usuario_jt='" + Usuario.getId() + "'", 1);
                                break;
                            case 3:
                                idGerente = Usuario.getId();
                                break;
                            default:
                                break;
                        }
                        String sede = crud_buscar_manual("id_sede", "gerente", "id_usuario_g='" + idGerente + "'", 1);
                        Usuario.setSede(sede);

                    } catch (SQLException ex) {
                        info.setText("Error: " + ex.getMessage());
                    }
                    ///
                    App.setRoot(fxml);
                } catch (IOException ex) {
                    System.err.println("Error con búsqueda de Interfaces: " + ex.getMessage());
                }
            }

            
            
            
            
            
            /*
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
            
            
        }else if(ae.getSource()==btn_cerrar){
            System.exit(0);
        }
    }
    
    public void obtenerInfoUsuario(){
        
        try {
            String id = crud_buscar_manual("id_usuario", "usuario", "cedula='"+txt_user.getText().trim()+"'", 1);
            String nombre = crud_buscar_manual("nombre", "usuario", "cedula='"+txt_user.getText().trim()+"'", 1);
            String cedula = crud_buscar_manual("cedula", "usuario", "cedula='"+txt_user.getText().trim()+"'", 1);
            String cargo = crud_buscar_manual("cargo", "usuario", "cedula='"+txt_user.getText().trim()+"'", 1);
            
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            //Usuario a = new Usuario();
            Usuario.conectar(id, nombre, cedula, cargo);
            System.out.println(Usuario.getNombre());
        } catch (SQLException ex) {
            info.setText("Error de búsqueda: "+ex.getMessage());
        }
    }
    
    public void cambioColorDentro(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_ingresar){
           boton = btn_ingresar;
        }else if(me.getSource() == btn_cerrar){
           boton = btn_cerrar;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(20),null))); 
    }
    
    
    public void cambioColorDentro2(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_cerrar){
           boton = btn_cerrar;
        }else if(me.getSource() == btn_ingresar){
           boton = btn_ingresar;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(0, 37, 26),
                new CornerRadii(10),null))); 
    }
    
    
    public void cambioColorFuera(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_ingresar){
           boton = btn_ingresar;
        }else if(me.getSource() == btn_cerrar){
           boton = btn_cerrar;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(0, 37, 26),null,null)));
    }
    
    public void cambioColorFuera2(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_cerrar){
           boton = btn_cerrar;
        }else if(me.getSource() == btn_ingresar){
           boton = btn_ingresar;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(10),null)));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_cerrar.setBackground(new Background(new BackgroundFill(Color.rgb(0, 37, 26),
                new CornerRadii(20),null)));
        btn_ingresar.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(10),null)));
    }    
    
}
