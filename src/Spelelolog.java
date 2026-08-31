import java.lang.reflect.Array;
import java.util.*;

public class Spelelolog {
    Scanner sc = new Scanner(System.in);
    int n, startZ = 0, startX = 0, startY = 0;
    char[][][] map;
    Spelelolog() {
        n = sc.nextInt();
        map = new char[n][n][n];
        for (int z = 0; z < n; z++) {
            for (int x = 0; x < n; x++) {
                String row = sc.next();
                for (int y = 0; y < n; y++) {
                    map[z][x][y] = row.charAt(y);
                    if (map[z][x][y] == 'S') {
                        startZ = z;
                        startX = x;
                        startY = y;
                    }
                }
            }
        }
    }

    ArrayList<ArrayList<Integer>> nextMotions(int o, int x, int y) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        if(x+1<n) if (map[o][x+1][y]=='.') arr.add(new ArrayList<>(Arrays.asList(o, x + 1, y)));
        if(x-1>=0) if (map[o][x-1][y]=='.') arr.add(new ArrayList<>(Arrays.asList(o, x - 1, y)));
        if(y+1<n) if (map[o][x][y+1]=='.') arr.add(new ArrayList<>(Arrays.asList(o, x, y + 1)));
        if(y-1>=0) if (map[o][x][y-1]=='.') arr.add(new ArrayList<>(Arrays.asList(o, x, y - 1)));
        if(o+1<n) if (map[o+1][x][y]=='.') arr.add(new ArrayList<>(Arrays.asList(o + 1, x, y)));
        if(o-1>=0) if (map[o-1][x][y]=='.') arr.add(new ArrayList<>(Arrays.asList(o - 1, x, y)));
        return arr;
    }

    int findExit() {
        ArrayDeque<ArrayList<Integer>> deque = new ArrayDeque();
        int[][][] dist = new int[n][n][n]; //Незабудь краевый случай
        for (int z = 0; z < n; z++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    dist[z][x][y] = -1;
                }
            }
        }
        ArrayList<Integer> starts = new ArrayList<>(Arrays.asList(startZ, startX, startY));
        deque.addLast(starts);
        dist[startZ][startX][startY] = 0;
        if(startZ==0){
            return 0;
        }
        while (!deque.isEmpty()) {
            ArrayList<Integer> current = deque.pop();
            for (ArrayList<Integer> nextMotion : nextMotions(current.get(0), current.get(1), current.get(2))) {
                if (dist[nextMotion.get(0)][nextMotion.get(1)][nextMotion.get(2)]==-1) {
                    if (nextMotion.get(0) == 0) {
                        return dist[current.get(0)][current.get(1)][current.get(2)]+1;
                    }
                    deque.addLast(nextMotion);
                    dist[nextMotion.get(0)][nextMotion.get(1)][nextMotion.get(2)] = dist[current.get(0)][current.get(1)][current.get(2)]+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Spelelolog s = new Spelelolog();
        System.out.println(s.findExit());
    }
}
