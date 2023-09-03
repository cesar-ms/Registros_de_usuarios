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
import static fes.aragon.ui.PaginasFXML.LISTAREGISTRO;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Julio
 */
public class ModificarUsuarioController extends BaseControlador implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Dialogo de confirmacion");
        alerta.setHeaderText("Confirmacion de modificacion");
        alerta.setContentText("¿Estas seguro de modificar el usuario?");

        if (Objects.nonNull(modificarUsuario)) {
            txtNombre.setText(modificarUsuario.getNombre());
            txtApPaterno.setText(modificarUsuario.getApPaterno());
            txtApMaterno.setText(modificarUsuario.getApMaterno());
            txtEdad.setText(modificarUsuario.getEdad());
            txtCorreo.setText(modificarUsuario.getCorreo());
            btnAceptar.setText("Aceptar");
        }

    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        navegar(event, LISTAREGISTRO.getPagina());
    }

    @FXML
    private void aceptar(ActionEvent event) throws IOException {
        Optional<ButtonType> Resultado = alerta.showAndWait();
        if (Resultado.get().equals(OK)) {
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

    }

}
