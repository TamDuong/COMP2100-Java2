  
/**
 * class Vertex 
 * 
 * Tam Duong
 * 04/18/14
 */
public class Vertex
{
    protected String name, preVertexName;
    protected boolean visited;
    protected double distance;
    
    // Vertex's constructor
    public Vertex(String name) 
    {
        this.name = name;
        this.visited = false;
        this.distance = Double.POSITIVE_INFINITY;
    }
    
    // overide equals method to use Vertexes.contains(..) in Graph class
    public boolean equals(Object any)
    {
        if (!(any instanceof Vertex))
            return false;
            
        Vertex v = (Vertex)any;
        return (this.name.equals(v.name));
    }
    
    public String toString(){
        String v = name + " " + distance;
        return v;
    }
}
