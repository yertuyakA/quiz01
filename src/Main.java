import java.sql.SQLException;

public class Main{
    public static void main(String[] args){
        MainService mainService = new MainService();
        try {
            mainService.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
