import java.util.*;

public class Fleas {
    Scanner sc = new Scanner(System.in);
    int n;
    int m;
    int s;
    int t;
    int q;
    int[][] qCoordinates;

    Fleas() {
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();
        q = sc.nextInt();
        qCoordinates = new int[q][2];
        for (int i = 0; i < q; i++) {
            qCoordinates[i][0] = sc.nextInt();
            qCoordinates[i][1] = sc.nextInt();
        }
    }

    ArrayList<int[]> motion(int[] coor) {
        int x = coor[0];
        int y = coor[1];
        ArrayList<int[]> canMotion = new ArrayList<>();

        // ИЗМЕНЕНО: убрано общее внешнее условие if(x + 2 < n && y + 2 < m),
        // а границы приведены к 1-based индексации (от 1 до n и от 1 до m)
        if (x - 2 >= 1 && y + 1 <= m) {
            canMotion.add(new int[]{x - 2, y + 1});
        }
        if (x - 2 >= 1 && y - 1 >= 1) {
            canMotion.add(new int[]{x - 2, y - 1});
        }
        if (x + 2 <= n && y + 1 <= m) {
            canMotion.add(new int[]{x + 2, y + 1});
        }
        if (x + 2 <= n && y - 1 >= 1) {
            canMotion.add(new int[]{x + 2, y - 1});
        }

        if (x + 1 <= n && y + 2 <= m) {
            canMotion.add(new int[]{x + 1, y + 2});
        }
        if (x + 1 <= n && y - 2 >= 1) {
            canMotion.add(new int[]{x + 1, y - 2});
        }
        if (x - 1 >= 1 && y + 2 <= m) {
            canMotion.add(new int[]{x - 1, y + 2});
        }
        if (x - 1 >= 1 && y - 2 >= 1) {
            canMotion.add(new int[]{x - 1, y - 2});
        }

        return canMotion;
    }

    // ИЗМЕНЕНО: тип возвращаемого значения изменен на long во избежание переполнения
    long sumPath() {
        long count = 0; // ИЗМЕНЕНО: счетчик типа long

        for (int[] fleas : qCoordinates) {
            // ДОБАВЛЕНО: проверка случая, когда блоха изначально в кормушке
            if (fleas[0] == s && fleas[1] == t) {
                continue;
            }

            // ИЗМЕНЕНО: очередь создается заново для каждой блохи
            ArrayDeque<int[]> deque = new ArrayDeque<>();

            // ИЗМЕНЕНО: вместо HashSet/HashMap используется массив dist для корректного сравнения и учета уровней
            int[][] dist = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dist[i], -1);
            }

            deque.addLast(fleas);
            dist[fleas[0]][fleas[1]] = 0; // ИЗМЕНЕНО: установка начального расстояния

            boolean reached = false; // ДОБАВЛЕНО: флаг достижения цели

            while (!deque.isEmpty()) {
                int[] current = deque.pop();

                // ДОБАВЛЕНО: условие остановки всего поиска при нахождении кормушки
                if (current[0] == s && current[1] == t) {
                    count += dist[current[0]][current[1]];
                    reached = true;
                    break;
                }

                ArrayList<int[]> arr = motion(current);
                for (int[] nextMotion : arr) {
                    // ИЗМЕНЕНО: проверка посещения через массив dist вместо contains
                    if (dist[nextMotion[0]][nextMotion[1]] == -1) {
                        dist[nextMotion[0]][nextMotion[1]] = dist[current[0]][current[1]] + 1;
                        deque.addLast(nextMotion);
                    }
                }
            }

            // ДОБАВЛЕНО: если кормушка недостижима хотя бы для одной блохи
            if (!reached) {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Fleas f = new Fleas();
        System.out.println(f.sumPath());
    }
}