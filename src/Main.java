
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

/****************************
 * @author a.yertuyak
 * @since 07.03.2020
 ***************************/
public class Main {
    public static void main(String[] args) {
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS ");
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

    }catch (SQLException e){
            System.out.println(e);
        }
}}
