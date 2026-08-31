import java.util.*;

public class NVP {
    int n;
    ArrayList<Integer> input;
    int[] result;
    Scanner sc = new Scanner(System.in);

    NVP() {
        n = sc.nextInt();
        input = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            input.add(sc.nextInt());
        }
        result = new int[n];
        Arrays.fill(result, 1);
    }

    ArrayList<Integer> findNVP() {
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (input.get(j) < input.get(i) && result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int maxLen = 0;
        int bestEndIdx = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] > maxLen) {
                maxLen = result[i];
                bestEndIdx = i;
            }
        }
            ArrayList<Integer> answer = new ArrayList<>();
            int curr = bestEndIdx;
            while (curr != -1) {
                answer.add(input.get(curr));
                curr = prev[curr];
            }
            Collections.reverse(answer);
            return answer;
    }

    public static void main(String[] args) {
        NVP n = new NVP();
        String s = "";
        for(int i :n.findNVP()){
            s+=i+" ";
        }
        System.out.println(s.trim());
    }
}
