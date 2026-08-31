import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int totalCount = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        for (int i = 1; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if(seen.containsKey(temp)){
                start = Math.max(seen.get(temp)+1, start);
            }
            seen.put(temp, i);
            totalCount = Math.max(totalCount, i - start+1);
        }
        return totalCount;
    }

    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();

        System.out.println(l.lengthOfLongestSubstring("mq"));
    }
}
