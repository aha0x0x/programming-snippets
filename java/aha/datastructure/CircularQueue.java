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

public class CircularQueue 
{
	/* a simple circular queue 
	 *  we will keep track of the number of elements inserted and the tail of the queue
	 *  head of the queue will be calculated. 
	 */
	private final int capacity;
	private int numElements;
	private int tail;
	private final int[] queue;
	
	public CircularQueue( int capacity  )
	{
		this.capacity = capacity;
		this.numElements = 0;
		this.tail = 0;
		this.queue = new int[ this.capacity ];
	}
	
	public void enqueue( int value )
	{
		// insertions are done at tail of the queue
		if( numElements == capacity )
		{
			throw new IllegalStateException(  "Queue is full" ); 
		}
		
		queue[ tail ] = value;
		++numElements;
		//System.out.print( "\nPush() queue[" + tail +"] = " + queue[tail] + ". Queue size is " + numElements );
		
		tail = ++tail % capacity;
	//	System.out.print( " Next insertion at index[" + tail +"]" );
	}
	
	public int dequeue()
	{
		// elements are popped at the head of the queue
		if(  isEmpty() )
		{
			throw new IllegalStateException(  "Queue is empty" );
		}
		
		int idx = ( tail + ( capacity - numElements) ) % this.capacity;
		int value = queue[ idx ];
		--numElements;
		
		//System.out.print( "\nPop() returning queue[" + idx +"] = " + queue[idx] + ". Queue size is " + numElements );
		
		return value;
	}

    public boolean isEmpty()
    {
        return ( numElements == 0 );
    }
    
    public boolean isFull()
    {
        return ( numElements == capacity );
    }
	
	

}
