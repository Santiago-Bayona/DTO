package co.edu.uniquindio.poo.dto_record;

import co.edu.uniquindio.poo.dto_record.Modelo.*;
import co.edu.uniquindio.poo.dto_record.ViewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    public static Competencia competencia = new Competencia("San Juan de Dios");
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.initStyle(StageStyle.TRANSPARENT); // Hacer la ventana transparente
        this.primaryStage.setTitle("Bienvenido");
        openViewPrincipal();
    }

    private boolean datosInicializados = false;
    private double xOffset = 0;
    private double yOffset = 0;


    public void openViewPrincipal() {
        if (!datosInicializados) {
            inicializarData();
            datosInicializados = true;
        }
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("BienvenidoCompetencia.fxml"));
            Pane rootLayout = (Pane) loader.load();
            rootLayout.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
            BienvenidoVC primaryController = loader.getController();
            primaryController.setApp(this);

            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void Arbitro() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Arbitro.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ArbitroVC arbitroVC = loader.getController();
            arbitroVC.setApp(this);

            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Examen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("ExamenMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ExamenMedicoVC examenMedicoVC = loader.getController();
            examenMedicoVC.setApp(this);

            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Partido() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("PartidoDTO.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PartidoVC partidoDTO = loader.getController();
            partidoDTO.setApp(this);

            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void MenuOtros() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuOtros.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuOtrosVC menuOtrosVC = loader.getController();
            menuOtrosVC.setApp(this);
            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Marcador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Marcador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MarcadorVC marcadorVC = loader.getController();
            marcadorVC.setApp(this);
            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Equipo() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Equipo.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            EquipoVC equipoVC = loader.getController();
            equipoVC.setApp(this);
            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void MenuInformacion() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuInformacion.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuInformacionVC menuInformacionVC = loader.getController();
            menuInformacionVC.setApp(this);
            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void MenuMiembro() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("MenuMiembros.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuMiembroVC menuMiembroVC = loader.getController();
            menuMiembroVC.setApp(this);
            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void JugadorDTO() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("JugadorDTOview.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            JugadorDTOVC jugadorDTOVC = loader.getController();
            jugadorDTOVC.setApp(this);
            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Jugador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("JugadorView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            JugadorVC jugadorVC = loader.getController();
            jugadorVC.setApp(this);

            rootLayout.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            rootLayout.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public void inicializarData() {

        Jugador jugadorn1= new Jugador("jose","martinez","ssh", Jugador.Posicion.Mediocampista);
        competencia.agregarJugador(jugadorn1);
        Equipo equipo = new Equipo(1645,"ruleta gang");
        Equipo equipo2 = new Equipo(1745,"Lucas gang");
        competencia.agregarEquipo(equipo);
        competencia.agregarEquipo(equipo2);

        JugadorDTO jugadorDTO= new JugadorDTO(jugadorn1,equipo);
        competencia.agregarJugadorDTO(jugadorDTO);

        ExamenMedico examenMedico= new ExamenMedico(jugadorDTO,66.2,1.78,false,"EM1");
        competencia.agregarExamen(examenMedico);


        Arbitro arbitro = new Arbitro("Jose","Sepulveda","102457",100, Arbitro.Categoria.NACIONAL);
        competencia.agregarArbitro(arbitro);

        Marcador marcador = new Marcador(equipo,"2:0",equipo2,"184");
        competencia.agregarMarcdaor(marcador);

        PartidoDTO partidoDTO = new PartidoDTO("P1",arbitro,marcador);
        competencia.agregarPartido(partidoDTO);

    }
}