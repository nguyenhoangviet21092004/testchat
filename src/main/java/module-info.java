module com.example.testchat2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.testchat2 to javafx.fxml;
    exports com.example.testchat2;
}