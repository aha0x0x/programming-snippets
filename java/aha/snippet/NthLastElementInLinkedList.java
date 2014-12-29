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

import aha.datastructure.SingleLinkedList;

public class NthLastElementInLinkedList
{
    private static Integer findNthLastElement( SingleLinkedList<Integer> list, int n )
    {
        /* keep two references; 
         * a) Move first ref n deep 
         * b) Set a second ref at the start of the list 
         * c) Move both to their next elements until first reaches the end 
         * d) return the value pointed to by second.   
         */
        SingleLinkedList<Integer> first = list;
        int i = 1;
        while(  first != null && i <= n )
        {
            first = first.getNext();
            ++i;
        }
        
        if( first == null )
        {
            return null;
        }
        
        SingleLinkedList<Integer> second = list;
        while( first != null )
        {
            first = first.getNext();
            second = second.getNext();
        }
        
        return second.getValue();
    }
    
    
    public static void main( String[] args )
    {
        Integer[] values = { 4, 6, 2, 99, 11, -293, 0 };
        SingleLinkedList<Integer> list = SingleLinkedList.createList( values );
        
        System.out.println( list );
        
        System.out.println("The " + 3 + " element from Last is " + findNthLastElement( list, 3 ));
        System.out.println("The " + 1 + " element from Last is " + findNthLastElement( list, 1 ));
        System.out.println("The " + 10 + " element from Last is " + findNthLastElement( list, 10 ));
        
        
    }
    
}
