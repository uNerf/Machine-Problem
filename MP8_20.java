import java.util.*;

public class MP8_20<T> {
    final private HashMap<T, Vertex<T>> adjacencyList;
    private SortedSet<T> sAl;
    public LinkedHashSet<T> hashSet;
    public List<T> list;
    public int noConnectCom = 0;
    public int x;
    private int count;


    public MP8_20() {
        this.adjacencyList = new HashMap<>();
    }
    public void sorted(){
        sAl = new TreeSet<T>(adjacencyList.keySet());
    }
    public void addVertex(T v) {
        if (this.adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex already exists.");
        }
        this.adjacencyList.put(v, new Vertex<>());
        sorted();
    }

    public void removeVertex(T v) {
        if (!this.adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }
        this.adjacencyList.remove(v);
        for (T u: this.getAllVertices()) {
            this.adjacencyList.get(u).removeNeighbour(v);
        }
        sorted();
    }

    public void addEdge(T v, T u) {
        if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyList.get(v).addNeighbour(u);
        this.adjacencyList.get(u).addNeighbour(v);
        sorted();
    }

    public void removeEdge(T v, T u) {
        if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyList.get(v).removeNeighbour(u);
        this.adjacencyList.get(u).removeNeighbour(v);


    }

    public boolean isAdjacent(T v, T u) {
        return this.adjacencyList.get(v).isNeighbour(u);
    }

    public Iterable<T> getNeighbors(T v) {
        return this.adjacencyList.get(v).getNeighbours();
    }

    public Iterable<T> getAllVertices() {
        return this.adjacencyList.keySet();
    }

    public void print(){
        System.out.println("The Graph:- ");
        for(Map.Entry<T, Vertex<T>> entry : adjacencyList.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            for(T i : entry.getValue())
                System.out.print(i + " ");
            System.out.println();
        }
    }
    public String verticesCCoG(){
        String vertices = "";
        int count = 0;
        for(T u : sAl){
            adjacencyList.get(u).setVisited(false);
        }
        for(T u : sAl){
            hashSet = new LinkedHashSet<T>();
            list = new ArrayList<T>();
            if(!adjacencyList.get(u).isVisited()){
                verticesCC(u);
            }
            if(list.size()==0){continue;}
            else {
                count++;
                vertices += "Component "+count+":"+list.toString()+'\n';
            }
        }
        return vertices;
    }
    public void verticesCC(T r){
        adjacencyList.get(r).setVisited(true);
        if(hashSet.add(r)) list.add(r);
        for(T v : adjacencyList.get(r).getNeighbours()){
            if(!adjacencyList.get(v).isVisited()){
                verticesCC(v);
            }
        }
    }

    public boolean isConnected(){
        depthIsConnected();
        for(T u : sAl){
            if(!adjacencyList.get(u).isVisited()){
                return false;
            }
        }
        return true;
    }
    public void depthIsConnected(){
        x = 0;
        for(T u : sAl){
            adjacencyList.get(u).setVisited(false);
        }
        for(T u : sAl){
            if(x==1)return;
            if(!adjacencyList.get(u).isVisited()){
                depthIS(u);
            }
            x +=1;
        }
    }
    public void depthIS(T r){
        adjacencyList.get(r).setVisited(true);

        for(T v : adjacencyList.get(r).getNeighbours()){
            if(!adjacencyList.get(v).isVisited()){
                depthIS(v);
            }
        }
    }


    public int connectedComponents(){
        for(T u : this.getAllVertices()){
            adjacencyList.get(u).setVisited(false);
        }
        for(T u : this.getAllVertices()){
            if(!adjacencyList.get(u).isVisited()){
                adjacencyList.get(u).setVisited(true);
                noConnectCom += 1;
                depthCC(u);
            }
        }
        return noConnectCom;
    }

    public void depthCC(T u){
        for(T v : adjacencyList.get(u).getNeighbours()){
            if(!adjacencyList.get(v).isVisited()){
                adjacencyList.get(v).setVisited(true);
                depthCC(v);
            }
        }
    }
    public void depthFirst(){
        int c = 0;
        count = 0;
        for(T u : sAl){
            adjacencyList.get(u).setVisited(false);
        }
        for(T u : sAl){
            if(!adjacencyList.get(u).isVisited()){
                c++;
                System.out.println("[Tree "+c+"]");
                depthFF(u);
            }
        }
    }
    public void depthFF(T r){

        adjacencyList.get(r).setVisited(true);
        System.out.println(r);
        for(T v : adjacencyList.get(r).getNeighbours()){
            if(!adjacencyList.get(v).isVisited()){
                depthFF(v);
            }
        }
    }

