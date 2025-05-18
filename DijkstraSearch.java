import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    private Map<Vertex<V>, Double> distances = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

    public DijkstraSearch(Vertex<V> start, Vertex<V> end) {
        super(start, end);
        dijkstra(start);
    }

    private void dijkstra(Vertex<V> source) {
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        distances.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double newDist = distances.get(current) + entry.getValue();
                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath() {
        LinkedList<Vertex<V>> path = new LinkedList<>();
        if (!previous.containsKey(end)) return path;

        for (Vertex<V> at = end; at != null; at = previous.get(at)) {
            path.addFirst(at);
        }
        return path;
    }

    public double getDistance() {
        return distances.getOrDefault(end, Double.POSITIVE_INFINITY);
    }
}
