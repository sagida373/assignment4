import java.util.*;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        vertices.add(source);
        vertices.add(destination);
        source.addAdjacentVertex(destination, weight);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
