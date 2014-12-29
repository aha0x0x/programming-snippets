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

package aha.datastructure;

public class MinHeap
{
    final int capacity;
    int numOfElements; 
    final int[] heap;
    
    public MinHeap( int capacity )
    {
        this.capacity = capacity;
        this.heap = new int[ this.capacity ];
        this.numOfElements = 0;
    }
    
    public boolean isEmpty()
    {
        return ( numOfElements == 0 );
    }
    
    public boolean isFull()
    {
        return ( numOfElements == capacity );
    }
    
    private static int getParent( int index )
    {
        return ( index - 1 ) / 2;
    }
    
    private static int getLeftChild( int index )
    {
        return  ( 2 * index )  + 1 ; 
    }
    
    private static int getRightChild( int index )
    {
        return  ( 2 * index )  + 2 ; 
    }
    
    private void fixHeapUpwards( int current )
    {
        int parent = getParent( current );
        
        // root of heap 
        if( parent == current )
        {
            return;
        }
        
        if( heap[ parent ] > heap[ current ]  )
        {
            int temp = heap[ parent ];
            heap[ parent ] = heap[ current ];
            heap[current ] = temp;
            fixHeapUpwards( parent );
        }
    }
    
    public void push( int value )
    {
        if( isFull() )
        {
            throw new RuntimeException( "heap is full" );
        }
        
        /* adding to max heap 
         *  a) add to the end 
         */
        heap[ numOfElements ] = value;
        fixHeapUpwards( numOfElements );
        ++numOfElements;
    }
    
    private void fixHeapDownwards( int current )
    {
        if( current == numOfElements )
        {
            return;
        }
        
        int left = getLeftChild( current );
        int right = getRightChild( current );
        
        int smallest = current;
        if( left < numOfElements && heap[left] < heap[current]  )
        {
            smallest = left;
        }
        
        if( right < numOfElements && heap[right] < heap[smallest]  )
        {
            smallest = right;
        }
        
        if( current != smallest )
        {
            int tmp = heap[current];
            heap[current] = heap[smallest];
            heap[smallest] = tmp;
            fixHeapDownwards( smallest );
        }
    }
    
    public int pop()
    {
           if( isEmpty() )
           {
               throw new RuntimeException( "heap is empty." );
           }

           /*  a) reduce the numOfElements,
            *  b) swap the first (min) element with element at the last index
            *  c) fixHeapDownwards starting from 0. 
            */
          
           --numOfElements ;
           int min = heap[ 0 ];
           heap[0] = heap[ numOfElements ];
                      
           fixHeapDownwards( 0 );
           return min;
    }
    
    public static void main( String[] args )
    {
        MinHeap heap = new MinHeap( 5 );
        heap.push(29);
        heap.push(11);
        heap.push(0);
        heap.push(-121);
        heap.push( 3000 );
        
        while( !heap.isEmpty() )
        {
            System.out.println( heap.pop() );
        }
        
        heap.push(3);
        heap.push(45);
        heap.push(-39);
        heap.push(17);
        heap.push(57);
        
        while( !heap.isEmpty() )
        {
            System.out.println( heap.pop() );
        }
    }
}
