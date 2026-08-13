import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int pointerLeft = 0; pointerLeft<=nums.length-1; pointerLeft++) {
            int need = target - nums[pointerLeft];
            if(map.containsKey(need)){
                return new int[]{map.get(need), pointerLeft};
            }
            map.put(nums[pointerLeft], pointerLeft);
        }
    return new int[]{0,0};
    }


    static void main() {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,4};
        System.out.println(solution.twoSum(nums,6)[0]+", "+solution.twoSum(nums,6)[1]);
    }
}
