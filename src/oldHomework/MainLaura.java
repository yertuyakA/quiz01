package oldHomework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MainLaura {

    public static void main(String[] args) {
        Scanner file = null;
        try {
            file = new Scanner(new FileReader("C:\\Users\\Laura_Zhumakanova\\IdeaProjects\\quiz01\\src\\oldHomework\\scores.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<String,String> map = new HashMap<>();
        map.put("00-09","");
        map.put("10-19","");
        map.put("20-29","");
        map.put("30-39","");
        map.put("40-49","");
        map.put("50-59","");
        map.put("60-69","");
        map.put("70-79","");
        map.put("80-89","");
        map.put("90-99","");
        map.put("100","");

        while(file.hasNext()){
            int d = file.nextInt();
            if (d>=0 && d<=9) {
                String n = map.get("00-09");
                n = n+"*";
                map.put("00-09",n);

            } else if (d>=10 && d<=19) {
                String n = map.get("10-19");
                n = n+"*";
                map.put("10-19",n);
            } else if (d>=20 && d<=29) {
                String n = map.get("20-29");
                n = n+"*";
                map.put("20-29",n);
            } else if (d>=30 && d<=39) {
                String n = map.get("30-39");
                n = n+"*";
                map.put("30-39",n);
            } else if (d>=40 && d<=49) {
                String n = map.get("40-49");
                n = n+"*";
                map.put("40-49",n);
            } else if (d>=50 && d<=59) {
                String n = map.get("50-59");
                n = n+"*";
                map.put("50-59",n);
            } else if (d>=60 && d<=69) {
                String n = map.get("60-69");
                n = n+"*";
                map.put("60-69",n);
            } else if (d>=70 && d<=79) {
                String n = map.get("70-79");
                n = n+"*";
                map.put("70-79",n);
            } else if (d>=80 && d<=89) {
                String n = map.get("80-89");
                n = n+"*";
                map.put("80-89",n);
            } else if (d>=90 && d<=99) {
                String n = map.get("90-99");
                n = n+"*";
                map.put("90-99",n);
            } else if (d==100) {
                String n = map.get("100");
                n = n+"*";
                map.put("100",n);
            }
        }

        for(Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": "+ entry.getValue());
        }
    }

}
