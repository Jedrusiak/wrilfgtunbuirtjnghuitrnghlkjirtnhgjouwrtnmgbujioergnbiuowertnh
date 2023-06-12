package es.etg.dam.examen.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import es.etg.dam.examen.model.Adquirible;
import es.etg.dam.examen.model.Producto;
import es.etg.dam.examen.model.Servicio;
import es.etg.dam.examen.model.banco.BancoException;
import es.etg.dam.examen.model.baseDatos.BaseDatosException;
import es.etg.dam.examen.model.impresora.ImpresoraException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PrincipalViewController extends ViewController{
    private ObservableList<Adquirible> adquiribles;

    @FXML
    private Button btnAddProducto;

    @FXML
    private Button btnAddServicio;

    @FXML
    private Button btnImprimir;

    @FXML
    private Button btnPagarCash;

    @FXML
    private Button btnPagarTarjeta;

    @FXML
    private TableColumn<?, ?> colDescripcion;

    @FXML
    private TableColumn<?, ?> colPrecio;

    @FXML
    private Label lblDireccionSupermercado;

    @FXML
    private Label lblIdSupermercado;

    @FXML
    private Label lblNombreSupermercado;

    @FXML
    private TableView<Adquirible> tblAdquiribles;

    @FXML
    private TextField txfProducto;

    @FXML
    private TextField txfServicio;

    @FXML
    public void initialize() throws Exception {
        adquiribles = FXCollections.observableArrayList();
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
    }

    @FXML
    void addProducto(MouseEvent event) throws BaseDatosException, SQLException {
        int id = Integer.parseInt(this.txfProducto.getText());
        
        Producto p = supermercadoController.obtenerProducto(id);
        this.adquiribles.add(p);
        this.tblAdquiribles.setItems(adquiribles);
        supermercadoController.getSupermercado().agregar(p);

    }

    @FXML
    void addServicio(MouseEvent event) throws BaseDatosException, SQLException {
        int id = Integer.parseInt(this.txfServicio.getText());
        
        Servicio s = supermercadoController.obtenerServicio(id);
        this.adquiribles.add(s);
        this.tblAdquiribles.setItems(adquiribles);
        supermercadoController.getSupermercado().agregar(s);

    }

    @FXML
    void imprimirTicket(MouseEvent event) throws FileNotFoundException, ImpresoraException, IOException {
        supermercadoController.generarTicket(supermercadoController.getSupermercado());
    }

    @FXML
    void pagarCash(MouseEvent event) {

    }

    @FXML
    void pagarTarjeta(MouseEvent event) throws BancoException {
        boolean success = supermercadoController.pagarDatafono();
        if (success == true){
            mostrarAviso("Éxito 😎", AlertType.INFORMATION);
        }
    }

    @Override
    public void cargarDatos() {
        lblIdSupermercado.setText(supermercadoController.getSupermercado().getId());
        lblNombreSupermercado.setText(supermercadoController.getSupermercado().getNombre());
        lblDireccionSupermercado.setText(supermercadoController.getSupermercado().getDireccion());
    }
}
