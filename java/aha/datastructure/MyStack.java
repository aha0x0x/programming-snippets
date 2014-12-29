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

public class MyStack
{
    private final int capacity;
    private final int[] stack;
    private int numOfElements;
    public MyStack( int capacity )
    {
        this.capacity = capacity;
        this.stack = new int[capacity];
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
    
    public void push( int value )
    {
        if( isFull() )
        {
            throw new RuntimeException(  "stack overflow" );
        }
        stack[numOfElements++] = value;
        
    }
    
    public int pop()
    {
        if( isEmpty() )
        {
            throw new RuntimeException(  "stack underflow" );
        }
        
        --numOfElements;
        return stack[numOfElements];
    }
    
    public int peek()
    {
        if( isEmpty() )
        {
            throw new RuntimeException(  "stack underflow" );
        }
        
        return stack[numOfElements - 1 ];
    }

    public static void main ( String[] args )
    {
        MyStack stack = new MyStack(5);
        stack.push(2);
        stack.push(54);
        stack.push(98);
        stack.push(-1);
        stack.push(11);
        
        System.out.println("Value=" + stack.pop());
        System.out.println("Value=" + stack.pop());
        System.out.println("Value=" + stack.pop());
        System.out.println("Value=" + stack.pop());
        System.out.println("Value=" + stack.pop());
        System.out.println( "Stack is empty: " + Boolean.toString( stack.isEmpty() ) );
        
        stack.push(13);
        stack.push(-21);
        stack.push(111);
        System.out.println("Value=" + stack.pop());
        System.out.println("Value=" + stack.pop());
        System.out.println("Peeking=" + stack.peek());
        
        
        

    }

}



