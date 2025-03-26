module co.edu.uniquindio.poo.dto_record {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.dto_record to javafx.fxml;
    exports co.edu.uniquindio.poo.dto_record;
}