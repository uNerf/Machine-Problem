import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MP8_20<T> {
    final private HashMap<T, Set<T>> adjacencyList;

    public MP8_20() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(T v) {
        if (this.adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex already exists.");
        }
        this.adjacencyList.put(v, new HashSet<T>());
    }

    public void removeVertex(T v) {
        if (!this.adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }

        this.adjacencyList.remove(v);

        for (T u: this.getAllVertices()) {
            this.adjacencyList.get(u).remove(v);
        }
    }

    public void addEdge(T v, T u) {
        if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyList.get(v).add(u);
        this.adjacencyList.get(u).add(v);
    }

    public void removeEdge(T v, T u) {
        if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyList.get(v).remove(u);
        this.adjacencyList.get(u).remove(v);
    }

    public boolean isAdjacent(T v, T u) {
        return this.adjacencyList.get(v).contains(u);
    }

    public Iterable<T> getNeighbors(T v) {
        return this.adjacencyList.get(v);
    }

    public Iterable<T> getAllVertices() {
        return this.adjacencyList.keySet();
    }
    public void adjList(){
        for(T s : this.getAllVertices()){
            System.out.println(s +" = "+this.adjacencyList.get(s));
        }
    }
    public void BFS(){
        for(T s : this.getAllVertices()){

        }
    }
    public void BFSv(T v){

    }

    public static void main(String[] args) {
        MP8_20 graph = new MP8_20();

        graph.addVertex("LA");
        graph.addVertex("VN");
        graph.addVertex("MM");
        graph.addVertex("KH");
        graph.addVertex("TH");
        graph.addVertex("MY");
        graph.addVertex("SG");
        graph.addVertex("ID");
        graph.addVertex("BN");
        graph.addVertex("PH");

        graph.addEdge("LA", "VN");
        graph.addEdge("LA", "KH");
        graph.addEdge("LA", "TH");
        graph.addEdge("LA", "MM");
        graph.addEdge("VN", "KH");
        graph.addEdge("KH", "TH");
        graph.addEdge("TH", "MM");
        graph.addEdge("TH", "MY");
        graph.addEdge("MY", "SG");
        graph.addEdge("MY", "ID");
        graph.addEdge("LA", "BN");

        graph.adjList();

    }
}