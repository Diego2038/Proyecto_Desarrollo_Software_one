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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import com.proyecto.proyecto_desarrollo_software_i.App;
import com.proyecto.proyecto_desarrollo_software_i.modelo.Usuario;
import com.proyecto.proyecto_desarrollo_software_i.sql.CrudSQL;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Diego
 */
public class CrudOrdenController extends CrudSQL implements Initializable {
    
    
    @FXML
    VBox panelDeOpciones;
    @FXML
    AnchorPane panelDeDespliegue;
    @FXML
    Button btn_gestion_usuarios;
    @FXML
    Button btn_gestion_sedes;
    @FXML
    Button btn_gestion_vehiculos;
    @FXML
    Button btn_autorizacion_ventas_autos;
    @FXML
    Button btn_autorizacion_traslado_autos;
    @FXML
    Button btn_ver_reporte_general;
    @FXML
    Button btn_ver_mi_reporte;
    @FXML
    Button btn_gestion_cliente;
    @FXML
    Button btn_gestion_ordenes;
    @FXML
    Button btn_gestion_repuestos;
    @FXML
    Button btn_gestion_cliente_auto;
    @FXML
    Button btn_gestion_venta_de_vehiculos;
    @FXML
    Button btn_solicitud_traslado_de_vehiculo;
    
    
    private Usuario usuario;
    ArrayList<Node> componentesCondicion;
    ArrayList<Node> componentesBusquedaYCondicion;
    ArrayList<Labeled> componentesLabelSeleccion_Modificacion;
    ArrayList<Labeled> componentesLabelCondicion;
    ArrayList<TextField> componentesTextField;
    ArrayList<Button> componentesBotonesOpciones;

    @FXML
    Button btn_cerrar_sesion;
    @FXML
    Button btn_guardar_usuario;
    @FXML
    Button btn_buscar_usuario;
    @FXML
    RadioButton rb_buscar_global_usuario;
    @FXML
    RadioButton rb_habilitar_condicion_de_modificacion;
    @FXML
    Button btn_modificar_usuario;
    
    /////
    @FXML
    TextField txt_id_orden_condicion;
    
    @FXML
    TextField txt_cedula_cliente_condicion;
    @FXML
    TextField txt_placa_condicion;
    @FXML
    TextField txt_cedula_jefetaller_condicion;
    
    
    @FXML
    Label l_columna_seleccion_modificacion;
    @FXML
    Label l_seleccion_modificacion1;
    @FXML
    Label l_seleccion_modificacion2;
    @FXML
    Label l_seleccion_modificacion3;
    @FXML
    Label l_columna_condicion;
    @FXML
    Label l_condicion1;
    @FXML
    Label l_condicion2;
    @FXML
    Label l_condicion3;
    
    ////
    
    
    
    @FXML
    TextField txt_cedula_cliente;
    @FXML
    TextField txt_id_orden;
    @FXML
    TextField txt_placa;
    @FXML
    TextField txt_cedula_jefetaller;
    @FXML
    TextField txt_precio_base;
    @FXML
    TextField txt_precio_MIN;
    @FXML
    TextField txt_precio_MAX;
    @FXML
    DatePicker dp_fecha;
    @FXML
    DatePicker dp_fecha_MIN;
    @FXML
    DatePicker dp_fecha_MAX;
    @FXML
    RadioButton rb_sueldo;
    @FXML
    RadioButton rb_fecha;
    @FXML
    Label info;
    
    @FXML
    ChoiceBox<String> cb_seleccion1;
    @FXML
    ChoiceBox<String> cb_seleccion2;
    @FXML
    ChoiceBox<String> cb_seleccion3;
    @FXML
    ChoiceBox<String> cb_condicion1;
    @FXML
    ChoiceBox<String> cb_condicion2;
    @FXML
    ChoiceBox<String> cb_condicion3;
    
