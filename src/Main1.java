import java.util.Scanner;

public class Main1 {
    int N, M;
    int[][] matrix;
    Scanner sc = new Scanner(System.in);
    public Main1(){
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[N][M];
    }
    int countHorse(){
        matrix[0][0] = 1;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(i>=2 && j>=2){
                    matrix[i][j] = matrix[i-2][j-1]+matrix[i-1][j-2];
                }
                if(i==1 && j>=2){
                    matrix[i][j] = matrix[i-1][j-2];
                }
                if(j==1 && i>=2){
                    matrix[i][j] = matrix[i-2][j-1];
                }

            }
        }
        if(matrix[N-1][M-1]!=0){
            return matrix[N-1][M-1];
        }
        return 0;
    }

    static void main(String[] args){
        Main1 four = new Main1();
        System.out.println(four.countHorse());
    }
}
