import java.net.SecureCacheResponse;
import java.util.*;

public class nums {
    int firstAction(int num) {
        if (num < 9000) {
            return num += 1000;
        }
        return num;
    }

    int secondAction(int num) {
        if (num % 10 > 1) {
            return num - 1;
        }
        return num;
    }

    // 1234 → 4123
    int thirdAction(int num) {
        return (num % 10) * 1000 + num / 10;
    }

    // 1234 → 2341
    int fourthAction(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    ArrayList<Integer> func(int start, int target) {
        Deque<Integer> deque = new ArrayDeque();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> parents = new HashMap<>();
        boolean flag = false;
        if (start == target) {
            flag = true;
        }
        deque.addLast(start);
        parents.put(start, -1);
        visited.add(start);
        while (!deque.isEmpty()) {
            int current = deque.poll();
            if (current == target) {
                flag = true;
                break;
            }
            int[] nextNums = new int[]{
                    firstAction(current),
                    secondAction(current),
                    thirdAction(current),
                    fourthAction(current)
            };
            for (int next : nextNums) {
                if (!visited.contains(next)) {
                    deque.addLast(next);
                    visited.add(next);
                    parents.put(next, current);

                }
            }

        }
        if (flag) {
            int current = target;
            ArrayList<Integer> path = new ArrayList<>();
            while (current != -1) {
                path.add(current);
                current = parents.get(current);
            }

            Collections.reverse(path);
            return path;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        nums n = new nums();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int target = sc.nextInt();
        ArrayList<Integer> result = n.func(start, target);
        for(int k :result){
            System.out.println(k);
        }


    }
}
