public class reverseInt {
    public int reverse(int x) {
        if(x>Integer.MAX_VALUE-1 || x<Integer.MIN_VALUE){
            return 0;
        }
        String sX = Integer.toString(x);
        String result = "";
        int start = 0;
        if(sX.charAt(0)=='-'){
            start = 1;
        }
        for (int i = start; i < sX.length(); i++) {
            result=sX.charAt(i)+result;
        }
        if(start==1){
            result="-"+result;
        }
        int res;
        try{
            res = Integer.parseInt(result);
        }catch (NumberFormatException e){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        reverseInt r = new reverseInt();
        System.out.println(r.reverse(1534236469));
    }
}
