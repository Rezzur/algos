
import java.util.ArrayList;
import java.util.Scanner;

public class CodeRun {
    int N;
    int M;
    int[][] matrix;
    Scanner sc = new Scanner(System.in);
    ArrayList<String> path = new ArrayList<>();

    CodeRun() {
        this.N = sc.nextInt();
        this.M = sc.nextInt();
        matrix = new int[N][M];
        for (int i = 0; i <= N - 1; i++) {
            for (int j = 0; j <= M - 1; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }


    int findMax() {
        int[][] temp = new int[N][M];
        temp[0][0] = matrix[0][0];
        for (int j = 1; j < M; j++) {
            temp[0][j] = temp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < N; i++) {
            temp[i][0] = temp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 1; j++) {
                int choice = Math.max(temp[i - 1][j], temp[i][j - 1]);
                temp[i][j] += matrix[i][j] + choice;
            }
        }
        int i = N - 1;
        int j = M - 1;
        while (i > 0 || j > 0){
            if (i == 0) {
                path.addFirst("R");
                j--;
                continue;
            }

            if (j == 0) {
                path.addFirst("D");
                i--;
                continue;
            }
            if (temp[i - 1][j] > temp[i][j - 1]) {
                path.addFirst("D");
                i--;
            } else {
                path.addFirst("R");
                j--;
            }
        }

        return temp[N - 1][M - 1];
    }

    public static void main(String[] args) {
        CodeRun cr = new CodeRun();
        System.out.println(cr.findMax());
        String result ="";
        for(String s : cr.path){
            result += s+" ";
        }
        System.out.println(result.trim());
    }
}
