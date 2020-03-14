import java.sql.*;

/****************************
 * @author a.yertuyak
 * @since 07.03.2020
 ***************************/
public class Main {
    public static void main(String[] args) {

        MainService mainService = new MainService();
        try {
            mainService.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
