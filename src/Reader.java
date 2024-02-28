package src;
import java.io.*;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<String> readExpression(String name) throws IOException{
        ArrayList<String> expressions = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(name));
        String line;
        while ((line = br.readLine()) != null){
            expressions.add(line);
        }
        br.close();
        return expressions;
    }
}