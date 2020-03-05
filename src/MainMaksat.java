
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainMaksat {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner file = null;

        try {
            file = new Scanner(new FileReader("C:\\Schet4ik\\src\\com\\company\\1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (file.hasNext()) {
            int d = file.nextInt();
            System.out.println(d);
            list.add(d);


            System.out.println(d);

        }
        System.out.println(list);
        HashMap<String, String> mapExample = new HashMap<>();
        mapExample.put("0-9:", "");
        mapExample.put("10-19:", "");
        mapExample.put("20-29:", "");
        mapExample.put("30-39:", "");
        mapExample.put("40-49:", "");
        mapExample.put("50-59:", "");
        mapExample.put("60-69:", "");
        mapExample.put("70-79:", "");
        mapExample.put("80-89:", "");
        mapExample.put("90-99:", "");
        mapExample.put("100:", "");


    }

}




