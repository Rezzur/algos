import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class minOnOtrezok {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    int[] arr = new int[n];
    ArrayList<Integer> findMin() {
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayDeque deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>(n-k+1);
            for (int j = 0; j < n-k+1; j++) {
                result.add((Math.min(arr[j],Math.min(arr[j+1], arr[j+2]))));
            }
        return result;
    }

    public static void main(String[] args) {
        minOnOtrezok m = new minOnOtrezok();
        ArrayList<Integer> arr = m.findMin();
        for(int i = 0;i<m.n-m.k+1;i++){
            System.out.println(arr.get(i));
        }
    }
}
