package es.etg.dam.examen.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import es.etg.dam.examen.App;
import es.etg.dam.examen.model.Descuento;
import es.etg.dam.examen.model.Producto;
import es.etg.dam.examen.model.Servicio;
import es.etg.dam.examen.model.Supermercado;
import es.etg.dam.examen.model.banco.BancoDAO;
import es.etg.dam.examen.model.banco.BancoDAOimp;
import es.etg.dam.examen.model.banco.BancoException;
import es.etg.dam.examen.model.baseDatos.BaseDatosDAO;
import es.etg.dam.examen.model.baseDatos.BaseDatosException;
import es.etg.dam.examen.model.baseDatos.SQLiteDAOimp;
import es.etg.dam.examen.model.ficheroInit.FicheroInitDAO;
import es.etg.dam.examen.model.ficheroInit.FicheroInitException;
import es.etg.dam.examen.model.ficheroInit.FicheroInitImp;
import es.etg.dam.examen.model.impresora.ImpresoraDAO;
import es.etg.dam.examen.model.impresora.ImpresoraDAOimp;
import es.etg.dam.examen.model.impresora.ImpresoraException;
import es.etg.dam.examen.view.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SupermercadoController extends Application {
    BancoDAO daoBanco;
    BaseDatosDAO daoBaseDatos;
    FicheroInitDAO daoFichero;
    ImpresoraDAO daoImpresora;
    Supermercado supermercado;

    private static Stage currentStage;

    public SupermercadoController(){
        daoBanco = new BancoDAOimp();
        daoBaseDatos = new SQLiteDAOimp();
        daoFichero = new FicheroInitImp();
        daoImpresora = new ImpresoraDAOimp();
    }

    @Override
    public void start(Stage stage) throws Exception {
        currentStage = stage;
        supermercado = inicializarSupermercado();
        cargarVista("view/PrincipalView.fxml");
    }
    public void cargarVista(String ficheroView) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView));
        Parent root = fxmlLoader.load();

        ViewController viewController = fxmlLoader.getController();
        viewController.setSupermercadoController(this);
        Scene scene = new Scene(root);
        currentStage.close();
        currentStage.setScene(scene);
        currentStage.show();

        viewController.cargarDatos();
    }
    public Descuento obtenerDescuento(int id) throws BaseDatosException, SQLException{
        return daoBaseDatos.obtenerDescuento(id);
    }
    public Producto obtenerProducto(int id) throws BaseDatosException, SQLException{
        return daoBaseDatos.obtenerProducto(id);
    }
    public Servicio obtenerServicio(int id) throws BaseDatosException, SQLException{
        return daoBaseDatos.obtenerServicio(id);
    }
    public boolean pagarDatafono() throws BancoException{
        return daoBanco.pagarDatafono();
    }
    public Supermercado inicializarSupermercado() throws FicheroInitException, IOException{
        return daoFichero.inicializarSupermercado();
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public static Stage getCurrentStage() {
        return currentStage;
    }
    public void generarTicket(Supermercado supermercado) throws ImpresoraException, FileNotFoundException, IOException{
        daoImpresora.generarTicket(supermercado);
    } 
}
