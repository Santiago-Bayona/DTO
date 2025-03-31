package co.edu.uniquindio.poo.dto_record.ViewController;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Controller.JugadorDTOController;
import co.edu.uniquindio.poo.dto_record.Modelo.Equipo;
import co.edu.uniquindio.poo.dto_record.Modelo.Jugador;
import co.edu.uniquindio.poo.dto_record.Modelo.JugadorDTO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;


public class JugadorDTOVC {

    private App app;
    private ObservableList<Jugador> listaJugadores = FXCollections.observableArrayList();
    private ObservableList<Equipo> listaEquipos = FXCollections.observableArrayList();
    private ObservableList<JugadorDTO> listaJugadoresDTO = FXCollections.observableArrayList();
    private JugadorDTO selectedJugadorDTO;
    private Jugador selectedJugador;
    private Equipo selectedEquipo;
    JugadorDTOController jugadorDTOController;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tbc_PosicionJugador"
    private TableColumn<Jugador, Jugador.Posicion> tbc_PosicionJugador; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_PosicionJugadorDTO"
    private TableColumn<JugadorDTO, Jugador.Posicion> tbc_PosicionJugadorDTO; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_NombreJugadorDTO"
    private TableColumn<JugadorDTO, String> tbc_NombreJugadorDTO; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_CedulaJugadorDTO"
    private TableColumn<JugadorDTO, String> tbc_CedulaJugadorDTO; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Agregar"
    private Button btn_Agregar; // Value injected by FXMLLoader

    @FXML // fx:id="tb_JugadorDTO"
    private TableView<JugadorDTO> tb_JugadorDTO; // Value injected by FXMLLoader

    @FXML // fx:id="tb_Jugador"
    private TableView<Jugador> tb_Jugador; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_NombreJugador"
    private TableColumn<Jugador, String> tbc_NombreJugador; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_CedulaJugador"
    private TableColumn<Jugador, String> tbc_CedulaJugador; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_IdEquipo"
    private TableColumn<Equipo, String> tbc_IdEquipo; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Elimnar"
    private Button btn_Elimnar; // Value injected by FXMLLoader

    @FXML // fx:id="tb_Equipos"
    private TableView<Equipo> tb_Equipos; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_EquipoJugadorDTO"
    private TableColumn<JugadorDTO, String> tbc_EquipoJugadorDTO; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Actualizar"
    private Button btn_Actualizar; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Limpiar"
    private Button btn_Limpiar; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Volver"
    private Button btn_Volver; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_NombreEquipo"
    private TableColumn<Equipo, String > tbc_NombreEquipo; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_ApellidoJugador"
    private TableColumn<Jugador, String> tbc_ApellidoJugador; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_ApellidoJugadorDTO"
    private TableColumn<JugadorDTO, String> tbc_ApellidoJugadorDTO; // Value injected by

