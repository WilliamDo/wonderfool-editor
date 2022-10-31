module com.ultimaspin.wonderfooleditor {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ultimaspin.wonderfooleditor to javafx.fxml;
    exports com.ultimaspin.wonderfooleditor;
}