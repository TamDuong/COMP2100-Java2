import java.util.*;
  
/**
 * Edge class
 * 
 * Tam Duong
 * 04/18/14
 */
public class Edge
{
    protected Vertex start,
                     end;
    protected double edgeWeight;
    
    public Edge(Vertex start, Vertex end, double edgeWeight)
    {
        this.start = start;
        this.end = end;
        this.edgeWeight = edgeWeight;
    }
    
    public String toString(){
        String r = "";
        r += start.name + end.name +" " +edgeWeight;
        return r;
    }
    
}
