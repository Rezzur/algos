import java.util.*;

public class Grapghs {

    boolean BFS(HashMap<String, ArrayList<String>> map, String start, String target) {
        Queue<String> queue = new ArrayDeque();
        Set<String> visited = new HashSet<>();
        if (start.equals(target)) {
            return true;
        }
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            ArrayList<String> rooms = map.get(queue.poll());
            if (rooms == null) {
                continue;
            }

            for (String room : rooms) {
                if (!visited.contains(room)) {
                    if (room.equals(target)) {
                        return true;
                    } else {
                        visited.add(room);
                        queue.add(room);
                    }
                }
            }

        }
        return false;
    }

    boolean BFS_r(
            HashMap<String, ArrayList<String>> graph,
            String start,
            String target
    ) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        return BFS_r1(graph, target, queue, visited);
    }

    boolean BFS_r1(
            HashMap<String, ArrayList<String>> graph,
            String target,
            Queue<String> queue,
            Set<String> visited
    ) {
        if (queue.isEmpty()) {
            return false;
        }

        String current = queue.poll();

        if (current.equals(target)) {
            return true;
        }

        ArrayList<String> neighbors = graph.get(current);

        if (neighbors != null) {
            for (String neighbor : neighbors) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return BFS_r1(graph, target, queue, visited);
    }

    boolean DFS_r(HashMap<String, ArrayList<String>> grapgh, String start, String target, HashSet<String> visited) {
        if (start.equals(target)) {
            return true;
        }
        if (visited.contains(start)) {
            return false;
        }
        visited.add(start);
        ArrayList<String> neighbors = grapgh.get(start);
        if (neighbors == null) {
            return false;
        }
        for (String neighbor : neighbors) {
            if (DFS_r(grapgh, neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        graph.put("A", new ArrayList<>(
                Arrays.asList("B", "C", "D")));

        graph.put("B", new ArrayList<>(
                Arrays.asList("A", "E", "F")));

        graph.put("C", new ArrayList<>(
                Arrays.asList("A", "F", "G")));

        graph.put("D", new ArrayList<>(
                Arrays.asList("A", "G")));

        graph.put("E", new ArrayList<>(
                Arrays.asList("B", "H")));

        graph.put("F", new ArrayList<>(
                Arrays.asList("B", "C", "H", "I")));

        graph.put("G", new ArrayList<>(
                Arrays.asList("C", "D", "I")));

        graph.put("H", new ArrayList<>(
                Arrays.asList("E", "F", "J")));

        graph.put("I", new ArrayList<>(
                Arrays.asList("F", "G", "J")));

        graph.put("J", new ArrayList<>(
                Arrays.asList("H", "I")));
        Grapghs g = new Grapghs();
        System.out.println(g.BFS(graph, "A", "J"));
        System.out.println(g.DFS_r(graph, "A", "J", new HashSet<>()));
        System.out.println(g.BFS_r(graph, "A", "J"));
    }
}
