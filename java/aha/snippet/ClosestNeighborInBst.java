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

import aha.datastructure.BinarySearchTree;

public class ClosestNeighborInBst 
{
	public static void main( String[] args )
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>( 21, null );
		bst.insert( 11 );
		bst.insert( 19 );
		bst.insert( 7 );
		bst.insert( 46 );
		bst.insert( 29 );
		bst.insert( 96 );
		
		bst.printInOrder();
		System.out.println( "Min: " +  bst.getMin() );
		System.out.println( "Max: " +  bst.getMax() );
		
		BinarySearchTree<Integer> result = BinarySearchTree.findNextInOrder( 19, bst );
		System.out.println( "NextInOrder after 19: " +  ( result != null ? result.getValue() : " not found." ) );
		
		result = BinarySearchTree.findNextInOrder( 21, bst );
		System.out.println( "NextInOrder after 21: " +  ( result != null ? result.getValue() : " not found." ) );
		
		
		result = BinarySearchTree.findPreviousInOrder( 29, bst );
        System.out.println( "PreviousInOrder after 29: " +  ( result != null ? result.getValue() : " not found." ) );
        
        result = BinarySearchTree.findPreviousInOrder( 21, bst );
        System.out.println( "PreviousInOrder after 21: " +  ( result != null ? result.getValue() : " not found." ) );
		
	}
	



}
