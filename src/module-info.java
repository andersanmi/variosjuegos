module variosjuegos {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.swt;
    opens main;
    exports main.ges;//sin esto los archivos deberian de estar en el mismo source
}