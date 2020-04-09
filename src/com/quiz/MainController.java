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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.String.valueOf;

public class MainController{


    @FXML
    TextField enterLogin, enterNickname;
    @FXML
    PasswordField enterPassword;

    @FXML
    TextArea promptArea;

    @FXML
    Button mainButton, registerButton,scoreButton,themeButton,ftButton,answer1btn,answer2btn,answer3btn,answer4btn;

    @FXML
    Label labelNickname,labelLogin,labelPassword,labelScore,labelQuestion;




    DBService dbService;
    static String  activeLogin;
    String writeNickname;
    String writePassword;
    String writeLogin;
    String login;


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
    void registration(ActionEvent event) throws IOException {
         dbService = new DBService();


        try {

            dbService.create( writeNickname,  writePassword,  writeLogin);
            // dbService.loginExist(login);

            registerButton.setText("Сохранить");
            enterNickname.setVisible(true);
            labelNickname.setVisible(true);
            mainButton.setVisible(false);

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
    @FXML
    void score(ActionEvent event) throws IOException {
         dbService = new DBService();
        int maxScore = 0;


        try{
            maxScore = dbService.getScore(activeLogin) ;


            scoreButton.setVisible(false);
            labelScore.setVisible(true);
            labelScore.setText(String.valueOf(maxScore));
            System.out.println(maxScore);


        }
        catch (SQLException e ){
            e.printStackTrace();

        }

    }
    @FXML
    void football(ActionEvent event){
        dbService = new DBService();

        try{
            List<FootballTheme> footballQuestions = dbService.getQuestion(2);
            Collections.shuffle(footballQuestions);
            FootballTheme footballTheme = footballQuestions.get(0);
            footballTheme.getQuestion();
            List<String>answers = new ArrayList<>();
            answers.add(footballTheme.getAnswer());
            answers.add(footballTheme.getWrongAnswer1());
            answers.add(footballTheme.getWrongAnswer2());
            answers.add(footballTheme.getWrongAnswer3());
            Collections.shuffle(answers);

            labelQuestion.setText(footballTheme.getQuestion());
            answer1btn.setText(footballTheme.getAnswer());
            answer2btn.setText(footballTheme.getWrongAnswer1());
            answer3btn.setText(footballTheme.getWrongAnswer2());
            answer4btn.setText(footballTheme.getWrongAnswer3());

            URL xmlUrl = getClass().getResource("quesansw.fxml");
            Parent root = FXMLLoader.load(xmlUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc = new Scene(root);
            stage.setScene(sc);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void themes(ActionEvent event){
        dbService = new DBService();

        try{
            URL xmlUrl = getClass().getResource("themes.fxml");
            Parent root = FXMLLoader.load(xmlUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene sc = new Scene(root);
            stage.setScene(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
