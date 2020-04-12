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
    public boolean isRegistered(String login, String password) throws
        SQLException {
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

    public boolean loginExist(String writeLogin) throws SQLException {
        PreparedStatement pstm = con.prepareStatement("select * from users where login = ?");
        pstm.setString(1, writeLogin);
        ResultSet log = pstm.executeQuery();
        if(log.next()) {
            return true;
        } else {
            return false;
        }

    }


    public void write(String writeNickname, String writePassword, String writeLogin) throws
        SQLException {
            PreparedStatement pstm = con.prepareStatement ("INSERT INTO users (nickname, password, login) values(?, ?, ?)");
            pstm.setString(1, writeNickname);
            pstm.setString(2, writePassword);
            pstm.setString(3, writeLogin);
            pstm.execute();
        }

    public int getMaxScore(String activeLogin) throws
         SQLException {
            mainController = new MainController();
        PreparedStatement pstm = con.prepareStatement("select max_score from users where login = ?");
        pstm.setString(1, activeLogin);
        ResultSet sc = pstm.executeQuery();
        int score = 0;
        if(sc.next()){
            score = sc.getInt(1);
        }
        System.out.println(score);

        return score;


    }



    public List<MovieTheme> getMovieTheme(int themeId) throws
        SQLException {
            mainController = new MainController();
            PreparedStatement pstm = con.prepareStatement("select * from question_answers where theme_id=?");
            pstm.setInt(1, themeId);
            ResultSet qmt = pstm.executeQuery();
        List<MovieTheme> movieTheme = new ArrayList<>();
        while (qmt.next()){
            Theme movieQuestion = new MovieTheme();
            movieQuestion.setId(qmt.getInt(1));
            movieQuestion.setThemeId(qmt.getInt(2));
            movieQuestion.setQuestion(qmt.getString(3));
            movieQuestion.setAnswer(qmt.getString(4));
            movieQuestion.setWrongAnswer1(qmt.getString(5));
            movieQuestion.setWrongAnswer2(qmt.getString(6));
            movieQuestion.setWrongAnswer3(qmt.getString(7));
            movieQuestion.setPoint(qmt.getInt(8));

            movieTheme.add((MovieTheme) movieQuestion);

        }
            return movieTheme;

        }

    public List<SportLegendTheme> getSportTheme(int themeId) throws
            SQLException {
        PreparedStatement pstm = con.prepareStatement("select * from question_answers where theme_id=?");
        pstm.setInt(1, themeId);
        ResultSet qst = pstm.executeQuery();
        List<SportLegendTheme> sportLegendTheme = new ArrayList<>();
        while (qst.next()){
            Theme sportQuestion = new SportLegendTheme();
            sportQuestion.setId(qst.getInt(1));
            sportQuestion.setThemeId(qst.getInt(2));
            sportQuestion.setQuestion(qst.getString(3));
            sportQuestion.setAnswer(qst.getString(4));
            sportQuestion.setWrongAnswer1(qst.getString(5));
            sportQuestion.setWrongAnswer2(qst.getString(6));
            sportQuestion.setWrongAnswer3(qst.getString(7));
            sportQuestion.setPoint(qst.getInt(8));

            sportLegendTheme.add((SportLegendTheme) sportQuestion);

        }

        return sportLegendTheme;

    }
//формирование общего листа вопросов
    public List<Theme> getQuestions() throws
            SQLException {
        mainController = new MainController();
        PreparedStatement pstm = con.prepareStatement("select * from question_answers");
        ResultSet qat = pstm.executeQuery();
        List<Theme> questionAnswers = new ArrayList<>();
        while (qat.next()){
            Theme questions = new Theme() {
                @Override
                public void checkAnswers() {

                }
            };
            questions.setId(qat.getInt(1));
            questions.setThemeId(qat.getInt(2));
            questions.setQuestion(qat.getString(3));
            questions.setAnswer(qat.getString(4));
            questions.setWrongAnswer1(qat.getString(5));
            questions.setWrongAnswer2(qat.getString(6));
            questions.setWrongAnswer3(qat.getString(7));
            questions.setPoint(qat.getInt(8));

            questionAnswers.add((Theme) questions);

        }
        return questionAnswers;

    }


}

