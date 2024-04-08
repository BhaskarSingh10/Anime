module com.anime.animelookup {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.anime.animelookup to javafx.fxml;
    exports com.anime.animelookup;
}