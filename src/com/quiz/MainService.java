package com.quiz;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.sql.SQLException;

public class MainService implements EventHandler {
    DBService dBService;
    MainController mainController;

    @Override
    public void handle(Event arg0) {
        try {
            login();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void run() throws SQLException {
        dBService = new DBService();
        // здесь будет наша логика
        mainController = new MainController();
        login();
        //createUser();
    }
/*ввод данных с консоли
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


    public void login() throws SQLException {
        String login = mainController.enterLogin.getText();
        String password = mainController.enterPassword.getText();
        if (dBService.isRegistered(login, password)) {
            mainController.promptField.setText("Вы вошли в систему");
        } else {
            mainController.promptField.setText("Введены неверные данные. Нажмите кнопку 'Регистрация' для регистрации в системе");

        }
    }


}
