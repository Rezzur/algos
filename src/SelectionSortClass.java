import java.lang.ref.SoftReference;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SelectionSortClass {
    int findSmallest(List<Integer> list) {
        int temp = Integer.MAX_VALUE, ind = 0;
        for (int i = 0; i <= list.size() - 1; i++) {
            if (list.get(i) < temp) {
                temp = list.get(i);
                ind = i;
            }
        }
        return ind;
    }

    List<Integer> selectionSort(List<Integer> list) {
        ArrayList<Integer> SortedArr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(list);
        int size = temp.size() - 1;
        for (int i = 0; i <= size; i++) {
            int tmp = findSmallest(temp);
            SortedArr.add(temp.get(tmp));
            temp.remove(tmp);
        }
        return SortedArr;
    }

    public static void main(String[] args) {
        SelectionSortClass SSC = new SelectionSortClass();
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(9, 8, 4, 4, 4, 2, 2, 1, 6, 5, 7, 3, 2, 1));
        System.out.println(SSC.selectionSort(list));

    }
}
