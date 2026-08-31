import java.util.ArrayList;
import java.util.Scanner;

public class Levenshtein {
    //ABCDEFGH
    //ACDEXGIH
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int count = 0;
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i = 0; i<s1.length();i++){
           list1.add(s1.charAt(i));
        }
        for(int i = 0; i<s2.length();i++){
            list2.add(s2.charAt(i));
        }
        for(int i = 0; i<s1.length();i++){
            if(list2.contains(list1.get(i))){
                count+=1;
            }
        }
        int result = s1.length()-count;
        System.out.println(count);
    }
}
