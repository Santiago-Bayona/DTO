package co.edu.uniquindio.poo.dto_record.ViewController;

import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.dto_record.App;

import co.edu.uniquindio.poo.dto_record.Controller.EquipoController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import co.edu.uniquindio.poo.dto_record.Modelo.Equipo;
import javafx.beans.property.SimpleObjectProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EquipoVC  {


    private App app;
    EquipoController equipoController;
    private ObservableList<Equipo> listaEquipo = FXCollections.observableArrayList();
    private Equipo selectedEquipo;
    private double x = 0,y = 0;



    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }


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



    @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private AnchorPane sideBar;

        @FXML
        private Button btt_Agregar;

        @FXML
        private Button btt_Eliminar;

        @FXML
        private TableView<Equipo> tb_Equipo;

        @FXML
        private TableColumn<Equipo, String> tbc_NombreEquipo;

        @FXML
        private Button btt_Actualizar;

        @FXML
        private TextField txt_IdEquipo;

        @FXML
        private TextField txt_NombreEquipo;

        @FXML
        private TableColumn<Equipo, Integer> tbc_IdEquipo;

        @FXML
        private Button btt_Limpiar;

        @FXML
        private Button Volver;


        @FXML
        void Volver(ActionEvent event) {
            try {
               app.MenuInformacion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @FXML
        void AgregarEquipo(ActionEvent event) {
            agregarEquipo();
        }

        @FXML
        void ActualizarEquipo(ActionEvent event) {
            actualizarEquipo();
        }

        @FXML
        void EliminarEquipo(ActionEvent event) {
            eliminarEquipo();
        }

        @FXML
        void LimpiarEquipo(ActionEvent event) {
            limpiarCamposEquipo();
        }

        @FXML
        void initialize() {
            assert btt_Agregar != null : "fx:id=\"btt_Agregar\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert btt_Eliminar != null : "fx:id=\"btt_Eliminar\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert tb_Equipo != null : "fx:id=\"tb_Equipo\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert tbc_NombreEquipo != null : "fx:id=\"tbc_NombreEquipo\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert btt_Actualizar != null : "fx:id=\"btt_Actualizar\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert txt_IdEquipo != null : "fx:id=\"txt_IdEquipo\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert txt_NombreEquipo != null : "fx:id=\"txt_NombreEquipo\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert sideBar != null : "fx:id=\"siderBar\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert tbc_IdEquipo != null : "fx:id=\"tbc_IdEquipo\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert btt_Limpiar != null : "fx:id=\"btt_Limpiar\" was not injected: check your FXML file 'Equipo.fxml'.";
            assert Volver != null : "fx:id=\"Volver\" was not injected: check your FXML file 'Equipo.fxml'.";

            animarTextField(txt_IdEquipo);
            animarTextField(txt_NombreEquipo);
            equipoController=new EquipoController(App.competencia);
            obtenerEquipo();
            initView();
        }


    /**
     *Metodo que permite obtener los datos del equipo
     */
    private void obtenerEquipo() {
        if (equipoController != null) {
            listaEquipo.addAll(equipoController.ObtenerListaEquipo());
        } else {
            System.err.println("equipoController no está inicializado.");
        }
    }

    /**
     *Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        //obtenerEquipo();
        tb_Equipo.getItems().clear();
        tb_Equipo.setItems(listaEquipo);
        listenerSelectionEquipo();
    }

    /**
     *Metodo que configura la vinculacion de datos en las tablas
     */
    private void initDataBinding() {
        tbc_IdEquipo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdEquipo()));
        tbc_NombreEquipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreEquipo()));

    }

    /**
     *Metodo que escucha los cambios en la seleccion de Equipo y actualiza la variable selectedEquipo
     */
    private void listenerSelectionEquipo() {
        tb_Equipo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEquipo = newSelection;
            mostarInformacionEquipo(selectedEquipo);
        });
    }



    /**
     *Metodo que muestra la informacion del equipo sleccionada en los campos de la interfaz
     * @param equipo
     */
    private void mostarInformacionEquipo(Equipo equipo) {
        if (equipo!= null) {
            txt_IdEquipo.setText(String.valueOf(equipo.getIdEquipo()));
            txt_NombreEquipo.setText(equipo.getNombreEquipo());
        }
    }

    /**
     *Metodo que agrega un equipo
     */
    private void agregarEquipo() {
        Equipo equipo = buildEquipo();
        if (equipoController.crearEquipo(equipo)) {
            listaEquipo.add(equipo);
            limpiarCamposEquipo();
        }
    }

    /**
     *Metodo que crea una instancia de Equipo con los datos ingresados en la interfaz
     * @return
     */
    private Equipo buildEquipo() {
        int idEquipo = Integer.parseInt(txt_IdEquipo.getText());
        Equipo equipo = new Equipo(
                idEquipo,
                txt_NombreEquipo.getText()
        );
        return equipo;

    }

    /**
     *Metodo que elimina un equipo
     */
    private void eliminarEquipo() {
        if (equipoController.eliminarEquipo(txt_IdEquipo.getText())) {
            listaEquipo.remove(selectedEquipo);
            limpiarCamposEquipo();
            limpiarSeleccion();
        }
    }

    /**
     *Metodo que actualiza un equipo
     */
    private void actualizarEquipo() {

        if (selectedEquipo != null &&
                equipoController.actualizarEquipo(String.valueOf(selectedEquipo.getIdEquipo()), buildEquipo())) {

            int index = listaEquipo.indexOf(selectedEquipo);
            if (index >= 0) {
                listaEquipo.set(index, buildEquipo());
            }

            tb_Equipo.refresh();
            limpiarSeleccion();
            limpiarCamposEquipo();
        }
    }

    /**
     *Metodo que limpia la seleccion de la tabla
     */
    private void limpiarSeleccion() {
        tb_Equipo.getSelectionModel().clearSelection();
        limpiarCamposEquipo();
    }

    /**
     *Metodo que limpia los campos del equipo seleccionado
     */
    private void limpiarCamposEquipo() {
        txt_IdEquipo.clear();
        txt_NombreEquipo.clear();
    }

    /**
     *Metodo que seta la App
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }

}