    @FXML
    Label info_nombre;
    @FXML
    Label info_cedula;
    @FXML
    Label info_cargo;
    
    
    @FXML
    TextArea txt_area;
    @FXML
    TextArea txt_descripcion;
    
    
    public void cambiarInterfaz(ActionEvent ae){
        String fxml = "";
        if(ae.getSource()==btn_gestion_usuarios){
            fxml = "CrudUsuario_Gerente";
        }else if(ae.getSource()==btn_gestion_sedes){
            fxml = "CrudSede";
        }else if(ae.getSource()==btn_gestion_vehiculos){
            fxml = "CrudAutoVenta";
        }else if(ae.getSource()==btn_autorizacion_ventas_autos){
            fxml = "AutorizacionVentaVehiculo";
        }else if(ae.getSource()==btn_autorizacion_traslado_autos){
            fxml = "AutorizacionTrasladoVehiculo";
        }else if(ae.getSource()==btn_ver_reporte_general){
            fxml = "ReportesGenerales";
        }else if(ae.getSource()==btn_ver_mi_reporte){
            fxml = "ReportePersonal";
        }else if(ae.getSource()==btn_gestion_cliente){
            fxml = "CrudCliente"; 
        }else if(ae.getSource()==btn_gestion_cliente_auto){
            fxml = "CrudAutoCliente";
        }else if(ae.getSource()==btn_gestion_ordenes){
            fxml = "CrudOrden"; 
        }else if(ae.getSource()==btn_gestion_repuestos){
            fxml = "CrudRepuesto"; 
        }else if(ae.getSource()==btn_cerrar_sesion){
            fxml = "Login";
        }else if(ae.getSource()==btn_gestion_venta_de_vehiculos){
            fxml = "CrudVentaVehiculo";
        }else if(ae.getSource()==btn_solicitud_traslado_de_vehiculo){
            fxml = "SolicitudTrasladoVehiculoVenta";
        }
        System.out.println(fxml);
        info.setText(fxml);
        try {
            App.setRoot(fxml);
        } catch (IOException ex) {
            System.err.println("Error con búsqueda de interfaz: " + ex.getMessage());
        }
    }
    
