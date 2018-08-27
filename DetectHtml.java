import java.util.*;
import java.util.regex.*;

public class DetectHtml {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) 
    { 
        int N = scanner.nextInt();                
        String regex = "<\\s*([a-z][a-z0-9]*)[^>]*>";
        Pattern pat = Pattern.compile(regex);
       
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            String s = scanner.nextLine();
            Matcher mat = pat.matcher(s);
            while (mat.find()) {
                list.add(mat.group(1));
            }
        }

        Collections.sort(list);
       for(String i: list)
       {
            System.out.print(i + ";");
       }
    }
}