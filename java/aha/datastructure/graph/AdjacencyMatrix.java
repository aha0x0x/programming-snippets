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
import java.util.List;

public class AdjacencyMatrix
{
    final int numOfVertices; 
    final private boolean[][] matrix;
    
    public AdjacencyMatrix(  int numOfVertices  )
    {
        this.numOfVertices = numOfVertices;
        this.matrix = new boolean[numOfVertices][numOfVertices];
    }
    
    public void addEdge( int from, int to )
    {
        matrix[from][to] = true;
    }
    
    public void removeEdge( int from, int to )
    {
        matrix[from][to] = false;
    }
    
    public boolean hasEdge( int from, int to )
    {
        return matrix[from][to]; 
    }
    
    public int getNumberOfVertices()
    {
        return numOfVertices;
    }
    
    public List<Integer> getNeighbors( int vertex )
    {
        List<Integer> adjacenyList = new ArrayList<>();
        
        for( int idx = 0; idx < matrix[vertex].length; ++idx )
        {
            if( matrix[vertex][idx] )
            {
                adjacenyList.add( idx );
            }
        }
        return adjacenyList;
    }
        
}
