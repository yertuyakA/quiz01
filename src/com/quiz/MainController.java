package com.quiz;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class MainController  extends MainService {

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

    @FXML
    void click() {
        //запуск авторизации при нажатии кнопки Log in;
      mainButton.setOnAction(new MainService() {
            @Override
            public void run() throws SQLException {
                super.run();
            }
        });
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
        registerButton.setOnAction(new MainService() {
            @Override
            public void createUser() throws SQLException {
                super.createUser();
            }
        });

    }
}