package co.edu.uniquindio.poo.dto_record.ViewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Controller.ExamenController;
import co.edu.uniquindio.poo.dto_record.Modelo.ExamenMedico;
import co.edu.uniquindio.poo.dto_record.Modelo.JugadorDTO;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class ExamenMedicoVC {

    private App app;
    private ObservableList<ExamenMedico> listaExamen = FXCollections.observableArrayList();
    private ObservableList<JugadorDTO> listaJugadorDTO = FXCollections.observableArrayList();
    private ExamenMedico selectedExamenMedico;
    private JugadorDTO selectedJugadorDTO;
    ExamenController examenController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<JugadorDTO, String> tbc_equipoJugador;

    @FXML
    private TableColumn<JugadorDTO, String> tbc_nombrejugador;

    @FXML
    private TableView<JugadorDTO> tb_JugadorDTO;

    @FXML
    private TextField txt_Peso;

    @FXML
    private CheckBox ckbx_Diabetes;

    @FXML
    private Button btn_AgregarExamen;

    @FXML
    private TableColumn<ExamenMedico, String> tbc_NombreJUgador2;

    @FXML
    private TextField txt_Altura;

    @FXML
    private Button btn_EliminarExamen;

    @FXML
    private TableColumn<ExamenMedico, Double> tbc_peso;

    @FXML
    private Button btn_Limpiar;

    @FXML
    private Button btn_Volver;

    @FXML
    private TableColumn<ExamenMedico, Double> tbc_Altura;

    @FXML
    private TableView<ExamenMedico> tb_Examen;

    @FXML
    private TableColumn<ExamenMedico, String> tbc_IMC;

    @FXML
    private TextField txt_Codigo;

    @FXML
    private TableColumn<ExamenMedico, Boolean> tbc_Diabetes;

    @FXML
    private TableColumn<ExamenMedico, String> tbc_Codigo;

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
    void Volver(ActionEvent event) {
        try {
            app.MenuOtros();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void AgregarExamen(ActionEvent event) {
        agregarExamen();

    }

    @FXML
    void EliminarExamen(ActionEvent event) {
        eliminarExamen();

    }

    @FXML
    void LimpiarExamen(ActionEvent event) {
        limpiarCampos();

    }

    @FXML
    void initialize() {
        assert tbc_equipoJugador != null : "fx:id=\"tbc_equipoJugador\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tbc_nombrejugador != null : "fx:id=\"tbc_nombrejugador\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tb_JugadorDTO != null : "fx:id=\"tb_JugadorDTO\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert txt_Peso != null : "fx:id=\"txt_Peso\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert ckbx_Diabetes != null : "fx:id=\"ckbx_Diabetes\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert btn_AgregarExamen != null : "fx:id=\"btn_AgregarExamen\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tbc_NombreJUgador2 != null : "fx:id=\"tbc_NombreJUgador2\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert txt_Altura != null : "fx:id=\"txt_Altura\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert btn_EliminarExamen != null : "fx:id=\"btn_EliminarExamen\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tbc_peso != null : "fx:id=\"tbc_peso\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert btn_Limpiar != null : "fx:id=\"btn_Limpiar\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert btn_Volver != null : "fx:id=\"btn_Volver\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tbc_Altura != null : "fx:id=\"tbc_Altura\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tb_Examen != null : "fx:id=\"tb_Examen\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tbc_IMC != null : "fx:id=\"tbc_IMC\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert txt_Codigo != null : "fx:id=\"txt_Codigo\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tbc_Diabetes != null : "fx:id=\"tbc_Diabetes\" was not injected: check your FXML file 'ExamenMedico.fxml'.";
        assert tbc_Codigo != null : "fx:id=\"tbc_Codigo\" was not injected: check your FXML file 'ExamenMedico.fxml'.";

        animarTextField(txt_Altura);
        animarTextField(txt_Peso);
        animarTextField(txt_Codigo);

        examenController =new ExamenController(App.competencia);
        obtenerExamen();
        obtenerJugadorDTO();
        initView();
    }


    private void obtenerJugadorDTO() {
        if (listaJugadorDTO == null) {
            listaJugadorDTO = FXCollections.observableArrayList();
        }

        Collection<JugadorDTO> jugadoresDTO = examenController.obtenerListaJugadorDTO();
        if (jugadoresDTO != null) {
            listaJugadorDTO.setAll(jugadoresDTO);
        } else {
            System.out.println("No se encontraron jugadpres.");
        }
    }


    /**
     *Metodo que permite obtener los datos de paciente
     */
    private void obtenerExamen() {
        if (examenController != null) {
            listaExamen.addAll(examenController.obtenerListaExamen());
        } else {
            System.err.println("PacienteController no está inicializado.");
        }
    }


    /**
     *Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        //obtenerExamen();
        tb_Examen.getItems().clear();
        tb_Examen.setItems(listaExamen);
        tb_JugadorDTO.setItems(listaJugadorDTO);
        listenerSelectionExamen();
        listenerSelectionJugadorDTO();
    }

    /**
     *Metodo que configura la vinculacion de datos en las tablas
     */
    private void initDataBinding() {
        tbc_peso.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().peso()));
        tbc_Altura.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().altura()));
        tbc_Codigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().CodigoExamen()));
        tbc_NombreJUgador2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().persona().getNombre()));
        tbc_Diabetes.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().diabetes()));
        tbc_nombrejugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_equipoJugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreEquipo()));
        tbc_IMC.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().calcularIMC()));
    }

    /**
     *Metodo que escucha los cambios en la selecion de paciente y actualiza la variable selectedPaciente
     */
    private void listenerSelectionExamen() {
        tb_Examen.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedExamenMedico = newSelection;
            mostarInformacionExamen(selectedExamenMedico);
        });
    }

    /**
     *Metodo que detecta cuando el usuario selecciona un historial medico en la tabla
     */
    private void listenerSelectionJugadorDTO() {
        tb_JugadorDTO.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedJugadorDTO = newSelection;
        });
    }


    /**
     *Metodo que muestra la información del paciente sleccionado en los campos de la interfaz
     * @param examenMedico
     */
    private void mostarInformacionExamen(ExamenMedico examenMedico) {
        if (examenMedico != null) {
            txt_Codigo.setText(examenMedico.CodigoExamen());
            txt_Altura.setText(String.valueOf(examenMedico.altura()));
            txt_Peso.setText(String.valueOf(examenMedico.peso()));
            ckbx_Diabetes.setSelected(examenMedico.diabetes());
        }
    }

    /**
     *Metodo que agrega un paciente
     */
    private void agregarExamen() {
        ExamenMedico examenMedico = buildExamen();
        if(examenController.crearExamen(examenMedico)){
            listaExamen.add(examenMedico);
            limpiarCampos();
        }
    }

    /**
     *Metodo que crea una instancia de Paciente con los datos ingresados en la interfaz
     * @return
     */
    private ExamenMedico buildExamen() {
        double altura = Double.parseDouble(txt_Altura.getText());
        double peso= Double.parseDouble(txt_Peso.getText());
        ExamenMedico examenMedico = new ExamenMedico(
                selectedJugadorDTO,
                peso,
                altura,
                ckbx_Diabetes.isSelected(),
                txt_Codigo.getText()

        );
        return examenMedico;

    }


    /**
     *Metodo que elimina un paciente
     */
    private void eliminarExamen() {
        ExamenMedico examenMedico = buildExamen();
        if (examenController.eliminarExamenes(examenMedico)){
            listaExamen.remove(selectedExamenMedico);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    /**
     * Metodo que limpia la seleccion de la tabla
     */
    private void limpiarSeleccion() {
        tb_Examen.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    /**
     *Metodo qi¿ue limpia los acmpos del paciente seleccionado
     */
    private void limpiarCampos() {
        txt_Peso.clear();
        txt_Altura.clear();
        txt_Codigo.clear();
        ckbx_Diabetes.setSelected(false);
        tb_JugadorDTO.getSelectionModel().clearSelection();
    }

    /**
     *metodo que seta APP
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }
}

