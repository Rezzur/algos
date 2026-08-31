import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CosmoBot {
    HashMap<Character, String> rule = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Character s;
    int par;
    long[][] dp;
    Character[] arr = new Character[]{'N','S','W', 'E','U','D'};
    HashMap<Character, Integer> idx = new HashMap<>();

    CosmoBot() {
        rule.put('N', sc.nextLine());
        rule.put('S', sc.nextLine());
        rule.put('W', sc.nextLine());
        rule.put('E', sc.nextLine());
        rule.put('U', sc.nextLine());
        rule.put('D', sc.nextLine());

        idx.put('N', 0);
        idx.put('S', 1);
        idx.put('W', 2);
        idx.put('E', 3);
        idx.put('U', 4);
        idx.put('D', 5);

        s = sc.next().charAt(0);
        par = sc.nextInt();
        dp = new long[6][par+1];
    }
    void printTable() {
        System.out.println("\n--- Таблица DP ---");

        // Заголовок столбцов (значения параметра k)
        System.out.printf("%-5s", "Dir");
        for (int k = 1; k <= par; k++) {
            System.out.printf("%-10s", "k=" + k);
        }
        System.out.println();

        // Строки с направлениями и их значениями
        for (int d = 0; d < 6; d++) {
            System.out.printf("%-5c", arr[d]);
            for (int k = 1; k <= par; k++) {
                System.out.printf("%-10d", dp[d][k]);
            }
            System.out.println();
        }
        System.out.println("------------------\n");
    }
    int count = 0;
    long countMotions(Character s, int par){
        for(int i = 1; i<=par; i++){
            for(int d = 0; d<6; d++){
                if(i==1){
                    dp[d][i]=1;
                }
                if(i>1){
                    dp[d][i] = 1;
                    String cur = rule.get(arr[d]);
                    for(int j = 0; j<cur.length();j++){
                        dp[d][i]+=dp[idx.get(cur.charAt(j))][i-1];
                    }
                }

            }
        }
        return (long) dp[idx.get(s)][par];
    }

    public static void main(String[] args) {
        CosmoBot c = new CosmoBot();
        System.out.println(c.countMotions(c.s, c.par));

    }
}
