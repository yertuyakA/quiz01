package com.quiz;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class MainController  extends MainService {

    @FXML
    TextField enterLogin, promptField, enterNickname;
    @FXML
    PasswordField enterPassword;
    @FXML
    Button mainButton, registerButton;


    @FXML
    void click() {
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
}