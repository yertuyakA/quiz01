package com.quiz;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.sql.SQLException;

public class MainService {
    DBService dBService;
    MainController mainController;

// для консоли
    public void run() throws SQLException {
        dBService = new DBService();
        // здесь будет наша логика
        mainController = new MainController();
        login();
        createUser();
    }

/*авторизация с консоли
        //авторизация в консоли;
        public void login() throws SQLException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите логин");
            String login = sc.nextLine();
            System.out.println("Введите пароль");
            String password = sc.nextLine();
            if (dBService.isRegistered(login, password)) {
                System.out.println("Вы вошли в систему");
            } else {
                System.out.println("Не хотите зарегистрироваться?");
                if (sc.nextLine().equals("да")) {
                    createUser();
                } else {
                    System.out.println("Для повторного входа введите любой символ");
                    if(!sc.nextLine().equals("")){
                        login();
                }
            }
        }
  }

    //регистрация в консоли;
    public void createUser() throws SQLException {
        System.out.println("Nickname:");
        Scanner in = new Scanner(System.in);
        String writeNickname = in.nextLine();
        System.out.println("Логин:");
        String writeLogin = in.nextLine();
        System.out.println("Пароль:");
        String writePassword = in.nextLine();
        if(dBService.loginExist(writeLogin)) {
            //проверка на уникальность поля login в таблице users
        } else {
            dBService.write(writeNickname, writePassword, writeLogin);
            System.out.println("Вы успешно зарегистрированы!");
            login();
        }
    }
    */

    //Авторизация;
     public void login() throws SQLException {
        String login = mainController.enterLogin.getText();
        String password = mainController.enterPassword.getText();
        if (dBService.isRegistered(login, password)) {
            mainController.promptArea.setText("Вы вошли в систему");
        } else {
            mainController.promptArea.setText("Введены неверные данные. Нажмите кнопку 'Регистрация' для регистрации в системе");

        }
    }

    public boolean login(String login, String password){
        try {
            return dBService.isRegistered(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Регистрация;
    public void createUser() throws SQLException {
        String writeNickname = mainController.enterNickname.getText();
        String writeLogin = mainController.enterLogin.getText();
        String writePassword = mainController.enterPassword.getText();
        if(dBService.loginExist(writeLogin)) {
            //проверка на уникальность поля login в таблице users;
        } else {
            dBService.write(writeNickname, writePassword, writeLogin);
            mainController.promptArea.setText("Вы успешно зарегистрированы!");
            mainController.registerButton.setText("Регистрация");
            mainController.labelNickname.setVisible(false);
            mainController.enterNickname.setVisible(false);
            mainController.mainButton.setVisible(true);
        }
    }


}
