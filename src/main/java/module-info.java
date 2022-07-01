module com.proyecto.proyecto_desarrollo_software_i {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.proyecto.proyecto_desarrollo_software_i to javafx.fxml;
    exports com.proyecto.proyecto_desarrollo_software_i;
}
