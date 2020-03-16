import java.sql.*;

public class DBService {
    Connection con;
    Statement stmt;

    public DBService() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", ""); //quiz - наша база
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isRegistered(String login, String password,String nickname) throws SQLException {
        // ResultSet rs = stmt.executyQuery("select * from users where login = "+login + " and password = "+password);
        PreparedStatement pstm = con.prepareStatement("select * from users where login = ? and password = ? and nickname = ?");
        pstm.setString(1, login);
        pstm.setString(2, password);
        pstm.setString(3,nickname);
        ResultSet rs = pstm.executeQuery();

        if(!rs.next()){
            System.out.println("User не найден");
        }else{
            return true;
        }

        return false;
        // select * from users where login = 'Qwer' and password = 'Qwerty123'

    }

}

