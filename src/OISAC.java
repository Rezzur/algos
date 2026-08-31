import java.util.*;

public class OISAC {
    Scanner sc = new Scanner(System.in);
    float procent = 5;
    float p;
    int n;
    PriorityQueue<Integer> arr = new PriorityQueue<>();

    OISAC() {
        p = procent / 100;
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
    }

    double findProfitDeal() {
        double totalCost = 0.0;
        while (arr.size() > 1) {
            long a = arr.poll(); // наименьший элемент
            long b = arr.poll(); // второй наименьший элемент

            long sum = a + b;
            totalCost += sum * 0.05; // 5% от суммы операции

            arr.add((int) sum);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        OISAC o = new OISAC();
        System.out.printf(java.util.Locale.US, "%.2f\n", o.findProfitDeal());
    }
}
