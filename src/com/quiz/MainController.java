package com.quiz;


import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    void click() {
        //запуск авторизации при нажатии кнопки Log in;
        dbService = new DBService();

        try {
            if(dbService.isRegistered(enterLogin.getText().toString(), enterPassword.getText().toString())){
              System.out.println("TRUE!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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