package com.quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;




public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("main.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

//        MainService mainService = new MainService();- используется для вывода на консоль проекта(вместа launch(args))
//        try {
//            mainService.run();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    
}
