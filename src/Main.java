import java.util.*;

class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(String u, String v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public void dfs(String node, Set<String> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (String neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");

            for (String neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("B", "G");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");
        graph.addEdge("E", "F");
        graph.addEdge("E", "G");
        graph.addEdge("F", "G");
        graph.addEdge("G", "B");

        System.out.println("DFS:");
        graph.dfs("A", new HashSet<>());
        System.out.println("\nBFS:");
        graph.bfs("A");
    }
}
