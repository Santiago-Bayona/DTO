package co.edu.uniquindio.poo.dto_record.ViewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Controller.MarcadorController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MenuInformacionVC implements Initializable {

        App app;
        private double x = 0,y = 0;



        private Stage stage;

        public void setStage(Stage stage) {
                this.stage = stage;
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                // Inicializar movimiento de la ventana si es necesario
                if (sideBar != null) {
                        sideBar.sceneProperty().addListener((obs, oldScene, newScene) -> {
                                if (newScene != null) {
                                        stage = (Stage) newScene.getWindow();
                                }
                        });

                        // Capturar la posición inicial al hacer clic
                        sideBar.setOnMousePressed(mouseEvent -> {
                                x = mouseEvent.getSceneX();
                                y = mouseEvent.getSceneY();
                        });

                        // Mover la ventana al arrastrar
                        sideBar.setOnMouseDragged(mouseEvent -> {
                                if (stage != null) {
                                        stage.setX(mouseEvent.getScreenX() - x);
                                        stage.setY(mouseEvent.getScreenY() - y);
                                }
                        });
                }
        }

        @FXML
        private ResourceBundle resources;

        @FXML
        private Pane sideBar;

        @FXML
        private URL location;

        @FXML
        private Button btt_Marcador;

        @FXML
        private Button btt_Equipo;

        @FXML
        private Button btt_Volver;

        @FXML
        private Button btt_Partido;




        @FXML
        void Volver(ActionEvent event) {
                try {
                        app.openViewPrincipal();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }




        @FXML
        void RegistrarEquipo(ActionEvent event) {
                try {
                        app.Equipo();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void RegistrarMarcador(ActionEvent event) {
                try {
                        app.Marcador();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void RegistrarPartido(ActionEvent event) {
                try {
                        app.Partido();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }


        public void setApp(App app) {
                this.app = app;
        }


        @FXML
        void initialize() {
                assert sideBar != null : "fx:id=\"sideBar\" was not injected: check your FXML file 'MenuInformacion.fxml'.";
            assert btt_Marcador != null : "fx:id=\"btt_Marcador\" was not injected: check your FXML file 'MenuInformacion.fxml'.";
            assert btt_Equipo != null : "fx:id=\"btt_Equipo\" was not injected: check your FXML file 'MenuInformacion.fxml'.";
            assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'MenuInformacion.fxml'.";
            assert btt_Partido != null : "fx:id=\"btt_Partido\" was not injected: check your FXML file 'MenuInformacion.fxml'.";

        }
    }

