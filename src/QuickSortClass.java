import java.util.Arrays;
import java.util.ArrayList;

public class QuickSortClass {
    public ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }
        int pivot = (int) (Math.random() * arr.size());
        System.out.println(pivot);
        int pivotValue = arr.get(pivot);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int num : arr) {
            if (num > arr.get(pivot)) {
                right.add(num);
            } else if (num < arr.get(pivot)) {
                left.add(num);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(quickSort(left));
        result.add(pivotValue);
        result.addAll(quickSort(right));
        return result;
    }

    public static void main(String[] args) {
        ArrayList testArr = new ArrayList<>(Arrays.asList(1, 2, 33, 12, 4, 55, 23, 112, 42, 444));
        QuickSortClass qs = new QuickSortClass();
        System.out.println(qs.quickSort(testArr));
    }
}
