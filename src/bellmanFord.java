class bellmanFord {
    public static int bellmanFordFindShortestPath(String startPoint,String endPoint,graph g){
        int length=g.vertices.size();
        for(Vertex v:g.vertices){
            if(v.name.equals(startPoint)){
                v.distance=0;
            }
            else
                v.distance=11111111;
        }
        for(int i=1;i<length;i++){
            for(Vertex v:g.vertices){
                for(adjacentVertex adj:v.adj){
                    Vertex tmp=g.recorder.get(adj.name);
                    if(tmp.distance>v.distance+adj.weight)
                        tmp.distance=v.distance+adj.weight;
                }
            }
        }
        for(Vertex v:g.vertices){
            for(adjacentVertex adj:v.adj){
                Vertex tmp=g.recorder.get(adj.name);
                if(tmp.distance>v.distance+adj.weight)
                    return -11111111;
            }
        }
        return g.recorder.get(endPoint).distance;
    }
}
