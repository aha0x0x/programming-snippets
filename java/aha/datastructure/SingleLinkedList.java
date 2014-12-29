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

public class SingleLinkedList<T>
{
    private T value;
    private SingleLinkedList<T> next;
    
    public SingleLinkedList( T value )
    {
        this.value = value;
        this.next = null;
    }
    
    public SingleLinkedList(  T value, SingleLinkedList<T> next )
    {
        this.value = value;
        this.next = next;
    }
    
    @Override 
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "[" ).append( value );
        
        SingleLinkedList<T> current = next;
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
    
    public SingleLinkedList<T> getNext()
    {
        return next;
    }
    
    public void setValue(  final T value )
    {
        this.value = value;
    }
    
    public void setNext( final SingleLinkedList<T> next )
    {
        this.next = next;
    }
  
    public static<T> 
    SingleLinkedList<T> createList(  final T[] values )
    {
        if( values.length == 0 )
        {
            return null;
        }
        
        SingleLinkedList<T> root = new SingleLinkedList<T>( values[0] );
        SingleLinkedList<T> current = root;
        
        for( int idx = 1; idx < values.length; ++idx )
        {
            SingleLinkedList<T> next = new SingleLinkedList<T>( values[idx] );
            current.setNext( next );
            current = current.getNext();
        }
        return root;
    }
     
    public static void main( String[] args )
    {
        Integer[] values = { 34, -29, 45, 342, 99, 7 };
        SingleLinkedList<Integer> slist = SingleLinkedList.createList(  values );
        System.out.println( slist );
    }

}