    /**
     *Metodo para regresar a la ventana anterior
     */
    @FXML
    void Volver(ActionEvent event) {
        try {
            app.MenuMiembro();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AgregarJugadorDTO(ActionEvent event) {
        agregarJugadorDTO();
    }

    @FXML
    void EliminarJugadorDTO(ActionEvent event) {
        eliminarJugadorDTO();
    }

    @FXML
    void ActualizarJugadorDTO(ActionEvent event) {
        actualizarJugadorDTO();
    }

    @FXML
    void LimpiarJugadorDTO(ActionEvent event) {
        limpiarCampos();
    }



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tbc_PosicionJugador != null : "fx:id=\"tbc_PosicionJugador\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_PosicionJugadorDTO != null : "fx:id=\"tbc_PosicionJugador1\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_NombreJugadorDTO != null : "fx:id=\"tbc_NombreJugadorDTO\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_CedulaJugadorDTO != null : "fx:id=\"tbc_CedulaJugadorDTO\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert btn_Agregar != null : "fx:id=\"btn_Agregar\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tb_JugadorDTO != null : "fx:id=\"tb_JugadorDTO\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tb_Jugador != null : "fx:id=\"tb_Jugador\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_NombreJugador != null : "fx:id=\"tbc_NombreJugador\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_CedulaJugador != null : "fx:id=\"tbc_CedulaJugador\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_IdEquipo != null : "fx:id=\"tbc_IdEquipo\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert btn_Elimnar != null : "fx:id=\"btn_Elimnar\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tb_Equipos != null : "fx:id=\"tb_Equipos\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_EquipoJugadorDTO != null : "fx:id=\"tbc_EquipoJugadorDTO\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert btn_Actualizar != null : "fx:id=\"btn_Actualizar\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert btn_Limpiar != null : "fx:id=\"btn_Limpiar\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert btn_Volver != null : "fx:id=\"btn_Volver\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_NombreEquipo != null : "fx:id=\"tbc_NombreEquipo\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_PosicionJugadorDTO != null : "fx:id=\"tbc_PosicionJugadorDTO\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_ApellidoJugador != null : "fx:id=\"tbc_ApellidoJugador\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";
        assert tbc_ApellidoJugadorDTO != null : "fx:id=\"tbc_ApellidoJugadorDTO\" was not injected: check your FXML file 'JugadorDTOView.fxml'.";

        jugadorDTOController = new JugadorDTOController(App.competencia);
        obtenerJugador();
        obtenerEquipo();
        obtenerJugadorDTO();
        initView();
        listenerSelectionJugadorDTO();
    }


    private void listenerSelectionJugadorDTO() {
        tb_JugadorDTO.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedJugadorDTO = newSelection;
        });
    }

    /**
     * Metodo para obtener los jugadores de la lista de jugadores
     */
    private void obtenerJugador() {
        if (listaJugadores == null) {
            listaJugadores = FXCollections.observableArrayList();
        }

        Collection<Jugador> jugadores = jugadorDTOController.obtenerListaJugadores();
        if (jugadores != null) {
            listaJugadores.setAll(jugadores);
        } else {
            System.out.println("No se encontraron jugadores.");
        }
    }

    /**
     * Metodo para obtener los equipos de la lista de equipos
     */
    private void obtenerEquipo() {
        if (listaEquipos == null) {
            listaEquipos = FXCollections.observableArrayList();
        }

        Collection<Equipo> equipos = jugadorDTOController.obtenerListaEquipos();
        if (equipos != null) {
            listaEquipos.setAll(equipos);
        } else {
            System.out.println("No se encontraron equipos.");
        }
    }


    /**
     * Metodo que permite obtener los datos de JugadorDTO
     */
    private void obtenerJugadorDTO() {
        if (jugadorDTOController != null) {
            listaJugadoresDTO.addAll(jugadorDTOController.obtenerListaJugadoresDTO());
        } else {
            System.err.println("JugadorDTOController no está inicializado.");
        }
    }


    /**
     * Metodo que inicializa la vista en javaFX
     */
    private void initView() {
        initDataBinding();
        //obtenerPartido();
        tb_JugadorDTO.getItems().clear();
        tb_JugadorDTO.setItems(listaJugadoresDTO);
        tb_Equipos.setItems(listaEquipos);
        tb_Jugador.setItems(listaJugadores);
        listenerSelectionJugador();
        listenerSelectionEquipos();
    }

    private void initDataBinding() {
        tbc_NombreJugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_ApellidoJugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_CedulaJugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_PosicionJugador.setCellValueFactory(celldata -> {
            Jugador.Posicion posicion = celldata.getValue().getPosicion();
            String posicionString = (posicion != null) ? posicion.toString() : "Sin Tipo";
            return new SimpleObjectProperty(posicionString);
        });
        tbc_NombreJugadorDTO.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_ApellidoJugadorDTO.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_CedulaJugadorDTO.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_IdEquipo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdEquipo())));
        tbc_NombreEquipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreEquipo()));
        tbc_EquipoJugadorDTO.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreEquipo()));
        tbc_PosicionJugadorDTO.setCellValueFactory(celldata -> {
            Jugador.Posicion posicion = celldata.getValue().getPosicion();
            String posicionString = (posicion != null) ? posicion.toString() : "Sin Tipo";
            return new SimpleObjectProperty(posicionString);
        });

    }


    /**
     *Metodo que detecta cuando el usuario selecciona un jugador en la tabla
     */
    private void listenerSelectionJugador() {
        tb_Jugador.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedJugador = newSelection;
        });
    }

    /**
     *Metodo que detecta cuando el usuario selecciona un equipo en la tabla
     */
    private void listenerSelectionEquipos() {
        tb_Equipos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEquipo = newSelection;
        });
    }



    /**
     * Metodo que agrega un jugadorDTO
     */
    private void agregarJugadorDTO() {
        if (selectedJugador == null) {
            mostrarAlerta("Error", "Debe seleccionar un jugador antes de agregar.");
            return;
        }

        if (selectedEquipo == null) {
            mostrarAlerta("Error", "Debe seleccionar un equipo antes de agregar.");
            return;
        }

        JugadorDTO jugadorDTO = buildJugadorDTO();
        if (jugadorDTOController.crearJugadorDTO(jugadorDTO)) {
            listaJugadoresDTO.add(jugadorDTO);
            limpiarCampos();
        }else mostrarAlerta("Error", "El jugadorDTO ya existe");
    }

    /**
     * Método para mostrar una alerta cuando hay errores en la validación.
     * @param titulo Título de la alerta.
     * @param mensaje Mensaje que se mostrará en la alerta.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     *Metodo que crea una instancia de Jugador con los datos ingresados en la interfaz
     * @return nuevo JugadorDTO
     */
    private JugadorDTO buildJugadorDTO() {
        return new JugadorDTO(
                selectedJugador,
                selectedEquipo

        );
    }


    /**
     *Metodo para eliminar un jugador de la tabla
     */
    private void eliminarJugadorDTO() {
        JugadorDTO selectedJugadorDTO = tb_JugadorDTO.getSelectionModel().getSelectedItem();
        if (selectedJugadorDTO != null && jugadorDTOController.eliminarJugadorDTO(selectedJugadorDTO.getCedula())) {
            tb_JugadorDTO.getItems().remove(selectedJugadorDTO);
            limpiarCampos();
            tb_JugadorDTO.getSelectionModel().clearSelection();
        }
    }

    /**
     * Metodo que actualiza la información del JugadorDTO seleccionado.
     * Si el JugadorDTO se encuentra en la lista y la actualización es exitosa,
     * se reemplaza por el nuevo objeto actualizado y se refresca la tabla.
     */

    private void actualizarJugadorDTO() {

        if (selectedJugadorDTO != null &&
               jugadorDTOController.actualizarJugadorDTO(selectedJugadorDTO.getCedula(), buildJugadorDTO())) {

            int index = listaJugadoresDTO.indexOf(selectedJugadorDTO);
            if (index >= 0) {
                listaJugadoresDTO.set(index, buildJugadorDTO());
            }

            tb_JugadorDTO.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    /**
     * Metodo que limpia la seleccion de la tabla
     */
    private void limpiarSeleccion() {
        tb_JugadorDTO.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    /**
     *Metodo que limpia los acmpos del JugadorDTO seleccionado
     */
    private void limpiarCampos() {
        tb_Jugador.getSelectionModel().clearSelection();
        tb_Equipos.getSelectionModel().clearSelection();
    }

    /**
     *metodo que seta APP
     * @param app
     */
    public void setApp(App app) {
        this.app = app;
    }
}
