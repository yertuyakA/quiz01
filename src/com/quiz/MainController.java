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
    TextArea promptArea;
    @FXML
    PasswordField enterPassword;
    @FXML
    Button mainButton, registerButton;
    @FXML
    Label labelNickname;

    DBService dbService;




    @FXML
    void click(ActionEvent event) {
        //запуск авторизации при нажатии кнопки Log in;
        dbService = new DBService();
        System.out.println("эта кнопка");

        try {
            if(dbService.isRegistered(enterLogin.getText().toString(), enterPassword.getText().toString())){
                System.out.println("TRUE!!!");

                URL xmlUrl = getClass().getResource("menu.fxml");
                Parent root = FXMLLoader.load(xmlUrl);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene sc = new Scene(root);
                stage.setScene(sc);

            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();

        }
        System.out.println("конец кнопки");

/*
     mainButton.setText("OK");
     String login = enterLogin.getText();
     String password = enterPassword.getText();
     promptField.setText(login+"/"+password);
*/


    }

    @FXML
    void click1() {
        registerButton.setText("Сохранить");
        enterNickname.setVisible(true);
        labelNickname.setVisible(true);
        promptArea.setText("Заполните данные для регистрации");
        mainButton.setVisible(false);

    }
}