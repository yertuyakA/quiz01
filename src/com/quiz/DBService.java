package com.quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public boolean isRegistered(String login, String password) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("select * from users where login = ? and password = ?");
        pstm.setString(1, login);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            return false;
        } else {
            return true;
        }

    }

    public boolean loginExist(String login) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("select * from users where login = ?");
        pstm.setString(1, login);
        ResultSet log = pstm.executeQuery();
        if (log.next()) {
            return true;
        } else {
            return false;
        }
    }


    public void create(String writeNickname, String writePassword, String writeLogin) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("INSERT INTO users (nickname, password, login) values(?, ?, ?)");
        pstm.setString(1, writeNickname);
        pstm.setString(2, writePassword);
        pstm.setString(3, writeLogin);
        pstm.execute();

    }

    public int getScore(String activelogin) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("select max_score from users where login = ?");
        pstm.setString(1, activelogin);
        ResultSet rst = pstm.executeQuery();
        int score = 0;
        if (rst.next()) {
            score = rst.getInt(1);
        }
        //System.out.println(score);
        return score;
    }

    public  List<FootballTheme> getFootballTheme(int themeId) throws SQLException {
        mainController = new MainController();

        PreparedStatement pstm = con.prepareStatement("select*from question_answers where theme_id=?");
        pstm.setInt(1,themeId);
        ResultSet ft = pstm.executeQuery();

        List<FootballTheme>footballThemes = new ArrayList<>();
        while (ft.next()){
            Theme fAnswerQues = new FootballTheme();
            fAnswerQues.setId(ft.getInt(1));
            fAnswerQues.setQuestion(ft.getString(2));
            fAnswerQues.setAnswer(ft.getString(3));
            fAnswerQues.setWrongAnswer1(ft.getString(4));
            fAnswerQues.setWrongAnswer2(ft.getString(5));
            fAnswerQues.setWrongAnswer3(ft.getString(6));
            fAnswerQues.setThemeId(ft.getInt(7));

            footballThemes.add((FootballTheme) fAnswerQues);
        }
       // System.out.println(footballThemes);
        return footballThemes;
    }
    public List<FootballTheme>getQuestion(int themeId)throws SQLException{
        mainController = new MainController();

        PreparedStatement pstm = con.prepareStatement("select * from question_answers where theme_id=?");
        pstm.setInt(1,themeId);
        ResultSet fq = pstm.executeQuery();

        List<FootballTheme>footballQuestions = new ArrayList<>();
        while(fq.next()){
            FootballTheme fQuestions = new FootballTheme();
            fQuestions.setId(fq.getInt(1));
            fQuestions.setQuestion(fq.getString(2));
            fQuestions.setAnswer(fq.getString(3));
            fQuestions.setWrongAnswer1(fq.getString(4));
            fQuestions.setWrongAnswer2(fq.getString(5));
            fQuestions.setWrongAnswer3(fq.getString(6));
            fQuestions.setThemeId(fq.getInt(7));
            footballQuestions.add((FootballTheme) fQuestions);
        }
        //System.out.println(footballQuestions);
        return footballQuestions;
    }
}


