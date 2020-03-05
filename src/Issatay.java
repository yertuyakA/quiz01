import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Issatay {

    public static void main(String[] args)/*L15*/ {
            Scanner file = null;
            HashMap<String,String> range = new HashMap<>();
            range.put("00-09","");
            range.put("10-19","");
            range.put("20-29","");
            range.put("30-39","");
            range.put("40-49","");
            range.put("50-59","");
            range.put("60-69","");
            range.put("70-79","");
            range.put("80-89","");
            range.put("90-99","");
            range.put("100","");




            try{
                file = new Scanner(new FileReader("C:\\Users\\Issatai\\IdeaProjects\\Text2\\src\\com\\company\\Range.txt"));
            }
            catch (FileNotFoundException f){
                f.printStackTrace();
            }
            while(file.hasNext()){
                int n =file.nextInt();
                if(n>0 && n<9){
                    String d = range.get("00-09");
                    d = d+"*";
                    range.put("00-09",d);
                }
                else if(n>10 && n<19){
                    String d = range.get("10-19");
                    d = d+"*";
                    range.put("10-19",d);
                }
                else if(n>20 && n<29){
                    String d = range.get("20-29");
                    d = d+"*";
                    range.put("20-29",d);
                }
                else if(n>30 && n<39){
                    String d = range.get("30-39");
                    d = d+"*";
                    range.put("30-39",d);
                }
                else if(n>40 && n<49){
                    String d = range.get("40-49");
                    d = d+"*";
                    range.put("40-49",d);
                }
                else if(n>50 && n<59){
                    String d = range.get("50-59");
                    d = d+"*";
                    range.put("50-59",d);
                }
                else if(n>60 && n<69){
                    String d = range.get("60-69");
                    d = d+"*";
                    range.put("60-69",d);
                }
                else if(n>70 && n<79){
                    String d = range.get("70-79");
                    d = d+"*";
                    range.put("70-79",d);
                }
                else if(n>80 && n<89){
                    String d = range.get("80-89");
                    d = d+"*";
                    range.put("80-89",d);
                }
                else if(n>90 && n<99){
                    String d = range.get("90-99");
                    d = d+"*";
                    range.put("90-99",d);
                }
                else if(n==100){
                    String d = range.get("100");
                    d = d+"*";
                    range.put("100",d);
                }


            }
            for(Map.Entry<String,String>entry:range.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }


        }


    }


