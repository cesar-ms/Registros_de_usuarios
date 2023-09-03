/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ui;

import fes.aragon.modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Julio
 */
public class BaseControlador {

    protected Alert alerta;

    public static ObservableList<Usuario> datos = FXCollections.
            <Usuario>observableArrayList(
                    new Usuario("Julio Cesar", "Morales", "Sierra", "22", "juliozaaks23@aragon.unam.mx"),
                    new Usuario("Miguel", "Ramírez", "Gonzales", "25", "miguelramirez12@aragon.unam.mx"),
                    new Usuario("Jose", "Cabañas", "Orozco", "26", "josecabañas13@aragon.unam.mx"),
                    new Usuario("Raul", "Guzmán", "Hernández", "32", "raulguzman45@aragon.unam.mx"),
                    new Usuario("Pedro", "Salas", "Gutiérrez", "29", "pedrosalas65@aragon.unam.mx"));

    public static Usuario modificarUsuario = null;

    protected void navegar(Event event, URL faxmoDoc) throws IOException {
        Parent pagina = FXMLLoader.load(faxmoDoc);
        Scene escena = new Scene(pagina);
        Stage appEscenario = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appEscenario.hide();
        appEscenario.setScene(escena);
        appEscenario.show();

    }

}
