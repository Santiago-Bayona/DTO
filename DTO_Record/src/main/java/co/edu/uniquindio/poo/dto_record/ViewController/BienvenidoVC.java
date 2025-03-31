package co.edu.uniquindio.poo.dto_record.ViewController;
import co.edu.uniquindio.poo.dto_record.App;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class BienvenidoVC {

    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane sideBar;

    @FXML
    private Button btt_InformacionPartido;

    @FXML
    private Button btt_Miembros;

    @FXML
    private Button btt_Otros;

    @FXML
    void AbrirMiembro(ActionEvent event) {
        try {
            app.MenuMiembro();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//


    @FXML
    void AbrirInformacionPartido(ActionEvent event) {
        try {
            app.MenuInformacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AbrirOtros(ActionEvent event) {
        try {
            app.MenuOtros();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarAplicacion(ActionEvent event) {
        Platform.exit();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        assert sideBar != null : "fx:id=\"sideBar\" was not injected: check your FXML file 'BienvenidoCompetencia.fxml'.";
        assert btt_InformacionPartido != null : "fx:id=\"btt_InformacionPartido\" was not injected: check your FXML file 'BienvenidoCompetencia.fxml'.";
        assert btt_Miembros != null : "fx:id=\"btt_Miembros\" was not injected: check your FXML file 'BienvenidoCompetencia.fxml'.";
        assert btt_Otros != null : "fx:id=\"btt_Otros\" was not injected: check your FXML file 'BienvenidoCompetencia.fxml'.";

    }
}