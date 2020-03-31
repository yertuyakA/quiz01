package com.quiz;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class MainController{

    @FXML
    TextField enterLogin, enterNickname;

    @FXML
    PasswordField enterPassword;

    @FXML
    TextArea promptArea;

    @FXML
    Button mainButton, registerButton,scr;

    @FXML
    Label labelNickname,labelLogin,labelPassword,maxscore;




    DBService dbService;
    static String  activeLogin;



    @FXML
    void click(ActionEvent event) {
        //запуск авторизации при нажатии кнопки Log in;
        dbService = new DBService();
        System.out.println(enterLogin.getText().toString());

        try {
            if(dbService.isRegistered(enterLogin.getText().toString(),enterPassword.getText().toString())){
              System.out.println("TRUE!!!");
              activeLogin = enterLogin.getText().toString();


                URL xmlUrl = getClass().getResource("menu.fxml");
                Parent root = FXMLLoader.load(xmlUrl);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene sc = new Scene(root);
                stage.setScene(sc);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void registration() throws SQLException {
        registerButton.setText("Сохранить");
        enterNickname.setVisible(true);
        labelNickname.setVisible(true);
        //  mainService.createUser();
        mainButton.setVisible(false);

    }
    @FXML
    void score(ActionEvent event){
        DBService dbService = new DBService();
        int maxScore = 0;

        try{
            dbService.getScore(activeLogin);

            URL xmlUrl = getClass().getResource("score.fxml");
            Parent root = FXMLLoader.load(xmlUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc = new Scene(root);
            maxscore.setText(String.valueOf(maxScore));
            stage.setScene(sc);


        }
        catch (SQLException | IOException e){
            e.printStackTrace();
        }

    }
}