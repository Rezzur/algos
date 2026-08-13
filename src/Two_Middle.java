import java.util.Scanner;

public class Two_Middle {
    Scanner sc = new Scanner(System.in);
    int[][] matrix;
    int N = sc.nextInt(), M = sc.nextInt();
    public Two_Middle(){
        matrix = new int[N][M];
        for(int i = 0; i<N; i++){
            for(int j = 0;j<M;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    int findMin(){
        int[][] result = new int[N][M];
        result[0][0] = matrix[0][0];
        for(int i = 1; i<N; i++){
            result[i][0] = matrix[i][0]+result[i-1][0];
        }
        for(int i = 1; i<M; i++){
            result[0][i] = matrix[0][i]+result[0][i-1];
        }
        for(int i = 1; i<N; i++) {
            for (int j = 1; j < M; j++) {
                result[i][j] = matrix[i][j]+Math.min(result[i-1][j], result[i][j-1]);
            }
        }
        return result[N-1][M-1];
    }
    public static void main(String[] args){
        Two_Middle  tm = new Two_Middle();

        System.out.println(tm.findMin());
    }

}
