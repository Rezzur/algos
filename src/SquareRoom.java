import java.util.*;

public class SquareRoom {
    Scanner sc = new Scanner(System.in);
    int n;
    char[][] room;
    int x, y;

    SquareRoom() {
        n = sc.nextInt();
        room = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                room[i][j] = row.charAt(j);
            }
        }
        x = sc.nextInt();
        y = sc.nextInt();

    }

    int findSquare() {
        int count = 0;
        int startX = x - 1;
        int startY = y - 1;
        ArrayDeque<ArrayList<Integer>> deque = new ArrayDeque<>();
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        ArrayList<Integer> startPos = new ArrayList<>(Arrays.asList(startX, startY));
        deque.addLast(startPos);
        visited.add(startPos);
        while (!deque.isEmpty()) {
            ArrayList<Integer> current = deque.pop();
            int curX = current.get(0);
            int curY = current.get(1);
            if(room[curX][curY]=='.'){
                count+=1;
            }
            if (room[curX + 1][curY] == '.') {
                ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(curX + 1, curY));
                if (!visited.contains(temp)) {
                    deque.addLast(temp);
                    visited.add(temp);
                }
            }
            if (room[curX - 1][curY] == '.') {
                ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(curX - 1, curY));
                if (!visited.contains(temp)) {
                    deque.addLast(temp);
                    visited.add(temp);
                }
            }
            if (room[curX][curY + 1] == '.') {
                ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(curX, curY + 1));
                if (!visited.contains(temp)) {
                    deque.addLast(temp);
                    visited.add(temp);
                }
            }
            if (room[curX][curY - 1] == '.') {
                ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(curX, curY - 1));
                if (!visited.contains(temp)) {
                    deque.addLast(temp);
                    visited.add(temp);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SquareRoom s = new SquareRoom();
        System.out.println(s.findSquare());
    }
}


