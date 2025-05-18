import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private Set<Vertex<V>> marked = new HashSet<>();

    public BreadthFirstSearch(Vertex<V> start, Vertex<V> end) {
        super(start, end);
        bfs(start);
    }

    private void bfs(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        marked.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current.equals(end)) return;

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath() {
        LinkedList<Vertex<V>> path = new LinkedList<>();
        if (!marked.contains(end)) return path;

        for (Vertex<V> x = end; !x.equals(start); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
