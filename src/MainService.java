import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MainService {
    DBService dBService;


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
                System.out.println("Введите логин:");
                login = sc.nextLine();
                System.out.println("Введите пароль:");
                password = sc.nextLine();
                System.out.println("Введите имя:");
                nickname = sc.nextLine();
                dBService.createUser(login,password,nickname);
            }
            else {
                System.out.println("До свидания");
            }
        }

    }

}
