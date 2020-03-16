import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainService {
    DBService dBService;
    Connection con;

    public void run() throws SQLException {
        dBService = new DBService();
        // здесь будет наша логика
        login();

    }

    public void login() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин:");
        String login = sc.nextLine();
        System.out.println("Введите пароль:");
        String password = sc.nextLine();
        System.out.println("Введите имя:");
        String nickname = sc.nextLine();

        if(dBService.isRegistered(login, password,nickname)){
            System.out.println("Вы вошли в систему!");
        }else{
            System.out.println("Хотите зарегистрироваться?");
            Scanner scr = new Scanner(System.in);
            String a = scr.nextLine();
            if(a.equals("Да")){
                PreparedStatement prpd = con.prepareStatement("insert into users "+ "values(?,?,?)");
                prpd.setString(1,login);
                prpd.setString(2,password);
                prpd.setString(3,nickname);
                prpd.execute();
            }
            else if(a.equals("Нет")){
                System.out.println("До свидания");
            }
        }

    }

}
