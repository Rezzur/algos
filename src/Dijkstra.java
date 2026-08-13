import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;


public class Dijkstra {

    String findLowest(HashMap<String, Integer> costs, HashSet<String> visited) {
        int inf = Integer.MAX_VALUE;
        String lowestNode = null;
        for (String value : costs.keySet()) {
            if (costs.get(value) < inf && !visited.contains(value)) {
                inf = costs.get(value);
                lowestNode = value;
            }
        }
        return lowestNode;
    }

    int dijkstra(
            HashMap<String, HashMap<String, Integer>> graph,
            HashMap<String, Integer> costs,
            HashMap<String, String> parents,
            String target
    ) {
        HashSet<String> visited = new HashSet<>();
        String node = findLowest(costs, visited);
        String start = node;
        while (node != null) {
            int cost = costs.get(node);

            HashMap<String, Integer> neighbors = graph.get(node);
            if (neighbors != null) {
                for (String neighbor : neighbors.keySet()) {
                    int newCost = cost + neighbors.get(neighbor);
                    if (costs.get(neighbor) > newCost) {
                        costs.put(neighbor, newCost);
                        parents.put(neighbor, node);
                    }
                }
            }
            visited.add(node);
            node = findLowest(costs, visited);
        }
        String current = target;

        Deque<String> path = new ArrayDeque<>();

        while(!current.equals(start)){
            path.addFirst(current);
            path.addFirst("->");
            current = parents.get(current);
        }
        path.addFirst(start);
        System.out.println(path);
        return costs.get(target);
    }
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();

        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

        graph.put("start", new HashMap<>());
        graph.put("a", new HashMap<>());
        graph.put("b", new HashMap<>());
        graph.put("fin", new HashMap<>());

        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);

        graph.get("a").put("fin", 1);

        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);


        HashMap<String, Integer> costs = new HashMap<>();

        costs.put("start", 0);
        costs.put("a", Integer.MAX_VALUE);
        costs.put("b", Integer.MAX_VALUE);
        costs.put("fin", Integer.MAX_VALUE);


        HashMap<String, String> parents = new HashMap<>();


        int result = d.dijkstra(
                graph,
                costs,
                parents,
                "fin"
        );

        System.out.println("Минимальная стоимость: " + result);
        System.out.println("Costs: " + costs);
        System.out.println("Parents: " + parents);
    }
}
