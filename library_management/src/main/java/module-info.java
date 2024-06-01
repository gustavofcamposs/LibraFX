module br.com.library_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens br.com.library_management to javafx.fxml;
    exports br.com.library_management;
}
