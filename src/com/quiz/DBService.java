package com.quiz;

import java.sql.*;

public class DBService {
    Connection con;
    Statement stmt;
    MainController mainController;



    public DBService() {
        mainController = new MainController();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", ""); //quiz - наша база
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public boolean isRegistered(String login,String password) throws SQLException {
            PreparedStatement pstm = con.prepareStatement("select * from users where login = ? and password = ?");
            pstm.setString(1, login);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(!rs.next()){
                return false;
            }else{
                return true;
            }

        }

    public boolean loginExist(String login) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("select * from users where login = ?");
        pstm.setString(1, login);
        ResultSet log = pstm.executeQuery();
        if(log.next()) {
            return true;
        } else {
            return false;
        }
    }


    public void write(String writeNickname, String writePassword, String writeLogin) throws
        SQLException {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO users (nickname, password, login) values(?, ?, ?)");
        pstm.setString(1, writeNickname);
        pstm.setString(2, writePassword);
        pstm.setString(3, writeLogin);
        pstm.execute();

    }
    public int getScore(String activelogin) throws SQLException{
        PreparedStatement pstm = con.prepareStatement("select max_score from users where login = ?");
        pstm.setString(1,activelogin);
        ResultSet rst = pstm.executeQuery();
        int score = 0;
        if(rst.next()){
            score = rst.getInt(1);
        }
        System.out.println(score);
        return score;
    }

}

