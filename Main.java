public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 1);
        graph.addEdge(b, c, 2);
        graph.addEdge(a, c, 4);
        graph.addEdge(c, d, 1);

        Search<String> bfs = new BreadthFirstSearch<>(a, d);
        System.out.println("BFS path: " + bfs.getPath());

        Search<String> dijkstra = new DijkstraSearch<>(a, d);
        System.out.println("Dijkstra path: " + dijkstra.getPath());
        System.out.println("Total cost: " + ((DijkstraSearch<String>) dijkstra).getDistance());
    }
}
