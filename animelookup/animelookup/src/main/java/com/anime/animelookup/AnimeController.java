package com.anime.animelookup;

import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Objects;
import java.util.Scanner;
import com.google.gson.Gson;
import javafx.stage.Stage;

public class AnimeController {
    public Label animeDetail;
    public Label animeFound;
    public TextField animeLookupSearchField;
    public ListView animeLookupResults;

    public void initialize() {
        animeLookupResults.setOnMouseClicked(event -> {
            try {
                showAnimeDetails();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public <T> KitsuResponse<T> getKitsuResponse(String endPoint, boolean isDetail){
        InputStream inputStream = null;
        try {
            Gson gson = new Gson();
            URL url = new URL(endPoint);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("METHOD", "GET");
            inputStream = connection.getInputStream();
            String responseBody = "";
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                responseBody += scanner.nextLine();
            }
        if (isDetail)
        {
            TypeToken<KitsuResponse<AnimeDetails>> typeToken = new TypeToken<>() {};
            return gson.fromJson(responseBody, typeToken.getType());
        } else
        {
            TypeToken<KitsuResponse<AnimeData>> typeToken = new TypeToken<>() {};
            return gson.fromJson(responseBody, typeToken.getType());
        }
        } catch (MalformedURLException e) {
            System.out.println("Error: Invalid URL for anime lookup");
        } catch (IOException e) {
            System.out.println("Error: An error occurred during the anime lookup");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }
        return null;
    }

    public void showAnimeDetails() throws IOException {
        AnimeData animeData = (AnimeData) animeLookupResults.getSelectionModel().getSelectedItem();
        if (animeData != null)
        {
            String animeDetailEndpoint = "https://kitsu.io/api/edge/anime?filter[id]=" + animeData.getId();
            KitsuResponse<AnimeDetails> kitsuResponse = getKitsuResponse(animeDetailEndpoint, true);
            if (kitsuResponse != null)
            {
             AnimeDetails animeDetails = kitsuResponse.getData().get(0);
             Stage stage = (Stage) animeLookupResults.getScene().getWindow();
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("anime-detail-view.fxml"));
             Parent root = fxmlLoader.load();
             AnimeDetailController animeDetailController = fxmlLoader.getController();
             animeDetailController.setCenterLabel(animeDetails.getAttributes().getTitles().toString());
             animeDetailController.setAnimeCoverImage(animeDetails.getAttributes().getPosterImage().getLarge());
             animeDetailController.setRating(animeDetails.getAttributes().getAverageRating());
             animeDetailController.setAgeRating(animeDetails.getAttributes().getAgeRating() + " ( " + animeDetails.getAttributes().getAgeRatingGuide() + " )");
             animeDetailController.setEpisodeCount(animeDetails.getAttributes().getEpisodeCount());
             animeDetailController.setShowType(animeDetails.getAttributes().getShowType());
             animeDetailController.setNsfw(animeDetails.getAttributes().isNsfw());
             animeDetailController.setDescription(animeDetails.getAttributes().getDescription());

                Scene scene = new Scene(root, 600, 600);
             scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("animelookup.css")).toExternalForm());
             stage.setTitle("Anime Detail View");
             stage.setScene(scene);
             stage.show();
            }
        }
    }

    public void lookupAnime() {
        String animeLookupText = animeLookupSearchField.getText();
        String animeLookupEndpoint = "https://kitsu.io/api/edge/anime?filter[text]=" + animeLookupText.replace(" ", "%20");
        ObservableList<AnimeData> animeDataObservableList = FXCollections.observableArrayList();
        KitsuResponse<AnimeData> kitsuResponse =  getKitsuResponse(animeLookupEndpoint, false);
        if(kitsuResponse != null)
        {
            animeDataObservableList.addAll(kitsuResponse.getData());
            animeFound.setText("Anime found: " + animeDataObservableList.size());
            animeDetail.setVisible(!animeDataObservableList.isEmpty());
            animeLookupResults.setItems(animeDataObservableList);
        }else {
            animeFound.setText("Anime found: 0");
        }
    }
}