    public void accionBoton(ActionEvent ae){
        if (ae.getSource() == btn_guardar_usuario) {
            info.setText("Registrando...");
            try {
                if (verificadorSizeCelda(txt_id_orden, 1, 6) 
                        && verificadorSizeCelda(txt_cedula_cliente, 1, 6)
                        && verificadorSizeCelda(txt_placa, 1, 6)
                        && verificadorSizeCelda(txt_cedula_jefetaller, 1, 11) 
                        && verificadorSizeCelda(txt_precio_base, 3, 9)) {
                    
                    int comision =(int) (Integer.parseInt(txt_precio_base.getText().trim())*0.10);
                    
                    crud_registrar("orden_de_trabajo", "id_orden", "id_cliente", "id_auto", 
                            "id_usuario_jt", "descripcion", "precio_reparacion", "fecha_reparacion", 
                            "comision_a_jefe",txt_id_orden.getText().trim(), txt_cedula_cliente.getText().trim(), 
                            txt_placa.getText().trim(), Usuario.getId(), 
                            txt_descripcion.getText().trim(), txt_precio_base.getText().trim(), 
                            dp_fecha.getValue().toString(), Integer.toString(comision));
                    
                    borrarDatosTextField(componentesTextField);
                    dp_fecha.setValue(LocalDate.now());
                    info.setText("Órden registrada exitosamente.");

                } else {
                    info.setText("Tamaño incorrecto de parámetros. Escriba el tamaño adecuado.");
                    txt_area.setText("TAMAÑO DE CARACTERES PARA EL REGISTRO\n");

                }
            } catch (SQLException ex) {
                info.setText("Error parámetros de registro");
                txt_area.setText("Causa: " + ex.getMessage());
            }
            
        }else if(ae.getSource()==btn_buscar_usuario){
            int NUM_SELECCION = 0;
            String SELECCION = "*";
            String CONDICION = ""; 
            // ELABORACIÓN DE LA SELECCIÓN
            if(!"-".equals(cb_seleccion1.getValue()) && !(cb_seleccion1.getValue()==null)){
                NUM_SELECCION++;
                SELECCION = extendPalabra(SELECCION, traducirPalabra(cb_seleccion1.getValue()), false);
            }if (!"-".equals(cb_seleccion2.getValue()) && !(cb_seleccion2.getValue() == null)) {
                NUM_SELECCION++;
                SELECCION = extendPalabra(SELECCION, traducirPalabra(cb_seleccion2.getValue()), false);
            }if (!"-".equals(cb_seleccion3.getValue()) && !(cb_seleccion3.getValue() == null)) {
                NUM_SELECCION++;
                SELECCION = extendPalabra(SELECCION, traducirPalabra(cb_seleccion3.getValue()), false);
            }
            // ELABORACIÓN DE LA CONDICIÓN
            if (!"-".equals(cb_condicion1.getValue()) && !(cb_condicion1.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion1.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_condicion1.getValue()))+"'", true);
                
            }if (!"-".equals(cb_condicion2.getValue()) && !(cb_condicion2.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion2.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_condicion2.getValue()))+"'", true);
            }if (!"-".equals(cb_condicion3.getValue()) && !(cb_condicion3.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion3.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_condicion3.getValue()))+"'", true);
            }
            // ELABORACIÓN DE CONDICIÓN DE RANGOS
            if(rb_sueldo.isSelected()){
                CONDICION = extendPalabra(CONDICION," precio_reparacion>="+txt_precio_MIN.getText().trim()+" AND "
                        + "precio_reparacion<="+txt_precio_MAX.getText().trim(), true);
            }if(rb_fecha.isSelected()){
                CONDICION = extendPalabra(CONDICION," fecha_reparacion>='"+dp_fecha_MIN.getValue().toString()
                        +"'"+" AND "+ "fecha_reparacion<='"+dp_fecha_MAX.getValue().toString()+"'", true);
            }
            //>>>>//
            String resultado = "";
            try {
                
                resultado = crud_buscar_manual(SELECCION, "orden_de_trabajo", CONDICION,NUM_SELECCION);
                info.setText("Búsqueda realizada");
                txt_area.setText("RESULTADOS GLOBALES\n" + resultado);
                System.out.println("OJO---->" + SELECCION);
            } catch (SQLException ex) {
                info.setText("Error parámetros de búsqueda");
                txt_area.setText("Causa: " + ex.getMessage());
            }
            
            
        }else if(ae.getSource()==btn_modificar_usuario){
            
            ////////////////////////////77-->>>>>>>>>>>>>>
            
            String ACTUALIZACION = "*";
            String CONDICION = ""; 
            // ELABORACIÓN DE LA ACTUALIZACIÓN
            if(!"-".equals(cb_seleccion1.getValue()) && !(cb_seleccion1.getValue()==null)){
                ACTUALIZACION = extendPalabra(ACTUALIZACION, traducirPalabra(cb_seleccion1.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_seleccion1.getValue()))+"'", false);
            }if (!"-".equals(cb_seleccion2.getValue()) && !(cb_seleccion2.getValue() == null)) {
                ACTUALIZACION = extendPalabra(ACTUALIZACION, traducirPalabra(cb_seleccion2.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_seleccion2.getValue()))+"'", false);
            }if (!"-".equals(cb_seleccion3.getValue()) && !(cb_seleccion3.getValue() == null)) {
                ACTUALIZACION = extendPalabra(ACTUALIZACION, traducirPalabra(cb_seleccion3.getValue())+"='"
                        +seleccionarValor(traducirPalabra(cb_seleccion3.getValue()))+"'", false);
            }
            // ELABORACIÓN DE LA CONDICIÓN
            if (!"-".equals(cb_condicion1.getValue()) && !(cb_condicion1.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion1.getValue())+"='"
                        +seleccionarValorSegundaColumna(traducirPalabra(cb_condicion1.getValue()))+"'", true);
                
            }if (!"-".equals(cb_condicion2.getValue()) && !(cb_condicion2.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion2.getValue())+"='"
                        +seleccionarValorSegundaColumna(traducirPalabra(cb_condicion2.getValue()))+"'", true);
            }if (!"-".equals(cb_condicion3.getValue()) && !(cb_condicion3.getValue() == null)) {
                CONDICION = extendPalabra(CONDICION, traducirPalabra(cb_condicion3.getValue())+"='"
                        +seleccionarValorSegundaColumna(traducirPalabra(cb_condicion3.getValue()))+"'", true);
            }
            // ELABORACIÓN DE CONDICIÓN DE RANGOS
            if(rb_sueldo.isSelected()){
                CONDICION = extendPalabra(CONDICION," precio_reparacion>="+txt_precio_MIN.getText().trim()+" AND "
                        + "precio_reparacion<="+txt_precio_MAX.getText().trim(), true);
            }if(rb_fecha.isSelected()){
                CONDICION = extendPalabra(CONDICION," fecha_reparacion>='"+dp_fecha_MIN.getValue().toString()
                        +"'"+" AND "+ "fecha_reparacion<='"+dp_fecha_MAX.getValue().toString()+"'", true);
            }
            try {
                //>>>>//
                crud_modificar_manual("orden_de_trabajo", ACTUALIZACION, CONDICION);
                info.setText("Sede modificada exitosamente");
            } catch (SQLException ex) {
                info.setText("Error actualización");
                txt_area.setText("Causa: " + ex.getMessage());
            }
            borrarDatosTextField(componentesTextField);
            dp_fecha.setValue(LocalDate.now());
        }
    }
    
    public String seleccionarValor(String nombre){
        String resultado = "";
        if("id_orden".equals(nombre)){
            resultado = txt_id_orden.getText().trim();
        }else if("id_cliente".equals(nombre)){
            resultado = txt_cedula_cliente.getText().trim();
        }else if("id_auto".equals(nombre)){
            resultado = txt_placa.getText().trim();
        }else if("id_usuario_jt".equals(nombre)){
            resultado = txt_cedula_jefetaller.getText().trim();
        }else if("descripcion".equals(nombre)){
            resultado = txt_descripcion.getText().trim();
        }else if("precio_reparacion".equals(nombre)){
            resultado = txt_precio_base.getText().trim();
        }else if("fecha_reparacion".equals(nombre)){
            resultado = dp_fecha.getValue().toString();
        }
        return resultado;
    }
    
    
    public String seleccionarValorSegundaColumna(String nombre){
        String resultado = "";
        if("id_orden".equals(nombre)){
            resultado = txt_id_orden_condicion.getText().trim();
        }else if("id_cliente".equals(nombre)){
            resultado = txt_cedula_cliente_condicion.getText().trim();
        }else if("id_auto".equals(nombre)){
            resultado = txt_placa_condicion.getText().trim();
        }else if("id_usuario_jt".equals(nombre)){
            resultado = txt_cedula_jefetaller_condicion.getText().trim();
        }
        return resultado;
    }
    
    
    
    public void cambiarVisibilidadRoundButton(ActionEvent ae){
        cb_condicion1.setValue("ID orden");
        variarVisibilidad(ae, rb_buscar_global_usuario, rb_habilitar_condicion_de_modificacion,
            btn_modificar_usuario, btn_buscar_usuario, btn_guardar_usuario, componentesCondicion,
            componentesBusquedaYCondicion, l_columna_seleccion_modificacion, 
            componentesLabelSeleccion_Modificacion);
    }
    
    
    public void registrarCargoUsuario(){
        try {
            // Queda pendiente en ver cómo registrar a un gerente (no lo decía en el enunciado)
            String tabla = "";
            String nombreVariableId = "";
            usuario = new Usuario();
            String cargo_empleado = crud_buscar_manual("cargo", "usuario", "cedula=" + "'" + txt_id_orden.getText().trim() + "'", 1).trim();
            
            if ("jefe de taller".equals(cargo_empleado)) {
                tabla = "jefe_de_taller";
                nombreVariableId = "id_usuario_jt";
            } else if ("vendedor".equals(cargo_empleado)) {
                tabla = "vendedor";
                nombreVariableId = "id_usuario_v";
            }
            // AQUÍ TE HACE EN VERDAD MUCHA FALTA LA CLASE VARIABLES
            String id_empleado = crud_buscar_manual("id_usuario", "usuario", "cedula=" + "'" + txt_id_orden.getText().trim() + "'", 1).trim();
            
            System.out.println("tabla: " + tabla);
            System.out.println("cargo del usuario: "+cargo_empleado);
            crud_registrar(tabla, nombreVariableId, "id_usuario_g", id_empleado, usuario.getId());
            txt_descripcion.setText("");
        } catch (SQLException ex) {
            info.setText("Error búsqueda condició de actualización: \n" + ex.getMessage());
        }
    }
    
    
    public void retornarInterfaz(String fxml){
        try {
                //App.setRoot("InterfazPrincipalGerente");
                App.setRoot(fxml);
                System.out.println("Regreso a la interfaz principal");
            } catch (IOException ex) {
                System.err.println("Error conexión interfaz: " + ex.getMessage());
            }
    }
    
    
    public void cambioColorDentro(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_gestion_usuarios){
           boton = btn_gestion_usuarios;
        }else if(me.getSource() == btn_gestion_sedes){
           boton = btn_gestion_sedes;
        }else if(me.getSource() == btn_gestion_vehiculos){
           boton = btn_gestion_vehiculos;
        }else if(me.getSource() == btn_autorizacion_ventas_autos){
           boton = btn_autorizacion_ventas_autos;
        }else if(me.getSource() == btn_gestion_venta_de_vehiculos){
           boton = btn_gestion_venta_de_vehiculos;
        }else if(me.getSource() == btn_autorizacion_traslado_autos){
           boton = btn_autorizacion_traslado_autos;
        }else if(me.getSource() == btn_solicitud_traslado_de_vehiculo){
           boton = btn_solicitud_traslado_de_vehiculo;
        }else if(me.getSource() == btn_gestion_cliente){
           boton = btn_gestion_cliente;
        }else if(me.getSource() == btn_gestion_cliente_auto){
           boton = btn_gestion_cliente_auto;
        }else if(me.getSource() == btn_gestion_ordenes){
           boton = btn_gestion_ordenes;
        }else if(me.getSource() == btn_gestion_repuestos){
           boton = btn_gestion_repuestos;
        }else if(me.getSource() == btn_ver_reporte_general){
           boton = btn_ver_reporte_general;
        }else if(me.getSource() == btn_ver_mi_reporte){
           boton = btn_ver_mi_reporte;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(20),null))); 
    }
    
    
    public void cambioColorDentro2(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_cerrar_sesion){
           boton = btn_cerrar_sesion;
        }else if(me.getSource() == btn_buscar_usuario){
           boton = btn_buscar_usuario;
        }else if(me.getSource() == btn_guardar_usuario){
           boton = btn_guardar_usuario;
        }else if(me.getSource() == btn_modificar_usuario){
           boton = btn_modificar_usuario;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(0, 37, 26),
                new CornerRadii(10),null))); 
    }
    
    
    public void cambioColorFuera(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_gestion_usuarios){
           boton = btn_gestion_usuarios;
        }else if(me.getSource() == btn_gestion_sedes){
           boton = btn_gestion_sedes;
        }else if(me.getSource() == btn_gestion_vehiculos){
           boton = btn_gestion_vehiculos;
        }else if(me.getSource() == btn_autorizacion_ventas_autos){
           boton = btn_autorizacion_ventas_autos;
        }else if(me.getSource() == btn_gestion_venta_de_vehiculos){
           boton = btn_gestion_venta_de_vehiculos;
        }else if(me.getSource() == btn_autorizacion_traslado_autos){
           boton = btn_autorizacion_traslado_autos;
        }else if(me.getSource() == btn_solicitud_traslado_de_vehiculo){
           boton = btn_solicitud_traslado_de_vehiculo;
        }else if(me.getSource() == btn_gestion_cliente){
           boton = btn_gestion_cliente;
        }else if(me.getSource() == btn_gestion_cliente_auto){
           boton = btn_gestion_cliente_auto;
        }else if(me.getSource() == btn_gestion_ordenes){
           boton = btn_gestion_ordenes;
        }else if(me.getSource() == btn_gestion_repuestos){
           boton = btn_gestion_repuestos;
        }else if(me.getSource() == btn_ver_reporte_general){
           boton = btn_ver_reporte_general;
        }else if(me.getSource() == btn_ver_mi_reporte){
           boton = btn_ver_mi_reporte;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(0, 37, 26),null,null)));
    }
    
    public void cambioColorFuera2(MouseEvent me){
        Button boton = null;
        if(me.getSource() == btn_cerrar_sesion){
           boton = btn_cerrar_sesion;
        }else if(me.getSource() == btn_buscar_usuario){
           boton = btn_buscar_usuario;
        }else if(me.getSource() == btn_guardar_usuario){
           boton = btn_guardar_usuario;
        }else if(me.getSource() == btn_modificar_usuario){
           boton = btn_modificar_usuario;
        }
        boton.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(10),null)));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        componentesCondicion = new ArrayList<>();
        componentesCondicion.add(l_columna_condicion);
        componentesCondicion.add(txt_id_orden_condicion);
        componentesCondicion.add(txt_cedula_jefetaller_condicion);
        componentesCondicion.add(txt_cedula_cliente_condicion);
        componentesCondicion.add(txt_placa_condicion);
        modificarVisibilidadComponentesJavaFX(componentesCondicion, false);
        
        componentesBusquedaYCondicion = new ArrayList<>();
        componentesBusquedaYCondicion.add(l_condicion1);
        componentesBusquedaYCondicion.add(l_condicion2);
        componentesBusquedaYCondicion.add(l_condicion3);
        componentesBusquedaYCondicion.add(cb_seleccion1);
        componentesBusquedaYCondicion.add(cb_seleccion2);
        componentesBusquedaYCondicion.add(cb_seleccion3);
        componentesBusquedaYCondicion.add(l_seleccion_modificacion1);
        componentesBusquedaYCondicion.add(l_seleccion_modificacion2);
        componentesBusquedaYCondicion.add(l_seleccion_modificacion3);
        componentesBusquedaYCondicion.add(cb_condicion1);
        componentesBusquedaYCondicion.add(cb_condicion2);
        componentesBusquedaYCondicion.add(cb_condicion3);
        componentesBusquedaYCondicion.add(rb_sueldo);
        componentesBusquedaYCondicion.add(rb_fecha);
        componentesBusquedaYCondicion.add(txt_precio_MIN);
        componentesBusquedaYCondicion.add(txt_precio_MAX);
        componentesBusquedaYCondicion.add(dp_fecha_MIN);
        componentesBusquedaYCondicion.add(dp_fecha_MAX);
        
        componentesLabelCondicion = new ArrayList<>();
        componentesLabelCondicion.add(l_condicion1);
        componentesLabelCondicion.add(l_condicion2);
        componentesLabelCondicion.add(l_condicion3);
        
        componentesLabelSeleccion_Modificacion = new ArrayList<>();
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion1);
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion2);
        componentesLabelSeleccion_Modificacion.add(l_seleccion_modificacion3);
        
        componentesTextField = new ArrayList<>();
        componentesTextField.add(txt_id_orden);
        componentesTextField.add(txt_cedula_cliente);
        componentesTextField.add(txt_placa);
        componentesTextField.add(txt_cedula_jefetaller);
        componentesTextField.add(txt_precio_base);
        componentesTextField.add(txt_id_orden_condicion);
        componentesTextField.add(txt_cedula_cliente_condicion);
        componentesTextField.add(txt_placa_condicion);
        componentesTextField.add(txt_cedula_jefetaller_condicion);
        
        
        String LISTA_SELECCION[] = {"-","ID orden","ID cliente","ID auto","ID jefe de taller","Descripción",
        "Precio de la orden","Fecha de la orden",}; 
        String LISTA_CONDICION[] = {"-","ID orden","ID cliente","ID auto","ID jefe de taller"}; 
        
        
        
        cb_seleccion1.getItems().addAll(LISTA_SELECCION);
        cb_seleccion2.getItems().addAll(LISTA_SELECCION);
        cb_seleccion3.getItems().addAll(LISTA_SELECCION);
        cb_condicion1.getItems().addAll(LISTA_CONDICION);
        cb_condicion2.getItems().addAll(LISTA_CONDICION);
        cb_condicion3.getItems().addAll(LISTA_CONDICION);
        
        dp_fecha = new DatePicker(LocalDate.now());
        rb_buscar_global_usuario.setSelected(true);
        btn_modificar_usuario.setVisible(false);
        btn_guardar_usuario.setVisible(false);
        
        
        cb_condicion1.setValue("ID orden");
        
        //System.out.println(getUsuario().hashCode());
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        System.out.println(Usuario.getNombre());
        
        info_nombre.setText(Usuario.getNombre());
        info_cedula.setText(Usuario.getCedula());
        info_cargo.setText(Usuario.getCargo());
        
        componentesBotonesOpciones = new ArrayList<>();
        componentesBotonesOpciones.add(btn_gestion_usuarios);
        componentesBotonesOpciones.add(btn_gestion_sedes);
        componentesBotonesOpciones.add(btn_gestion_vehiculos);
        componentesBotonesOpciones.add(btn_autorizacion_ventas_autos);
        componentesBotonesOpciones.add(btn_gestion_venta_de_vehiculos);
        componentesBotonesOpciones.add(btn_autorizacion_traslado_autos);
        componentesBotonesOpciones.add(btn_solicitud_traslado_de_vehiculo);
        componentesBotonesOpciones.add(btn_gestion_cliente);
        componentesBotonesOpciones.add(btn_gestion_cliente_auto);
        componentesBotonesOpciones.add(btn_gestion_ordenes);
        componentesBotonesOpciones.add(btn_gestion_repuestos);
        componentesBotonesOpciones.add(btn_ver_reporte_general);
        componentesBotonesOpciones.add(btn_ver_mi_reporte);

        filtrarBotonesInterfaces(componentesBotonesOpciones, panelDeOpciones);
        
        cambiarColorOscuroBotones(componentesBotonesOpciones);
        btn_cerrar_sesion.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(10),null))); 
        btn_buscar_usuario.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(10),null)));
        btn_guardar_usuario.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(10),null)));
        btn_modificar_usuario.setBackground(new Background(new BackgroundFill(Color.rgb(56,120,106),
                new CornerRadii(10),null))); 

        // xd = new Usuario();
        //System.out.println(xd.getNombre());
        
        // Probando quitar botones:
        //panelDeOpciones.getChildren().remove(btn_gestion_usuarios); // para quitar componentes de un panel
    }    
    
}

