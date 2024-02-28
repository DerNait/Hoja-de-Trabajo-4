package src;
import java.io.*;
import java.util.ArrayList;

public class Reader {
    /**
     * The function `readExpression` reads expressions from a file and stores them in an ArrayList.
     * 
     * @param name The `name` parameter in the `readExpression` method is the name of the file that you
     * want to read expressions from. This method reads the contents of the file line by line and
     * stores each line as a string in an ArrayList.
     * @return An ArrayList of Strings containing the expressions read from the file with the given
     * name.
     */
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