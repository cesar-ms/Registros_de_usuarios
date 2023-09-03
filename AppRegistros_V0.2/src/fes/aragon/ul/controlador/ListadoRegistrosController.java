/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ul.controlador;

import fes.aragon.modelo.Usuario;
import fes.aragon.ui.BaseControlador;
import static fes.aragon.ui.BaseControlador.datos;
import static fes.aragon.ui.BaseControlador.modificarUsuario;
import static fes.aragon.ui.PaginasFXML.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Julio
 */
public class ListadoRegistrosController extends BaseControlador implements Initializable {

    @FXML
    private TextField txtBuscarUsuario;
    @FXML
    private TableView<Usuario> listaDeUsuarios;
    @FXML
    private TableColumn tblNombre;
    @FXML
    private TableColumn tblPaterno;
    @FXML
    private TableColumn tblMaterno;
    @FXML
    private TableColumn tblEdad;
    @FXML
    private TableColumn tblCorreo;
    @FXML
    private Label lblNumeroUsuario;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button tbnBorrar;
    @FXML
    private Button tblModificar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.tblNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        this.tblPaterno.setCellValueFactory(new PropertyValueFactory<>("ApPaterno"));
        this.tblMaterno.setCellValueFactory(new PropertyValueFactory<>("ApMaterno"));
        this.tblEdad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        this.tblCorreo.setCellValueFactory(new PropertyValueFactory<>("Correo"));

        this.lblNumeroUsuario.textProperty().bind(Bindings.createStringBinding(() -> datos.size() + " :Usuarios registrados", datos));

        alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Dialogo de confirmación");
        alerta.setHeaderText("Confirmación de eliminación");
        alerta.setContentText("¿Estás seguro de eliminar a este usuario?");

        FilteredList<Usuario> filtroDato = new FilteredList<>(datos, n -> true);

        this.txtBuscarUsuario.setOnKeyReleased(e -> {
            filtroDato.setPredicate(n -> {
                if (this.txtBuscarUsuario.getText() == null || this.txtBuscarUsuario.getText().isEmpty()) {
                    return true;
                }
                return n.getNombre().contains(txtBuscarUsuario.getText()) || n.getApPaterno().contains(txtBuscarUsuario.getText());
            });
        });

        this.listaDeUsuarios.setItems(filtroDato);

    }

    private Usuario getItem() {
        return Usuario.class.cast(listaDeUsuarios.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        navegar(event, REGISTROUSUARIO.getPagina());
    }

    @FXML
    private void borrar(ActionEvent event) {
        Optional<ButtonType> Resultado = alerta.showAndWait();
        if (Resultado.get().equals(OK)) {
            datos.remove(getItem());
        }
    }

    @FXML
    private void modificar(ActionEvent event) throws IOException {

        modificarUsuario = null;
        modificarUsuario = getItem();
        if (Objects.nonNull(modificarUsuario)) {
            navegar(event, MODIFICARUSUARIO.getPagina());
        }

    }

}