    public void BFS(){
        int count = 0;
        for(T u : sAl){
            adjacencyList.get(u).setVisited(false);
        }
        for(T u : sAl){
            if(!adjacencyList.get(u).isVisited()){
                count++;
                System.out.println("[Tree "+count+"]");
                BFSv(u);
            }
        }
    }
    public void BFSv(T r){

        LinkedList<T> q = new LinkedList<>();
        T s;
        q.push(r);

        adjacencyList.get(r).setVisited(true);
        System.out.println(r);
        while (!q.isEmpty()){
            s = q.removeLast();
            for(T t : adjacencyList.get(s).getNeighbours()){
                if(!adjacencyList.get(t).isVisited()){
                    q.push(t);
                    adjacencyList.get(t).setVisited(true);
                    System.out.println(t);
                }
            }
        }
    }
    public int getDegree(){
        T max = sAl.first();
        for(T u : sAl){
            if(adjacencyList.get(u).noOfNeighbours() > adjacencyList.get(max).noOfNeighbours()){
                max = u;
            }
        }
        return adjacencyList.get(max).noOfNeighbours();
    }
    public boolean isTree(){
        int totalEdges = 0;
        for(T u : sAl){
            totalEdges +=adjacencyList.get(u).noOfNeighbours();
        }
        if(isConnected()){
            if((totalEdges/2)>adjacencyList.size()-1){
                return false;
            }
            else return true;
        }
        return false;
    }



    public static void main(String[] args) {
        MP8_20 graph = new MP8_20();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);
        graph.addVertex(9);
        graph.addVertex(10);

        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(3,6);
        graph.addEdge(4,5);
        graph.addEdge(4,7);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(7,6);
        graph.addEdge(9,10);

        System.out.println("(A.) Is graph connected:"+'\n'+graph.isConnected()+ '\n');
        System.out.println("(B.) No. of connected components of graph:"+'\n'+graph.connectedComponents()+ '\n');
        System.out.print("(C.) Vertices in each connected components:" +'\n'+graph.verticesCCoG()+ '\n');
        System.out.println("(D.) Degree of the graph:"+ '\n'+graph.getDegree()+ '\n');
        System.out.println("(E.) Is Graph a Tree:"+'\n' +graph.isTree()+ '\n');
        System.out.println("(F.)DFS spanning forest of graph");
        graph.depthFirst();
        System.out.println("(G.)BFS spanning forest of graph");
        graph.BFS();


    }
}
class Vertex<T> implements Iterable<T>{

    private boolean visited;
    private SortedSet<T> adjN;
    private ArrayList<T> neighbours;

    public Vertex(){
        this.visited = false;
        this.neighbours = new ArrayList<>();
    }

    public Vertex(Vertex rhs){
        this.visited = rhs.visited;
        this.neighbours = new ArrayList<>(rhs.neighbours);
    }

    public boolean isVisited(){
        return visited;
    }

    public Iterable<T> getNeighbours(){
        adjN = new TreeSet<>(neighbours);
        return adjN;
    }


    public void removeNeighbour(T v){
        this.neighbours.remove(v);
    }



    public int noOfNeighbours(){
        return this.neighbours.size();
    }

    public boolean isNeighbour(T v){
        return this.neighbours.contains(v);
    }

    public void addNeighbour(T v){
        this.neighbours.add(v);
    }

    public void append(Vertex other){
        for(Object i : other){
            this.neighbours.add((T)i);
        }
    }


    public void removeAll(T v){
        this.neighbours.removeIf(x -> x == v);
    }

    public void replaceAll(T v1, T v2){
        this.neighbours.replaceAll(x -> { if(x == v2) return v1; else return x; });
    }
    public void setVisited(boolean b){
        this.visited = b;
    }

    @Override
    public Iterator<T> iterator(){
        return this.neighbours.iterator();
    }
}
