import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class good {
    int result = 0;
    void goodnest() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> alphabet = new HashMap<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            alphabet.put(arr.get(i), sc.nextInt());
        }
        for (int i = 0; i < N-1; i++) {
            result += Math.min(alphabet.get(arr.get(i)), alphabet.get(arr.get(i+1)));
        }
    }
    public static void main(String[] args) {
        good good = new good();
        good.goodnest();
        System.out.println(good.result);
    }
}
