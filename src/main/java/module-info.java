module com.languagelearning {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
    requires poi.ooxml;


    opens com.languagelearning to javafx.fxml;
    exports com.languagelearning;
}




