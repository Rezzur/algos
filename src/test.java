import java.util.ArrayList;

public class test {
    int sum(int[] num, int index) {
        if (index == num.length) {
            return 0;
        } else {
            return num[index]+sum(num,index+1);
        }
    }
    int count(int[] arr, int count){
        if(count == arr.length){
            return count;
        }else{
            return count(arr, count+1);
        }
    }
    int max(int[] arr, int comparison, int count){
        if(count!=arr.length-1) {
            if (comparison < arr[count]) {
                return max(arr, arr[count], count + 1);
            }else{
                return max(arr, comparison, count+1);
            }
        }
        if(arr[arr.length-1]>comparison){
            return arr[arr.length-1];
        }else {
            return comparison;
        }
    }
    public static void main(String[] args) {
        int[] testArr = new int[]{1, 2, 33, 12, 4, 55, 23, 112, 42, 444};
        test test = new test();
        System.out.println(test.sum(testArr, 0));
        System.out.println(test.count(testArr, 0));
        System.out.println(test.max(testArr, Integer.MIN_VALUE,0));
    }
}