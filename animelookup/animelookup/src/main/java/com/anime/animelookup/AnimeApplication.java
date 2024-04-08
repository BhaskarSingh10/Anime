package com.anime.animelookup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AnimeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AnimeApplication.class.getResource("anime-lookup-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("animelookup.css")).toExternalForm());
        stage.setTitle("Anime Lookup");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("retro-tv.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}