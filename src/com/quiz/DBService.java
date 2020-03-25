package com.quiz;

import java.sql.*;

public class DBService {
    Connection con;
    Statement stmt;
    MainController mainController;

    public DBService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", ""); //quiz - наша база
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean isRegistered(String login, String password) throws
        SQLException {
            PreparedStatement pstm = con.prepareStatement("select * from users where login = ? and password = ?");
            pstm.setString(1, login);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(!rs.next()){
                System.out.println("Пользователь не найден");
            }else{
                return true;
            }

            return false;
            // select * from users where login = 'Qwer' and password = 'Qwerty123'
        }

    public boolean loginExist(String writeLogin) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("select * from users where login = ?");
        pstm.setString(1, writeLogin);
        ResultSet log = pstm.executeQuery();
        if(log.next()) {
            System.out.println("Логин уже существует.");
        } else {
            return false;
        }
        return true;
    }


    public void write(String writeNickname, String writePassword, String writeLogin) throws
        SQLException {
           PreparedStatement pstm = con.prepareStatement ("INSERT INTO users (nickname, password, login) values(?, ?, ?)");
            pstm.setString(1, writeNickname);
            pstm.setString(2, writePassword);
            pstm.setString(3, writeLogin);
            pstm.execute();
        }


}

