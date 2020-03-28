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
    Button mainButton, registerButton, btnTheme, btnScore, btnExit, btnSimple;
    @FXML
    Label labelNickname, userMaxScore;


    DBService dbService;
    private static String activeLogin;

    void setActiveLogin(String activeLogin) {
        this.activeLogin = activeLogin;
    }

    String getActiveLogin() {
        return activeLogin;
    }

    @FXML
    void click(ActionEvent event) {
        //запуск авторизации при нажатии кнопки Log in;
        dbService = new DBService();

        try {
            if(dbService.isRegistered(enterLogin.getText().toString(), enterPassword.getText().toString())){
                System.out.println("TRUE!!!");
                activeLogin = enterLogin.getText().toString();
                System.out.println(activeLogin);

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
    void click1() {
        registerButton.setText("Сохранить");
        enterNickname.setVisible(true);
        labelNickname.setVisible(true);
        promptArea.setText("Заполните данные для регистрации");
        mainButton.setVisible(false);

    }

    @FXML
    void getScore() {
        userMaxScore.setVisible(true);
        dbService = new DBService();
        //вывод счета пользователя из базы поле max_score;
        System.out.println(activeLogin);
        int maxScore = 0;
        try {
            maxScore = dbService.getMaxScore(activeLogin);
            userMaxScore.setText("maxScore");
            System.out.println("Счет: "+maxScore);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void getTheme() {
     //выводить  окно выбора тем с вопросами;
    }

    @FXML
    void exitQuiz() {
        //выход из программы;
    }
}