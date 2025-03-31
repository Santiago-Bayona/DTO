package co.edu.uniquindio.poo.dto_record.ViewController;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Controller.MarcadorController;
import co.edu.uniquindio.poo.dto_record.Modelo.Equipo;
import co.edu.uniquindio.poo.dto_record.Modelo.ExamenMedico;
import co.edu.uniquindio.poo.dto_record.Modelo.Marcador;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MarcadorVC  {

    private App app;
    MarcadorController marcadorController;
    private ObservableList<Marcador> listaMarcador = FXCollections.observableArrayList();
    private ObservableList<Equipo> listaEquipo = FXCollections.observableArrayList();
    private Marcador selectedMarcador;
    private Equipo selectedEquipo1;
    private Equipo selectedEquipo2;
    private double x = 0,y = 0;



    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }




    @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private AnchorPane sideBar;

        @FXML
        private TableColumn<Marcador, String> tbc_NombreEquipo01;

        @FXML
        private Button btt_Eliminar;

        @FXML
        private TableColumn<Equipo, Integer> tbc_IdEquipo2;

        @FXML
        private TableColumn<Marcador, String> tbc_Marcador;

        @FXML
        private TableColumn<Equipo, Integer> tbc_IdEquipo1;

        @FXML
        private TableColumn<Equipo, String> tbc_NombreEquipo1;

        @FXML
        private TextField txt_Marcador;

        @FXML
        private TableColumn<Marcador, String> tbc_NombreEquipo02;

        @FXML
        private TableView<Equipo> tb_Equipo1;

        @FXML
        private TableView<Equipo> tb_Equipo2;

        @FXML
        private Button btt_Agregar;

        @FXML
        private TableColumn<Marcador, String> tbc_CodigoMarcador;

        @FXML
        private TextField txt_CodigoMarcador;

        @FXML
        private TableColumn<Equipo, String> tbc_NombreEquipo2;

        @FXML
        private TableColumn<Marcador, Integer> tbc_IdEquipo02;

        @FXML
        private Button btt_Limpiar;

        @FXML
        private Button Volver;

        @FXML
        private TableView<Marcador> tb_Marcador;

        @FXML
        private TableColumn<Marcador, Integer> tbc_IdEquipo01;

    public void animarTextField(TextField textField) {
        textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                // Si el TextField gana el foco, se expande
                Timeline expandir = new Timeline(
                        new KeyFrame(Duration.millis(400),
                                new KeyValue(textField.prefWidthProperty(), 200)) // Expande hasta 250px
                );
                expandir.play();
            } else {
                // Si el TextField pierde el foco, vuelve a su tamaño normal
                Timeline reducir = new Timeline(
                        new KeyFrame(Duration.millis(400),
                                new KeyValue(textField.prefWidthProperty(), 150)) // Reduce a 150px
                );
                reducir.play();
            }
        });
    }

    /**
     * metodo que regresa al menu de informacion partido
     * @param event
     */
        @FXML
        void Volver(ActionEvent event) {
            try {
                app.MenuInformacion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    /**
     *metodo que acciona el boton de agregar
     * @param event
     */

        @FXML
        void AgregarMarcador(ActionEvent event) {
            agregarMarcador();
        }

    /**
     *Metodo que acciona el boton de eliminar
     * @param event
     */

        @FXML
        void EliminarMarcador(ActionEvent event) {
            eliminarMarcador();
        }

    /**
     *Metodo que acciona el metodo de limpiar
     * @param event
     */
        @FXML
        void LimpiarMarcador(ActionEvent event) {
            limpiarCamposMarcador();
        }



        @FXML
        void initialize() {
            assert tbc_NombreEquipo01 != null : "fx:id=\"tbc_NombreEquipo01\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_IdEquipo2 != null : "fx:id=\"tbc_IdEquipo2\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_Marcador != null : "fx:id=\"tbc_Marcador\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_IdEquipo1 != null : "fx:id=\"tbc_IdEquipo1\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_NombreEquipo1 != null : "fx:id=\"tbc_NombreEquipo1\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert txt_Marcador != null : "fx:id=\"txt_Marcador\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_NombreEquipo02 != null : "fx:id=\"tbc_NombreEquipo02\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tb_Equipo1 != null : "fx:id=\"tb_Equipo1\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tb_Equipo2 != null : "fx:id=\"tb_Equipo2\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_CodigoMarcador != null : "fx:id=\"tbc_CodigoMarcador\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert sideBar != null : "fx:id=\"sideBar\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert txt_CodigoMarcador != null : "fx:id=\"txt_CodigoMarcador\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_NombreEquipo2 != null : "fx:id=\"tbc_NombreEquipo2\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_IdEquipo02 != null : "fx:id=\"tbc_IdEquipo02\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert Volver != null : "fx:id=\"Volver\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tb_Marcador != null : "fx:id=\"tb_Marcador\" was not injected: check your FXML file 'Marcador.fxml'.";
            assert tbc_IdEquipo01 != null : "fx:id=\"tbc_IdEquipo01\" was not injected: check your FXML file 'Marcador.fxml'.";

            animarTextField(txt_CodigoMarcador);
            animarTextField(txt_Marcador);
            marcadorController=new MarcadorController(App.competencia);
            obtenerMarcador();
            ObtenerEquipo();
            initView();
        }

    /**
     *Metodo que permite obtener los datos del equipo
     */

    private void ObtenerEquipo() {
        if (listaEquipo == null) {
            listaEquipo = FXCollections.observableArrayList();
        }

        Collection<Equipo> equipos = marcadorController.obtenerListaEquipo();
        if (equipos != null) {
            listaEquipo.setAll(equipos);
        } else {
            System.out.println("No se encontraron equipos.");
        }
    }

    /**
     *Metodo que permite obtener los datos del marcador
     */
    private void obtenerMarcador() {
        if (marcadorController != null) {
            listaMarcador.addAll(marcadorController.ObtenerListaMarcador());
        } else {
            System.err.println("marcadorController no está inicializado.");
        }
    }

    /**
     *Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        //obtenerMarcador();
        tb_Marcador.getItems().clear();
        tb_Marcador.setItems(listaMarcador);
        tb_Equipo1.setItems(listaEquipo);
        tb_Equipo2.setItems(listaEquipo);
        listenerSelectionMarcador();
        listenerSelectionEquipo1();
        listenerSelectionEquipo2();
    }

    /**
     *Metodo que configura la vinculacion de datos en las tablas
     */

    private void initDataBinding() {
        tbc_CodigoMarcador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().Codigo()));
        tbc_Marcador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().Marcador()));
        tbc_IdEquipo01.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().equipo().getIdEquipo()));
        tbc_NombreEquipo1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreEquipo()));
        tbc_IdEquipo02.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().equipo2().getIdEquipo()));
        tbc_NombreEquipo02.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().equipo2().getNombreEquipo()));
        tbc_IdEquipo1.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdEquipo()));
        tbc_NombreEquipo01.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().equipo().getNombreEquipo()));
        tbc_IdEquipo2.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdEquipo()));
        tbc_NombreEquipo2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreEquipo()));

    }

    /**
     *Metodo que escucha los cambios en la selecion de Marcador y actualiza la variable selectedMarcador
     */

    private void listenerSelectionMarcador() {
        tb_Marcador.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMarcador = newSelection;
            mostarInformacionMarcador(selectedMarcador);
        });
    }

    /**
     *Metodo que detecta cuando el usuario selecciona un equipo en la tabla
     */
    private void listenerSelectionEquipo1() {
        tb_Equipo1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEquipo1 = newSelection;
        });
    }

    /**
     *Metodo que detecta cuando el usuario selecciona un equipo en la tabla
     */
    private void listenerSelectionEquipo2() {
        tb_Equipo2.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEquipo2 = newSelection;
        });
    }

    /**
     *Metodo que muestra la informacion del marcador sleccionado en los campos de la interfaz
     * @param marcador
     */
    private void mostarInformacionMarcador(Marcador marcador) {
        if (marcador != null) {
            txt_CodigoMarcador.setText(marcador.Codigo());
            txt_Marcador.setText(marcador.Marcador());
        }
    }

    /**
     *Metodo que agrega un marcador
     */
    private void agregarMarcador() {
        Marcador marcador = buildMarcador();
        if (marcadorController.crearMarcador(marcador)) {
            listaMarcador.add(marcador);
            limpiarCamposMarcador();
        }
    }


    /**
     *Metodo que crea una instancia de marcador con los datos ingresados en la interfaz
     * @return marcador
     */
    private Marcador buildMarcador() {
        Marcador marcador = new Marcador(
                selectedEquipo1,
                txt_Marcador.getText()
                ,selectedEquipo2
                ,txt_CodigoMarcador.getText()

                );
        return marcador;

    }

    /**
     *Metodo que elimina un marcador
     */
    private void eliminarMarcador() {
        Marcador marcador = buildMarcador();
        if (marcadorController.eliminarMarcador(marcador)){
            listaMarcador.remove(selectedMarcador);
            limpiarCamposMarcador();
            limpiarSeleccion();
        }
    }

    /**
     *Metodo que limpia la seleccion de la tabla
     */
    private void limpiarSeleccion() {
        tb_Marcador.getSelectionModel().clearSelection();
        limpiarCamposMarcador();
    }

    /**
     *Metodo que limpia los campos del Marcador seleccionado
     */
    private void limpiarCamposMarcador() {
        txt_CodigoMarcador.clear();
        txt_Marcador.clear();
        tb_Equipo1.getSelectionModel().clearSelection();
        tb_Equipo2.getSelectionModel().clearSelection();
    }

    /**
     *Metodo que seta la App
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }


}
