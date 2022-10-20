module com.artech.workerslogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.artech.workerslogin to javafx.fxml;
    exports com.artech.workerslogin;
}