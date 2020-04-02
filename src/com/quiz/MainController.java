package com.quiz;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.util.List;

public class MainController{

    @FXML
    TextField enterLogin, enterNickname;
    @FXML
    TextArea promptArea;
    @FXML
    PasswordField enterPassword;
    @FXML
    Button mainButton, registerButton, btnTheme, btnScore, btnSimple, btnSportTheme, btnMovieTheme, answer1, answer2, answer3, answer4;
    @FXML
    Label labelNickname, userMaxScore, questTheme, prompt;


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
                System.out.println(activeLogin+" authorized");

                URL xmlUrl = getClass().getResource("menu.fxml");
                Parent root = FXMLLoader.load(xmlUrl);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene sc = new Scene(root);
                stage.setScene(sc);


            } else {
                System.out.println("User not found");
                prompt.setText("Пользователь не найден");
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
        prompt.setText("Заполните данные для регистрации");
        mainButton.setVisible(false);
        registerButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                createUser();
            }


        });

    }

    @FXML
    //Регистрация;
    void createUser() {
        dbService = new DBService();
        try {
            String writeNickname = enterNickname.getText();
            String writeLogin = enterLogin.getText();
            String writePassword = enterPassword.getText();
            if (dbService.loginExist(writeLogin)) {
                //проверка на уникальность поля login в таблице users;
                System.out.println("User exist");
                prompt.setText("Пользователь существует");
            } else {
                dbService.write(writeNickname, writePassword, writeLogin);
                prompt.setText("Вы успешно зарегистрированы!");
                registerButton.setText("Регистрация");
                labelNickname.setVisible(false);
                enterNickname.setVisible(false);
                mainButton.setVisible(true);
            }
        } catch (SQLException e) {
        e.printStackTrace();

        }
    }

    @FXML
    void getScore() {
        dbService = new DBService();
        //вывод счета пользователя из базы поле max_score;
        int maxScore = 0;
        try {
            maxScore = dbService.getMaxScore(activeLogin);
            userMaxScore.setText("Счет: "+String.valueOf(maxScore));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void exitQuiz() {
        //выход из программы;
        System.exit(1);
    }

    @FXML
    void getTheme(ActionEvent event) throws IOException {
     //выводить  окно выбора тем с вопросами;
            URL xmlUrl = getClass().getResource("theme.fxml");
            Parent root = FXMLLoader.load(xmlUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc = new Scene(root);
            stage.setScene(sc);

    }

    @FXML
    void setBtnMovieTheme () {
        dbService = new DBService();
     //вывод вопросов по выбранной теме
        try {

            List<MovieTheme> movieTheme = dbService.getMovieTheme(1);
            System.out.println(movieTheme);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @FXML
    void setBtnSportTheme () {
        dbService = new DBService();
        //вывод вопросов по выбранной теме
        try {
            List<SportLegendTheme> sportLegendTheme = dbService.getSportTheme(2);
            System.out.println(sportLegendTheme);

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

}