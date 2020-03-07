package oldHomework;

import java.util.HashMap;

public class MainAibek {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("00-09", "");
        String n = "*";
        map.put("10-19", n);

        System.out.println(map);
        n = n + "*";
        map.put("10-19", n);

        int a = 10; // int a = list.get(здесь индекс)
        // попробуйте доделать без листа в первом цикле, где читается с файла

        if(a > 9 && a < 20){
            String q = map.get("10-19");
            q = q + "*";
            map.put("10-19", q);
        }



        String q = map.get("10-19");
        q = q+"*";
        map.put("10-19",q);
     }
}
