import java.util.HashSet;
import java.util.Scanner;

public class countWords {
    int couuntWord(){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        HashSet<String> visited = new HashSet<>();
        while(sc.hasNext()){
            String value = sc.next();
            if(!visited.contains(value)) {
                if (value.equals("stop")) break;
                count++;
            }
            visited.add(value);

        }
        return count;
    }

    public static void main(String[] args) {
        countWords cw = new countWords();
        System.out.println(cw.couuntWord());
    }
}
