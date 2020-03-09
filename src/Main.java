import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/****************************
 * @author a.yertuyak
 * @since 07.03.2020
 ***************************/
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =//127.0.0.1 = localhost
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from users");

            List<User> users = new ArrayList<>();

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1)); //Сюда закидывается id Юзера
                user.setNickname(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setMaxScore(rs.getInt(5));

                users.add(user);
            }

            System.out.println(users);

        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}
