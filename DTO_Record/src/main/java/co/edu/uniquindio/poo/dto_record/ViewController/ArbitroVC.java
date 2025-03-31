package co.edu.uniquindio.poo.dto_record.ViewController;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Controller.ArbitroController;
import co.edu.uniquindio.poo.dto_record.Modelo.Arbitro;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class ArbitroVC {
    App app;
    ArbitroController arbitroController;
    ObservableList<Arbitro> listaArbitro = FXCollections.observableArrayList();
    Arbitro selectedArbitro;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Arbitro, String> tbc_CedulaArbitro;

    @FXML
    private Button btn_Agregar;

    @FXML
    private TextField txt_NombreArbitro;

    @FXML
    private Button btn_volver;

    @FXML
    private TableColumn<Arbitro, String> tbc_NombreArbitro;

    @FXML
    private Button btn_Elimnar;

    @FXML
    private TableColumn<Arbitro, String> tbc_Categoria;

    @FXML
    private TextField txt_ApellidoArbitro;

    @FXML
    private TableColumn<Arbitro, Integer> tbc_Partidos;

    @FXML
    private Button btn_Actualizar;

    @FXML
    private Button btn_Limpiar;

    @FXML
    private TableView<Arbitro> tb_Arbitro;

    @FXML
    private TextField txt_CedulaArbitro;

    @FXML
    private TableColumn<Arbitro, String> tbc_ApellidoArbitro;

    @FXML
    private TextField txt_PartidosArbitro;

    @FXML
    private ComboBox<Arbitro.Categoria> cmbx_Categoria;


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
            app.MenuMiembro();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void AgregarArbitro(ActionEvent event) {
        agregarArbitro();
    }

    @FXML
    void EliminarArbitro(ActionEvent event) {
        eliminarArbitro();
    }

    @FXML
    void ActualizarArbitro(ActionEvent event) {
        actualizarArbitro();
    }

    @FXML
    void LimpiarArbitro(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void initialize() {
        assert tbc_CedulaArbitro != null : "fx:id=\"tbc_CedulaArbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert btn_Agregar != null : "fx:id=\"btn_Agregar\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert txt_NombreArbitro != null : "fx:id=\"txt_NombreArbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert btn_volver != null : "fx:id=\"btn_volver\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert tbc_NombreArbitro != null : "fx:id=\"tbc_NombreArbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert btn_Elimnar != null : "fx:id=\"btn_Elimnar\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert tbc_Categoria != null : "fx:id=\"tbc_Categoria\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert txt_ApellidoArbitro != null : "fx:id=\"txt_ApellidoArbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert tbc_Partidos != null : "fx:id=\"tbc_Partidos\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert btn_Actualizar != null : "fx:id=\"btn_Actualizar\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert btn_Limpiar != null : "fx:id=\"btn_Limpiar\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert tb_Arbitro != null : "fx:id=\"tb_Arbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert txt_CedulaArbitro != null : "fx:id=\"txt_CedulaArbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert tbc_ApellidoArbitro != null : "fx:id=\"tbc_ApellidoArbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert txt_PartidosArbitro != null : "fx:id=\"txt_PartidosArbitro\" was not injected: check your FXML file 'Arbitro.fxml'.";
        assert cmbx_Categoria != null : "fx:id=\"cmbx_Categoria\" was not injected: check your FXML file 'Arbitro.fxml'.";

        animarTextField(txt_ApellidoArbitro);
        animarTextField(txt_CedulaArbitro);
        animarTextField(txt_NombreArbitro);
        animarTextField(txt_PartidosArbitro);


        if (App.competencia == null) {
            System.err.println("No se puede agregar la competencia");
            return;
        }

        arbitroController = new ArbitroController(App.competencia);
        initView();
    }

    /**
     * Metodo que inicializa la vista con los datos cargados.
     */

    private void initView() {

        initDataBinding();
        obtenerArbitro();
        tb_Arbitro.getItems().clear();

        // Agregar los elementos a la tabla
        tb_Arbitro.setItems(listaArbitro);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    /**
     * Método que configura el enlace entre los datos y la vista.
     */

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initDataBinding() {
        tbc_NombreArbitro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbc_ApellidoArbitro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbc_CedulaArbitro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbc_Partidos.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPartidosDirigidos()));
        tbc_Categoria.setCellValueFactory(celldata -> {
            Arbitro.Categoria categoria = celldata.getValue().getCategoria();
            String categoriaString = (categoria != null) ? categoria.toString() : "Sin Tipo";
            return new SimpleStringProperty(categoriaString);
        });

    }

    /**
     * Metodo que obtiene la lista de doctores del sistema.
     */

    private void obtenerArbitro() {
        if (arbitroController != null) {
            listaArbitro.addAll(arbitroController.obtenerListaArbitro());
        } else {
            System.err.println("doctorController no está inicializado.");
        }
    }

    /**
     * Método que configura un listener para la selección de elementos en la tabla de doctores.
     */

    private void listenerSelection() {
        tb_Arbitro.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedArbitro = newSelection;
            mostrarInformacionArbitro(selectedArbitro);
        });
    }

    /**
     * Metodo que muestra la información del doctor  seleccionado en el campo de texto.
     * @param arbitro
     */

    private void mostrarInformacionArbitro(Arbitro arbitro) {
        if (arbitro != null) {
            // Asignar valores a los campos de texto
            txt_NombreArbitro.setText(arbitro.getNombre());
            txt_ApellidoArbitro.setText(arbitro.getApellido());
            txt_CedulaArbitro.setText(arbitro.getCedula());
            txt_PartidosArbitro.setText(String.valueOf(arbitro.getPartidosDirigidos()));
            cmbx_Categoria.getSelectionModel().select(arbitro.getPartidosDirigidos());
        }
    }

    /**
     * Metodo que agrega un nuevo doctor a la lista y lo almacena en el controlador.
     * Se crea un nuevo doctor a partir de los datos ingresados y se añade a la lista si la operación es exitosa.
     */

    private void agregarArbitro() {
        Arbitro arbitro = buildArbitro();
        if(arbitroController.crearArbitro(arbitro)){
            listaArbitro.add(arbitro);
            limpiarCampos();
        }
    }

    /**
     * Metodo que construye un objeto de tipo doctor con la información ingresada.
     * @return Un objeto Doctor con el código ingresado en el campo de texto.
     */

    private Arbitro buildArbitro() {
        int partidos = Integer.parseInt(txt_PartidosArbitro.getText());
        Arbitro arbitro = new Arbitro(
                txt_NombreArbitro.getText(),
                txt_ApellidoArbitro.getText(),
                txt_CedulaArbitro.getText(),
                partidos,
                cmbx_Categoria.getValue()
        );
        return arbitro;
    }


    /**
     * Metodo que elimina el doctor seleccionado de la lista y del controlador.
     * Si la eliminación es exitosa, también se eliminan los datos de la tabla y se limpian los campos de entrada.
     */

    private void eliminarArbitro() {
        if (arbitroController.eliminarArbitro(txt_CedulaArbitro.getText())) {
            listaArbitro.remove(selectedArbitro);
            limpiarCampos();
            limpiarSeleccion();
        }
    }

    /**
     * Metodo que actualiza la información del doctor seleccionado.
     * Si el Doctor se encuentra en la lista y la actualización es exitosa,
     * se reemplaza por el nuevo objeto actualizado y se refresca la tabla.
     */

    private void actualizarArbitro() {

        if (selectedArbitro != null &&
                arbitroController.actualizarArbtro(selectedArbitro.getCedula(), buildArbitro())) {

            int index = listaArbitro.indexOf(selectedArbitro);
            if (index >= 0) {
                listaArbitro.set(index, buildArbitro());
            }

            tb_Arbitro.refresh();
            limpiarSeleccion();
            limpiarCampos();
        }
    }

    /**
     * Metodo que limpia la selección de la tabla de doctor y los campos de entrada.
     */
    private void limpiarSeleccion() {
        tb_Arbitro.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    /**
     * Metodo que limpia los campos de entrada y la selección de la tabla de Doctor.
     */
    private void limpiarCampos() {
        txt_NombreArbitro.clear();
        txt_ApellidoArbitro.clear();
        txt_CedulaArbitro.clear();
        txt_PartidosArbitro.clear();
        cmbx_Categoria.setValue(null);
    }

    /**
     * Establece la instancia de la aplicación para acceder a sus métodos.
     * @param app
     */

    public void setApp(App app) {
        this.app = app;

        /**
         * Metodo que inicializa la comboBox con las opciones de la especialidad del objeto Doctor
         */

        ObservableList<Arbitro.Categoria> options = FXCollections.observableArrayList(Arbitro.Categoria.values());
        cmbx_Categoria.setItems((options));
    }
}


