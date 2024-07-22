module br.com.library_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires java.base;

    opens br.com.library_management to javafx.fxml;
    exports br.com.library_management;
    exports br.com.library_management.Controller.Login;
    opens br.com.library_management.Controller.Login to javafx.fxml;
    exports br.com.library_management.Controller.Main;
    opens br.com.library_management.Controller.Main to javafx.fxml;
}
