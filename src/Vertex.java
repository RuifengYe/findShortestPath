import java.util.ArrayList;
import java.util.List;

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
