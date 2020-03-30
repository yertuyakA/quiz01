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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    Label labelNickname, userMaxScore, questTheme;


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
    void setBtnMovieTheme (ActionEvent event) {
        dbService = new DBService();
     //вывод вопросов по выбранной теме
        try {
            ResultSet mq = dbService.getMovieTheme();
            List<MovieTheme> movieTheme = new ArrayList<>();
            while (mq.next()){
                Theme movieQuestion = new MovieTheme();
                movieQuestion.setId(mq.getInt(1));
                movieQuestion.setThemeId(mq.getInt(2));
                movieQuestion.setQuestion(mq.getString(3));
                movieQuestion.setAnswer(mq.getString(4));
                movieQuestion.setWrongAnswer1(mq.getString(5));
                movieQuestion.setWrongAnswer2(mq.getString(6));
                movieQuestion.setWrongAnswer3(mq.getString(7));
                movieQuestion.setPoint(mq.getInt(8));

                movieTheme.add((MovieTheme) movieQuestion);

            }
            System.out.println(movieTheme);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @FXML
    void setBtnSportTheme (ActionEvent event) {
        dbService = new DBService();
        //вывод вопросов по выбранной теме
        try {
            ResultSet sq = dbService.getSportTheme();
            List<SportLegendTheme> sportLegendTheme = new ArrayList<>();
            while (sq.next()){
                Theme sportQuestion = new SportLegendTheme();
                sportQuestion.setId(sq.getInt(1));
                sportQuestion.setThemeId(sq.getInt(2));
                sportQuestion.setQuestion(sq.getString(3));
                sportQuestion.setAnswer(sq.getString(4));
                sportQuestion.setWrongAnswer1(sq.getString(5));
                sportQuestion.setWrongAnswer2(sq.getString(6));
                sportQuestion.setWrongAnswer3(sq.getString(7));
                sportQuestion.setPoint(sq.getInt(8));

                sportLegendTheme.add((SportLegendTheme) sportQuestion);

            }
            System.out.println(sportLegendTheme);

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

}