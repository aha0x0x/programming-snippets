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

public class DoubleLinkedList<T>
{
    private T value;
    private DoubleLinkedList<T> previous;
    private DoubleLinkedList<T> next;
    
    public DoubleLinkedList( T value  )
    {
        this.value = value;
        this.previous = null;
        this.next = null;
        
    }
    
    public DoubleLinkedList(  T value, DoubleLinkedList<T> previous, DoubleLinkedList<T> next )
    {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
    
    @Override 
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "[" ).append( value );
        
        DoubleLinkedList<T> current = next;
        while( current != null )
        {
            builder.append( "," + current.getValue() );
            current = current.getNext();
        }
        builder.append( "]" );
        return builder.toString();
    }
        
    public T getValue()
    {
        return value;
    }
    
    public DoubleLinkedList<T> getPrevious()
    {
        return previous;
    }
    
    public DoubleLinkedList<T> getNext()
    {
        return next;
    }
        
    public void setValue(  final T value )
    {
        this.value = value;
    }
    
    public void setPrevious( final DoubleLinkedList<T> previous )
    {
        this.previous = previous;
    }
    
    public void setNext( final DoubleLinkedList<T> next )
    {
        this.next = next;
    }
  
    public static<T> 
    DoubleLinkedList<T> createList(  final T[] values )
    {
        if( values.length == 0 )
        {
            return null;
        }
        
        DoubleLinkedList<T> root = new DoubleLinkedList<T>( values[0] );
        DoubleLinkedList<T> current = root;
        
        for( int idx = 1; idx < values.length; ++idx )
        {
            DoubleLinkedList<T> next = new DoubleLinkedList<T>( values[idx] );
            
            current.setNext( next );
            next.setPrevious( current );
            
            current = current.getNext();
        }
        return root;
    }
  
    public static void main( String[] args )
    {
        Integer[] values = { 34, -29, 45, 342, 99, 7 };
        DoubleLinkedList<Integer> dlist = DoubleLinkedList.createList(  values );
        System.out.println( dlist );
    }
}
