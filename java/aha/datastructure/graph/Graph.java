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

package aha.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph
{
        private final Map<Vertex, List<Edge>> graph;
        
        public Graph( )
        {
            this.graph = new HashMap<Vertex, List<Edge>>();
        }
        
        public void addEdge( Edge e  )
        {
            Vertex from = e.getFrom();
            
            if( graph.containsKey( from ) )
            {
                graph.get( from ).add( e );
            }
            else
            {
                List<Edge> edges = new ArrayList<Edge>();
                edges.add( e );
                graph.put( from, edges );
            }
        }

        public List<Edge> getEdges( Vertex v )
        {
            return graph.get( v  );
        }

        public int getNumberOfVertices()
        {
            return graph.keySet().size();
        }

        public Set<Vertex> getAllVertices()
        {
            return graph.keySet();
        }
}
