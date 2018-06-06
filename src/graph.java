import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

class graph {
    List<Vertex> vertices = new ArrayList<Vertex>();
    Map<String, Vertex> recorder = new HashMap<String, Vertex>();

    public graph(String filePath) {
        generateGraph(filePath);
    }

    public void generateGraph(String filePath) {
        File f = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                String startVertex = scanner.next();
                String endVertex = scanner.next();
                int weight = scanner.nextInt();
                Vertex v = recorder.get(startVertex);
                if (v == null) {
                    v = new Vertex(startVertex);
                    v.adj.add(new adjacentVertex(endVertex, weight));
                    recorder.put(startVertex, v);
                    vertices.add(v);
                } else {
                    v.adj.add(new adjacentVertex(endVertex, weight));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}