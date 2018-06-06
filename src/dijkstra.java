import java.util.*;

class dijkstra {
    static int dijkstraFindShortestPath(String startPoint,String endPoint,graph g){
        Queue<Vertex> queue=new LinkedList<Vertex>();
        List<Vertex> done=new ArrayList<Vertex>();
        PriorityQueue<Vertex> ongoing=new PriorityQueue<Vertex>();
        for(Vertex v:g.vertices){
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
                Vertex adjacent=g.recorder.get(adj.name);
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
