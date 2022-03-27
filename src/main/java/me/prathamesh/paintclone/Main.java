package me.prathamesh.paintclone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        stage.setTitle("Paint");
        stage.setScene(new Scene(fxmlLoader.load(), 1200, 800));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}