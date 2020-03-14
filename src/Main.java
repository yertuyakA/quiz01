import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/****************************
 * @author a.yertuyak
 * @since 07.03.2020
 ***************************/
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root", ""); //quiz - наша база
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from users");


            List<User> users = new ArrayList<>();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));//Сюда закидывается id Юзера
                user.setNickname(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setMaxScore(rs.getInt(5));

                users.add(user);
            }
            System.out.println(users);

            ResultSet mq = stmt.executeQuery("select*from question_answers where theme_id = 1");

            HashMap<String, List<MovieTheme>> movieMap = new HashMap<>();
            List<MovieTheme> movieTheme = new ArrayList<>();
            while (mq.next()){
                Theme movieQuestion = new MovieTheme();
                movieQuestion.setId(mq.getInt(1));
                movieQuestion.setThemeId(mq.getInt(2));
                movieQuestion.setQuestion(mq.getString(3));
                movieQuestion.setAnswer(mq.getString(4));
                movieQuestion.setWrongAnswer1(mq.getString(5));
                movieQuestion.setWrongAnswer2(mq.getString(6));
                movieQuestion.setWrongAnswer3(mq.getString(7));
                movieQuestion.setPoint(mq.getInt(8));

                movieTheme.add((MovieTheme) movieQuestion);
                movieMap.put("movies", movieTheme);

            }

            System.out.println(movieMap);

            ResultSet sq = stmt.executeQuery("select*from question_answers where theme_id = 2");

            HashMap<String, List<SportLegendTheme>> sportLegendMap = new HashMap<>();
            List<SportLegendTheme> sportLegendTheme = new ArrayList<>();
            while (sq.next()){
                Theme sportLegendQuestion = new SportLegendTheme();
                sportLegendQuestion.setId(sq.getInt(1));
                sportLegendQuestion.setThemeId(sq.getInt(2));
                sportLegendQuestion.setQuestion(sq.getString(3));
                sportLegendQuestion.setAnswer(sq.getString(4));
                sportLegendQuestion.setWrongAnswer1(sq.getString(5));
                sportLegendQuestion.setWrongAnswer2(sq.getString(6));
                sportLegendQuestion.setWrongAnswer3(sq.getString(7));
                sportLegendQuestion.setPoint(sq.getInt(8));

                sportLegendTheme.add((SportLegendTheme) sportLegendQuestion);
                sportLegendMap.put("sports legends", sportLegendTheme);

            }

            System.out.println(sportLegendMap);


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
