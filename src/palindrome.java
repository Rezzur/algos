public class palindrome {
    public boolean isPalindrome(int x) {
        String sX = Integer.toString(x);
        String reverse = "";
        for (int i = 0; i < sX.length(); i++) {
            reverse = reverse + sX.charAt(sX.length()-1-i);
        }
        System.out.println(reverse);
        return reverse.equals(sX);
    }

    public static void main(String[] args) {
        palindrome p = new palindrome();
        System.out.println(p.isPalindrome(10));
    }
}
