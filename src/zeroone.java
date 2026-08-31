import java.util.Scanner;

public class zeroone {
    void find(){
        long end0 = 1;
        long end1 = 0;
        long end11 = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            long newEnd0 = end0+end1+end11;
            long newEnd1 = end0;
            long newEnd11 = end1;

            end0 = newEnd0;
            end1 = newEnd1;
            end11 = newEnd11;
        }
        long answer = end0+end1+end11;
        System.out.println(answer);
    }

    public static void main(String[] args) {
        zeroone zo = new zeroone();
        zo.find();
    }
}
