module bzu.computerscience.encryption_alorithms {
    requires javafx.controls;
    requires javafx.fxml;


    opens bzu.computerscience.encryption_alorithms to javafx.fxml;
    exports bzu.computerscience.encryption_alorithms;
}