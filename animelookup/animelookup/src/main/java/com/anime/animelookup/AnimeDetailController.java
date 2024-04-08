package com.anime.animelookup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AnimeDetailController {
    public Label centerLabel;
    public Button backToAnimeLookup;
    public ImageView animeCoverImage;
    public Label rating;
    public Label ageRating;
    public Label showType;
    public Label episodeCount;
    public Label nsfw;
    public Label description;

    public void initialize(){
        backToAnimeLookup.setOnAction(e -> {
            Stage stage = (Stage) backToAnimeLookup.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("anime-lookup-view.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            Scene scene = new Scene(root, 600, 600);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("animelookup.css")).toExternalForm());
            stage.setTitle("Anime Lookup");
            stage.setScene(scene);
            stage.show();
        });
    }

    public void setCenterLabel(String label) {
       centerLabel.setText(label);
    }

    public void setAnimeCoverImage(String img) {
        Image image = new Image(img);
        animeCoverImage.setImage(image);
    }

    public void setRating(String averageRating) {
        rating.setText(averageRating);
    }

    public void setAgeRating(String ageR) {
        ageRating.setText(ageR);
    }

    public void setEpisodeCount(int ep) {
        episodeCount.setText(String.valueOf(ep));
    }

    public void setShowType(String sType) {
        showType.setText(sType);
    }

    public void setDescription(String descp) {
       description.setText(descp);
    }

    public void setNsfw(boolean ns) {
        nsfw.setText(String.valueOf(ns));
    }
}
