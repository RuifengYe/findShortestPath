public class shortestPath {
    public static void main(String[] args) {
        graph g=new graph("D://Java projects//findShortestPath//graph.txt");
        System.out.println(dijkstra.dijkstraFindShortestPath("A","E",g));
        System.out.println(bellmanFord.bellmanFordFindShortestPath("A","E",g));
    }
}


