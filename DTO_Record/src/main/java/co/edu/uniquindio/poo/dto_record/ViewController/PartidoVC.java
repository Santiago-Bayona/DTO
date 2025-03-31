package co.edu.uniquindio.poo.dto_record.ViewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Controller.ExamenController;
import co.edu.uniquindio.poo.dto_record.Controller.PartidoController;
import co.edu.uniquindio.poo.dto_record.Modelo.*;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class PartidoVC {

    private App app;
    private ObservableList<PartidoDTO> listaPartido = FXCollections.observableArrayList();
    private ObservableList<Arbitro> listaArbitro = FXCollections.observableArrayList();
    private ObservableList<Marcador> listaMarcador = FXCollections.observableArrayList();
    private PartidoDTO selectedPartido;
    private Arbitro selectedArbitro;
    private Marcador selectedMarcador;
    PartidoController partidoController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Arbitro, String> tbc_CategoriaArbitro;

    @FXML
    private TableColumn<PartidoDTO, String> tbc_Marcador;

    @FXML
    private Button btn_Eliminar;

    @FXML
    private TableColumn<Marcador, String> tbc_Puntaje;

    @FXML
    private TableColumn<PartidoDTO, String> tbc_NombreArbitro2;

    @FXML
    private Button btn_Agregar;

    @FXML
    private TableColumn<PartidoDTO, String> tbc_Visitante;

    @FXML
    private TableColumn<Arbitro, String> tbc_NombreArbitro;

    @FXML
    private TableView<PartidoDTO> tb_Partido;

    @FXML
    private Button btn_Actualizar;

    @FXML
    private Button btn_Limpiar;

    @FXML
    private Button btn_Volver;

    @FXML
    private TableView<Arbitro> tb_Arbitro;

    @FXML
    private TextField txt_Codigo;

    @FXML
    private TableColumn<PartidoDTO, String> tbc_Local;

    @FXML
    private TableColumn<PartidoDTO, String> tbc_Codigo;

    @FXML
    private TableView<Marcador> tb_Marcador;

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
        try{
            app.MenuInformacion();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void AgregarPartido(ActionEvent event) {
        agregarPartido();
    }

    @FXML
    void EliminarArbitro(ActionEvent event) {
        eliminarPartido();
    }

    @FXML
    void ActualizarArbitro(ActionEvent event) {
        actualizarPartido();
    }

    @FXML
    void LimpiarArbitro(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void initialize() {
        assert tbc_CategoriaArbitro != null : "fx:id=\"tbc_CategoriaArbitro\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tbc_Marcador != null : "fx:id=\"tbc_Marcador\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert btn_Eliminar != null : "fx:id=\"btn_Eliminar\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tbc_Puntaje != null : "fx:id=\"tbc_Puntaje\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tbc_NombreArbitro2 != null : "fx:id=\"tbc_NombreArbitro2\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert btn_Agregar != null : "fx:id=\"btn_Agregar\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tbc_Visitante != null : "fx:id=\"tbc_Visitante\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tbc_NombreArbitro != null : "fx:id=\"tbc_NombreArbitro\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tb_Partido != null : "fx:id=\"tb_Partido\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert btn_Actualizar != null : "fx:id=\"btn_Actualizar\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert btn_Limpiar != null : "fx:id=\"btn_Limpiar\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert btn_Volver != null : "fx:id=\"btn_Volver\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tb_Arbitro != null : "fx:id=\"tb_Arbitro\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert txt_Codigo != null : "fx:id=\"txt_Codigo\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tbc_Local != null : "fx:id=\"tbc_Local\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tbc_Codigo != null : "fx:id=\"tbc_Codigo\" was not injected: check your FXML file 'PartidoDTO.fxml'.";
        assert tb_Marcador != null : "fx:id=\"tb_Marcador\" was not injected: check your FXML file 'PartidoDTO.fxml'.";

        animarTextField(txt_Codigo);

        partidoController =new PartidoController(App.competencia);
        obtenerPartido();
        obtenerArbitro();
        obtenerMarcador();
        initView();

    }

    private void obtenerArbitro() {
        if (listaArbitro == null) {
            listaArbitro = FXCollections.observableArrayList();
        }

        Collection<Arbitro> arbitros = partidoController.obtenerListaArbitros();
        if (arbitros != null) {
            listaArbitro.setAll(arbitros);
        } else {
            System.out.println("No se encontraron arbitros.");
        }
    }

    private void obtenerMarcador() {
        if (listaMarcador == null) {
            listaMarcador= FXCollections.observableArrayList();
        }

        Collection<Marcador> marcadores = partidoController.obtenerListaMarcador();
        if (marcadores != null) {
            listaMarcador.setAll(marcadores);
        } else {
            System.out.println("No se encontraron marcadores.");
        }
    }


    /**
     *Metodo que permite obtener los datos de paciente
     */
    private void obtenerPartido() {
        if (partidoController != null) {
            listaPartido.addAll(partidoController.obtenerListaPartidos());
        } else {
            System.err.println("PartidoController no está inicializado.");
        }
    }


    /**
     *Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        //obtenerPartido();
        tb_Partido.getItems().clear();
        tb_Partido.setItems(listaPartido);
        tb_Marcador.setItems(listaMarcador);
        tb_Arbitro.setItems(listaArbitro);
        listenerSelectionPartido();
        listenerSelectionArbitro();
        listenerSelectionMarcador();
    }

    /**
     *Metodo que configura la vinculacion de datos en las tablas
     */
    private void initDataBinding() {
        tbc_Codigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoPartido()));
        tbc_Local.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcador1().equipo().getNombreEquipo()));
        tbc_Marcador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcador()));
        tbc_Puntaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().Marcador()));
        tbc_Visitante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcador1().equipo2().getNombreEquipo()));
        tbc_CategoriaArbitro.setCellValueFactory(celldata -> {
            Arbitro.Categoria categoria = celldata.getValue().getCategoria();
            String categoriaString = (categoria != null) ? categoria.toString() : "Sin Tipo";
            return new SimpleStringProperty(categoriaString);
        });
        tbc_NombreArbitro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_NombreArbitro2.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getNombreArbitro()));
    }

    /**
     *Metodo que escucha los cambios en la selecion de paciente y actualiza la variable selectedPaciente
     */
    private void listenerSelectionPartido() {
        tb_Partido.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPartido = newSelection;
            mostrarInformacionPartido(selectedPartido);
        });
    }

    /**
     *Metodo que detecta cuando el usuario selecciona un historial medico en la tabla
     */
    private void listenerSelectionArbitro() {
        tb_Arbitro.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedArbitro = newSelection;
        });
    }

    private void listenerSelectionMarcador() {
        tb_Marcador.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMarcador = newSelection;
        });
    }


    /**
     *Metodo que muestra la información del paciente sleccionado en los campos de la interfaz
     * @param partidoDTO
     */
    private void mostrarInformacionPartido(PartidoDTO partidoDTO) {
        if (partidoDTO != null) {
            txt_Codigo.setText(partidoDTO.getCodigoPartido());

        }
    }

    /**
     *Metodo que agrega un paciente
     */
    private void agregarPartido() {
        PartidoDTO partidoDTO = buildPartido();
        if(partidoController.crearPartido(partidoDTO)){
            listaPartido.add(partidoDTO);
            limpiarCampos();
        }
    }

    /**
     *Metodo que crea una instancia de Paciente con los datos ingresados en la interfaz
     * @return
     */
    private PartidoDTO buildPartido() {
        PartidoDTO partidoDTO = new PartidoDTO(
                txt_Codigo.getText(),
                selectedArbitro,
                selectedMarcador

        );
        return partidoDTO;

    }


    private void eliminarPartido() {
        if (partidoController.eliminarPartido(txt_Codigo.getText())) {
            listaPartido.remove(selectedPartido);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    /**
     * Metodo que actualiza la información del doctor seleccionado.
     * Si el Doctor se encuentra en la lista y la actualización es exitosa,
     * se reemplaza por el nuevo objeto actualizado y se refresca la tabla.
     */

    private void actualizarPartido() {

        if (selectedPartido != null &&
                partidoController.actualizarPartido(selectedPartido.getCodigoPartido(), buildPartido())) {

            int index = listaPartido.indexOf(selectedPartido);
            if (index >= 0) {
                listaPartido.set(index, buildPartido());
            }

            tb_Partido.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    /**
     * Metodo que limpia la seleccion de la tabla
     */
    private void limpiarSeleccion() {
        tb_Partido.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    /**
     *Metodo qi¿ue limpia los acmpos del paciente seleccionado
     */
    private void limpiarCampos() {
        txt_Codigo.clear();
        tb_Marcador.getSelectionModel().clearSelection();
        tb_Arbitro.getSelectionModel().clearSelection();
    }

    /**
     *metodo que seta APP
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }
}

