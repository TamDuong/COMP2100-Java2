
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
  
/**
 * Graph class
 * 
 * Tam Duong
 * 04/18/14
 */
public class Graph
{
    protected LinkedList<Vertex> Vertexes = new LinkedList<>();
    protected LinkedList<Edge> Edges = new LinkedList<>();
    protected String pathInfo = "";             // keeps the path and optimal cost
    
    //Graph's constructor
    public Graph(String dataFile) throws FileNotFoundException{
        load(dataFile); 
    }
    
    // load data from file into Vertex and Edge
    public void load(String dataFile) throws FileNotFoundException 
    {
        Scanner input = new Scanner(new File(dataFile));
        while(input.hasNext()) {
            String line = input.nextLine();
            String[] info = line.split("\\s+"); // \\s+ is space+ use this to take out spaces
            
            for (int i = 0; i <= 1; i++) {
                if (!Vertexes.contains(new Vertex(info[i])))
                    Vertexes.add(new Vertex(info[i]));
            }
            
            Edges.add(new Edge(search(info[0]), search(info[1]), Double.parseDouble(info[2])));
        }
    }
    
    // Dijkstra algorithm to calculate the shortest path from 1 vertex to another
    public void dijkstra(String startV, String endV)
    {
        Vertex v = search(startV),      // startV Vertex
               n = new Vertex("");      //v's neighbor
        v.distance = 0;                 // set startV Vertex's distance to 0
        
        // check if user provide correct input
        if (!Vertexes.contains(new Vertex(startV)) || !Vertexes.contains(new Vertex(endV))) 
            throw new InputMismatchException();

        // this loop compute the distance and visited of vertices until it reach the endV vertex
        while (!v.visited) {
            
            for (Edge i : Edges)          // for every edge i in Edges(linkedlist of edge), i start at 0
                if (i.start.equals(v)) {
                    if (i.end.distance > (i.start.distance + i.edgeWeight)) {
                        i.end.distance = i.start.distance + i.edgeWeight;   //set distance for end vertex
                        i.end.preVertexName = i.start.name;
                    }
                    
                    if (!i.end.equals(new Vertex(startV)))  // make sure that n won't end up become startV vertex
                        n = i.end;      // n is v's neighbor, here n will change constantly but the final n will equal to the last v's neighbor
                    }
                    
            v.visited = true;
            //check if other vertexes have been vistited or not if not 
            for (Vertex i: Vertexes)
                if((!i.visited))
                    n = i;
                    
            // check for the lowest unvisited vertex to assign n this loop *MUST* go after the previous for loop
            // if pick any vertex to assign to n then if the vertexes distance is too big then it will use this distance to compute its neighbor
            for (Vertex i: Vertexes)
                if ((!i.visited) &&  i.distance < n.distance)
                    n = i;
                
            v = n;
        }
        
        // compute the path and optimal cost
        pathInfo = endV;
        Vertex result = search(endV);
        double cost = result.distance;          // after the dijkstra algorithm the cost is the distance of endV vertex
        while (!result.equals(search(startV))) {
            result = search(result.preVertexName);
            pathInfo = result.name + "->" + pathInfo;
        }
        pathInfo = "This is the shortest path: " + pathInfo + "\n" + "Optimal cost is: " + cost;
    }
    
    public String toString()
    {
        String r = "Edges contain:\n";
        for(int i = 0; i < Edges.size() ; i++)
            r += Edges.get(i) + "\n";
            
        r += "--------------" + "\n" + "Vertexes contain:\n";
        for(int j = 0; j < Vertexes.size(); j++)
            r += (Vertexes.get(j)).name + " " + (Vertexes.get(j)).distance +"\n";
            
        return r + pathInfo;
    }
    
    // return the Vertex from Vertexes if u call it's name
    public Vertex search(String name)
    {
        Vertex v = new Vertex("");
        
        for (Vertex i : Vertexes) 
            if (i.equals(new Vertex(name)))
                v = i;
        return v;
    }
}