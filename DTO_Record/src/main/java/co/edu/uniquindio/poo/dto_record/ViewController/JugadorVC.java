package co.edu.uniquindio.poo.dto_record.ViewController;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Controller.ArbitroController;
import co.edu.uniquindio.poo.dto_record.Controller.JugadorController;
import co.edu.uniquindio.poo.dto_record.Modelo.Arbitro;
import co.edu.uniquindio.poo.dto_record.Modelo.Jugador;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class JugadorVC {
     App app;
    JugadorController jugadorController;
    ObservableList<Jugador> listaJugadores = FXCollections.observableArrayList();
    Jugador selectedJugador;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tbc_PosicionJugador"
    private TableColumn<Jugador, Jugador.Posicion> tbc_PosicionJugador; // Value injected by FXMLLoader

    @FXML // fx:id="txt_ApellidoJugador"
    private TextField txt_ApellidoJugador; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Eliminar"
    private Button btn_Eliminar; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Agregar"
    private Button btn_Agregar; // Value injected by FXMLLoader

    @FXML // fx:id="tb_Jugador"
    private TableView<Jugador> tb_Jugador; // Value injected by FXMLLoader

    @FXML // fx:id="btn_volver"
    private Button btn_volver; // Value injected by FXMLLoader

    @FXML // fx:id="txt_NombreJugador"
    private TextField txt_NombreJugador; // Value injected by FXMLLoader

    @FXML // fx:id="cmbx_Posicion"
    private ComboBox<Jugador.Posicion> cmbx_Posicion; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_NombreJugador"
    private TableColumn<Jugador, String> tbc_NombreJugador; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_CedulaJugador"
    private TableColumn<Jugador, String> tbc_CedulaJugador; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Actualizar"
    private Button btn_Actualizar; // Value injected by FXMLLoader

    @FXML // fx:id="btn_Limpiar"
    private Button btn_Limpiar; // Value injected by FXMLLoader

    @FXML // fx:id="txt_CedulaJugador"
    private TextField txt_CedulaJugador; // Value injected by FXMLLoader

    @FXML // fx:id="tbc_ApellidoJugador"
    private TableColumn<Jugador, String > tbc_ApellidoJugador; // Value injected by FXMLLoader

    /**
     *Metodo para animar el diseño y efectuar la interaccion con el text field
     */
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
     *Metodo para regresar a la ventana anterior
     */
    @FXML
    void Volver(ActionEvent event) {
        try{
            app.MenuMiembro();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void AgregarJugador(ActionEvent event) {
        agregarJugador();
    }

    @FXML
    void EliminarJugador(ActionEvent event) {
        eliminarJugador();
    }

    @FXML
    void ActualizarJugador(ActionEvent event) {
        actualizarJugador();
    }

    @FXML
    void LimpiarJugador(ActionEvent event) {limpiarCampos();}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tbc_PosicionJugador != null : "fx:id=\"tbc_PosicionJugador\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert txt_ApellidoJugador != null : "fx:id=\"txt_ApellidoJugador\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert btn_Eliminar != null : "fx:id=\"btn_Eliminar\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert btn_Agregar != null : "fx:id=\"btn_Agregar\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert tb_Jugador != null : "fx:id=\"tb_Jugador\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert btn_volver != null : "fx:id=\"btn_volver\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert txt_NombreJugador != null : "fx:id=\"txt_NombreJugador\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert cmbx_Posicion != null : "fx:id=\"cmbx_Posicion\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert tbc_NombreJugador != null : "fx:id=\"tbc_NombreJugador\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert tbc_CedulaJugador != null : "fx:id=\"tbc_CedulaJugador\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert btn_Actualizar != null : "fx:id=\"btn_Actualizar\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert btn_Limpiar != null : "fx:id=\"btn_Limpiar\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert txt_CedulaJugador != null : "fx:id=\"txt_CedulaJugador\" was not injected: check your FXML file 'JugadorView.fxml'.";
        assert tbc_ApellidoJugador != null : "fx:id=\"tbc_ApellidoJugador\" was not injected: check your FXML file 'JugadorView.fxml'.";

        animarTextField(txt_NombreJugador);
        animarTextField(txt_ApellidoJugador);
        animarTextField(txt_CedulaJugador);

        if (App.competencia == null) {
            System.err.println("No se puede agregar la competencia");
            return;
        }

        jugadorController = new JugadorController(App.competencia);
        initView();
    }

    /**
     * Metodo que inicializa la vista con los datos cargados.
     */

    private void initView() {

        initDataBinding();
        obtenerJugador();
        tb_Jugador.getItems().clear();

        // Agregar los elementos a la tabla
        tb_Jugador.setItems(listaJugadores);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    /**
     * Método que configura el enlace entre los datos y la vista.
     */

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initDataBinding() {
        tbc_NombreJugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_ApellidoJugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_CedulaJugador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_PosicionJugador.setCellValueFactory(celldata -> {
            Jugador.Posicion posicion = celldata.getValue().getPosicion();
            String posicionString = (posicion != null) ? posicion.toString() : "Sin Tipo";
            return new SimpleObjectProperty(posicionString);
        });

    }

    /**
     * Metodo que obtiene la lista de Jugadores del sistema.
     */

    private void obtenerJugador() {
        if (jugadorController != null) {
            listaJugadores.addAll(jugadorController.obtenerListaJugadores());
        } else {
            System.err.println("jugadorController no está inicializado.");
        }
    }

    /**
     * Método que configura un listener para la selección de elementos en la tabla de jugadores.
     */

    private void listenerSelection() {
        tb_Jugador.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedJugador = newSelection;
            mostrarInformacionJugador(selectedJugador);
        });
    }

    /**
     * Metodo que muestra la información del jugador  seleccionado en el campo de texto.
     * @param jugador
     */

    private void mostrarInformacionJugador(Jugador jugador) {
        if (jugador != null) {
            // Asignar valores a los campos de texto
            txt_NombreJugador.setText(jugador.getNombre());
            txt_ApellidoJugador.setText(jugador.getApellido());
            txt_CedulaJugador.setText(jugador.getCedula());
            cmbx_Posicion.getSelectionModel().select(jugador.getPosicion());
        }
    }

    /**
     * Metodo que agrega un nuevo jugador a la lista y lo almacena en el controlador.
     * Se crea un nuevo jugador a partir de los datos ingresados y se añade a la lista si la operación es exitosa.
     */

    private void agregarJugador() {
        if (validarCampos()) {
            Jugador jugador = buildJugador();
            if (jugadorController.crearJugador(jugador)) {
                listaJugadores.add(jugador);
                limpiarCampos();

            }else {
                mostrarAlerta("Error","Uups... Parece que este Jugador ya existe");
            }
        } else {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
        }
    }

    /**
     * Método que valida si todos los campos están llenos antes de crear un jugador.
     * @return true si todos los campos están llenos, false en caso contrario.
     */
    private boolean validarCampos() {
        return !txt_NombreJugador.getText().trim().isEmpty()
                && !txt_ApellidoJugador.getText().trim().isEmpty()
                && !txt_CedulaJugador.getText().trim().isEmpty()
                && cmbx_Posicion.getValue() != null;
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
     * Metodo que construye un objeto de tipo jugador con la información ingresada.
     * @return Un objeto Jugador con el código ingresado en el campo de texto.
     */

    private Jugador buildJugador() {
        return new Jugador(
                txt_NombreJugador.getText(),
                txt_ApellidoJugador.getText(),
                txt_CedulaJugador.getText(),
                cmbx_Posicion.getValue()
        );
    }


    /**
     * Metodo que elimina el Jugador seleccionado de la lista y del controlador.
     * Si la eliminación es exitosa, también se eliminan los datos de la tabla y se limpian los campos de entrada.
     */

    private void eliminarJugador() {
        if (jugadorController.eliminarJugador(txt_CedulaJugador.getText())) {
            listaJugadores.remove(selectedJugador);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    /**
     * Metodo que actualiza la información del Jugador seleccionado.
     * Si el Jugador se encuentra en la lista y la actualización es exitosa,
     * se reemplaza por el nuevo objeto actualizado y se refresca la tabla.
     */

    private void actualizarJugador() {

        if (selectedJugador != null &&
                jugadorController.actualizarJugador(selectedJugador.getCedula(), buildJugador())) {

            int index = listaJugadores.indexOf(selectedJugador);
            if (index >= 0) {
                listaJugadores.set(index, buildJugador());
            }

            tb_Jugador.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    /**
     * Metodo que limpia la selección de la tabla de jugador y los campos de entrada.
     */
    private void limpiarSeleccion() {
        tb_Jugador.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    /**
     * Metodo que limpia los campos de entrada y la selección de la tabla de Jugador.
     */
    private void limpiarCampos() {
        txt_NombreJugador.clear();
        txt_ApellidoJugador.clear();
        txt_CedulaJugador.clear();
        cmbx_Posicion.setValue(null);

    }

    /**
     * Establece la instancia de la aplicación para acceder a sus métodos.
     * @param app
     */

    public void setApp(App app) {
        this.app = app;

        /**
         * Metodo que inicializa la comboBox con las opciones de la posicion del jugador
         */

        ObservableList<Jugador.Posicion> options = FXCollections.observableArrayList(Jugador.Posicion.values());
        cmbx_Posicion.setItems((options));
    }
}
