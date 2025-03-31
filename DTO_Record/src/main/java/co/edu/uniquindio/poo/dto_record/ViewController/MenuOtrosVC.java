package co.edu.uniquindio.poo.dto_record.ViewController;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.dto_record.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MenuOtrosVC implements Initializable {

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
        private Button btt_Volver;

        @FXML
        private Button btt_ExamenMedico;


        @FXML
        void Volver(ActionEvent event) {
            try {
                app.openViewPrincipal();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        @FXML
        void RegistrarExamenMedico(ActionEvent event) {
            try {
                app.Examen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
        void initialize() {
            assert sideBar != null : "fx:id=\"sideBar\" was not injected: check your FXML file 'MenuOtros.fxml'.";
            assert btt_Volver != null : "fx:id=\"btt_Volver\" was not injected: check your FXML file 'MenuOtros.fxml'.";
            assert btt_ExamenMedico != null : "fx:id=\"btt_ExamenMedico\" was not injected: check your FXML file 'MenuOtros.fxml'.";

        }
    }

