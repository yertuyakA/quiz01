import java.sql.SQLException;
import java.util.Scanner;

public class MainService {
    DBService dBService;

    public void run() throws SQLException {
        dBService = new DBService();
        // здесь будет наша логика

        login();
        //createUser();
    }

        public void login() throws SQLException {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите логин");
            String login = sc.nextLine();
            System.out.println("Введите пароль");
            String password = sc.nextLine();
            if (dBService.isRegistered(login, password)) {
                System.out.println("Вы вошли в систему");
            } else {
                System.out.println("Не хотите зарегистрироваться?");
                if (sc.nextLine().equals("да")) {
                    createUser();
                } else {
                    System.out.println("Для повторного входа введите любой символ");
                    if(!sc.nextLine().equals("")){
                        login();
                }
            }
        }
  }
    public void createUser() throws SQLException {
        System.out.println("Nickname:");
        Scanner in = new Scanner(System.in);
        String writeNickname = in.nextLine();
        System.out.println("Логин:");
        String writeLogin = in.nextLine();
        System.out.println("Пароль:");
        String writePassword = in.nextLine();
        if(dBService.loginExist(writeLogin)) {
            //проверка на уникальность поля login в таблице users
        } else {
            dBService.write(writeNickname, writePassword, writeLogin);
            System.out.println("Вы успешно зарегистрированы!");
            login();
        }
    }


}
