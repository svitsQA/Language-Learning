module com.languagelearning {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
    requires poi.ooxml;
    requires org.json;


    opens com.languagelearning to javafx.fxml;
    exports com.languagelearning;
    exports com.languagelearning.screens;
    opens com.languagelearning.screens to javafx.fxml;
}




