import java.util.*;

public class BFS {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[]distance = new int[N];
    int[][] matrix = new int[N][N];
    int start_pos;
    int target;
    BFS() {
        for (int i = 0; i <= N - 1; i++) {
            for (int j = 0; j <= N - 1; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        start_pos = sc.nextInt()-1;
        target = sc.nextInt()-1;
    }

    int bfs(int[][] matrix){
        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new  ArrayDeque<>();
        if(start_pos == target){
            return 0;
        }
        queue.add(start_pos);
        visited.add(start_pos);
        int z = 0;

        while(!queue.isEmpty()){
            int zeroes = 0;
            int current = queue.poll();
            for(int i = 0;i<=N-1; i++){
                if(matrix[current][i]==1){
                    if(!visited.contains(i)){
                        visited.add(i);
                        queue.add(i);
                        distance[i] = distance[current]+1;

                        z++;
                    }
                    if(i==target){
                        return distance[target];
                    }
                }
            }
        }

    return -1;
    }

    public static void main(String[] args) {
        BFS m = new BFS();
        System.out.println(m.bfs(m.matrix));


    }
}