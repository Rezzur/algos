import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeRun {
    int count(int n){
        int countTrinagles = 1;
         for(int i=0;i<n;i++){
             countTrinagles+=countTrinagles+1;
        }
        return countTrinagles;
    }

    public static void main(String[] args) {
        CodeRun cr = new CodeRun();
        System.out.println(cr.count(4));
    }
}
