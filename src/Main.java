import java.util.Scanner;

class Main{
    String find(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        String[] s2 = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = sc.next();
            s2[i] = sc.next();
        }
        String target = sc.next();
        for(int i = 0; i < n; i++){
            if((s[i].trim()).equals(target)){
                return s2[i];
            }
            if ((s2[i].trim()).equals(target)) {
                return s[i];
            }
        }
        return "none";
    }

    public static void main() {
        Main ms = new Main();
        System.out.println(ms.find());
    }
}