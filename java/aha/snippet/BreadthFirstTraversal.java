/*
 * Copyright (c) 2014 Abdul Hannan Ahsan <abdulhannan.ahsan@gmail.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package aha.snippet;

import java.util.Set;

import aha.datastructure.GenericCircularQueue;
import aha.datastructure.graph.Edge;
import aha.datastructure.graph.Graph;
import aha.datastructure.graph.Vertex;
import aha.datastructure.graph.Vertex.STATE;

public class BreadthFirstTraversal
{

    private static Graph createGraph()
    {
        Vertex v0 = new Vertex( "0" );
        Vertex v1 = new Vertex( "1" );
        Vertex v2 = new Vertex( "2" );
        Vertex v3 = new Vertex( "3" );
        Vertex v4 = new Vertex( "4" );
        
        Graph graph = new Graph( );
        
        graph.addEdge( new Edge( v0, v1 ) ) ;
        graph.addEdge( new Edge( v1, v2 ) ) ;
        graph.addEdge( new Edge( v1, v4 ) ) ;
        
        graph.addEdge( new Edge( v2, v0 ) ) ;
        graph.addEdge( new Edge( v2, v3 ) ) ;
        graph.addEdge( new Edge( v2, v4 ) ) ;
        graph.addEdge( new Edge( v3, v1 ) ) ;
        graph.addEdge( new Edge( v4, v2 ) ) ;
        
        return graph;
        
    }
    
    private static void printBFT( Graph graph, Vertex startVertex )
    {
        /* Breadth-first traversal 
         *  - For Push starting vertex on queue 
         *  - For vertex on queue
         *      - Enqueue those neighbors which are not already queued or visited, and mark vertex as visited    
         */
        
        GenericCircularQueue<Vertex> queue = new GenericCircularQueue<Vertex>( Vertex.class, graph.getNumberOfVertices() );
        startVertex.setState( STATE.IN_PROCESS );
        queue.enqueue( startVertex );
        
        while( !queue.isEmpty() )
        {
            Vertex vertex = queue.dequeue();
            System.out.println( "Deqeueud " + vertex );
            
            for (  Edge edge : graph.getEdges( vertex )  )
            {
                Vertex neighbor = edge.getTo();
                
                if( neighbor.getState() == STATE.NOT_PRECESSED ) 
                {
                    neighbor.setState( STATE.IN_PROCESS );
                    System.out.println( "Queued " + neighbor );
                    queue.enqueue( neighbor );
                }
            }
    
            vertex.setState( STATE.PROCESSED );
            System.out.println( "Visited " + vertex );
        }
    }
    
    public static void main( String[] args )
    {
        Graph graph = createGraph();
        Set<Vertex> allVertices = graph.getAllVertices();
        printBFT( graph,  allVertices.iterator().next() );
    }
    
    
}
