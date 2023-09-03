/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ul.controlador;

import fes.aragon.modelo.Usuario;
import fes.aragon.ui.BaseControlador;
import static fes.aragon.ui.PaginasFXML.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Julio
 */
public class RegistroDeUsuarioController extends BaseControlador implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApPaterno;
    @FXML
    private TextField txtApMaterno;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnTablaRegistro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Dialogo de aviso");
        alerta.setHeaderText("Datos invalidos para registrar");
        alerta.setContentText("Por favor rellene todos los campos solicitados");

    }

    @FXML
    private void cancelar(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void aceptarRegistro(ActionEvent event) throws IOException {
        if (Objects.nonNull(modificarUsuario)) {
            datos.remove(modificarUsuario);
        }
        if (txtNombre.getText().trim().equals("")
                || txtApPaterno.getText().trim().equals("")
                || txtApMaterno.getText().trim().equals("")
                || txtEdad.getText().trim().equals("")
                || txtCorreo.getText().trim().equals("")) {
            alerta.showAndWait();
            return;
        }

        datos.add(new Usuario(txtNombre.getText(), txtApPaterno.getText(), txtApMaterno.getText(), txtEdad.getText(), txtCorreo.getText()));
        navegar(event, LISTAREGISTRO.getPagina());

    }

    @FXML
    private void verTablaDeRegistro(ActionEvent event) throws IOException {
        navegar(event, LISTAREGISTRO.getPagina());
    }

}
