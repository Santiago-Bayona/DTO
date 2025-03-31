module co.edu.uniquindio.poo.dto_record {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.dto_record to javafx.fxml;
    exports co.edu.uniquindio.poo.dto_record;
    exports co.edu.uniquindio.poo.dto_record.Modelo;
    opens co.edu.uniquindio.poo.dto_record.Modelo to javafx.fxml;
    exports co.edu.uniquindio.poo.dto_record.Controller;
    opens co.edu.uniquindio.poo.dto_record.Controller to javafx.fxml;
    opens co.edu.uniquindio.poo.dto_record.ViewController to javafx.fxml;
    exports co.edu.uniquindio.poo.dto_record.ViewController to javafx.fxml;
}
