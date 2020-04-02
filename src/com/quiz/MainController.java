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

import static java.lang.String.valueOf;

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
    Label labelNickname,labelLogin,labelPassword,labelScore;




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


            scr.setVisible(false);
            labelScore.setVisible(true);
            labelScore.setText(String.valueOf(maxScore));
            System.out.println(maxScore);


        }
        catch (SQLException e ){
            e.printStackTrace();
        }

    }
}