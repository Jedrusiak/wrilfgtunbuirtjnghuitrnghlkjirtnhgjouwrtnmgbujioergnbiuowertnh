package es.etg.dam.examen.view;

import es.etg.dam.examen.controller.SupermercadoController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ViewController {
    protected SupermercadoController supermercadoController;

    public void setSupermercadoController(SupermercadoController controller){
        this.supermercadoController = controller;
    }
    
    public void mostrarAviso(String msg, AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle("Importante");
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
    public void cargarDatos(){
        
    }
}
