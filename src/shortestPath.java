import java.io.*;
import java.util.*;
public class shortestPath {
    public static void main(String[] args) {
        graph g=new graph("D://Java projects//findShortestPath//graph.txt");
        System.out.println(g.findShortestPath("A","C"));
    }
}

class Vertex implements Comparable<Vertex>{
    String name;
    int distance;
    List<adjacentVertex> adj=new ArrayList<adjacentVertex>();
    public Vertex(String name){
        this.name=name;
    }
    public int compareTo(Vertex x){
        if(this.distance<=x.distance)
            return -1;
        return 1;
    }
}
class adjacentVertex{
    String name;
    int weight;
    public adjacentVertex(String name,int weight){
        this.name=name;
        this.weight=weight;
    }
}
class graph{
    List<Vertex> vertices=new ArrayList<Vertex>();
    Map<String,Vertex> recorder=new HashMap<String,Vertex>();
    public graph(String filePath){
        generateGraph(filePath);
    }
    public void generateGraph(String filePath){
        File f=new File(filePath);
        try {
            BufferedReader br=new BufferedReader(new FileReader(f));
            String line;
            while((line=br.readLine())!=null){
                Scanner scanner=new Scanner(line);
                String startVertex=scanner.next();
                String endVertex=scanner.next();
                int weight=scanner.nextInt();
                Vertex v=recorder.get(startVertex);
                if(v==null){
                    v=new Vertex(startVertex);
                    v.adj.add(new adjacentVertex(endVertex,weight));
                    recorder.put(startVertex,v);
                    vertices.add(v);
                }else{
                    v.adj.add(new adjacentVertex(endVertex,weight));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public int findShortestPath(String startPoint,String endPoint){
        Queue<Vertex> queue=new LinkedList<Vertex>();
        List<Vertex> done=new ArrayList<Vertex>();
        PriorityQueue<Vertex> ongoing=new PriorityQueue<Vertex>();
        for(Vertex v:vertices){
            if(v.name.equals(startPoint)){
                done.add(v);
                queue.offer(v);
            }else{
                ongoing.offer(v);
                v.distance=Integer.MAX_VALUE;
            }
        }
        while(!queue.isEmpty()){
            Vertex tmp=queue.poll();
            for(adjacentVertex adj:tmp.adj){
                Vertex adjacent=recorder.get(adj.name);
                if(tmp.distance+adj.weight<adjacent.distance) {
                    adjacent.distance = tmp.distance + adj.weight;
                    ongoing.remove(tmp);
                    ongoing.offer(tmp);
                }
            }
            if(!ongoing.isEmpty()) {
                Vertex nextStart = ongoing.poll();
                queue.offer(nextStart);
                done.add(nextStart);
            }else
                break;
        }
        for(Vertex tmp:done){
            if(tmp.name.equals(endPoint))
                return tmp.distance;
        }
        return Integer.MIN_VALUE;
    }
}

