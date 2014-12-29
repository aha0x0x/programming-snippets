package aha.datastructure;

public class BinarySearchTree<T extends Comparable<T>> 
{
	private T value;
	private BinarySearchTree<T> parent;
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;
	
	public BinarySearchTree( T value, BinarySearchTree<T> parent )
	{
		this.value = value;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}
	
	public T getValue()
	{
		return value;
	}
	
	public BinarySearchTree<T> getLeft()
	{
		return left;
	}
	
	public BinarySearchTree<T> getRight()
	{
		return right;
	}
	
	public BinarySearchTree<T> getParent()
	{
		return parent;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(  "\n[" );
		builder.append(  " value:" + value );
		builder.append(  " parent:" + ( parent != null ? parent.getValue() : "null" ) );
		builder.append(  " left:" + ( left != null ? left.getValue() : "null" ) );
		builder.append(  " right:" + ( right != null ? right.getValue() : "null" ) );
		builder.append(  " ]" );
		return builder.toString();
	}
	
	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
		{
			return true;
		}
		
		if(  !( o instanceof BinarySearchTree ) )
		{
			return false;
		}
		
		BinarySearchTree<?> other = ( BinarySearchTree<?> ) o;
		return 	this.value.equals( other.value ) &&
					this.left.equals( other.left ) &&
					this.right.equals( other.right );
	}
		
	private void insertLeft( T value )
	{
		if( left == null )
		{
			left = new BinarySearchTree<T>( value, this );
			return;
		}
		left.insert( value );
	}
	
	private void insertRight( T value )
	{
		if( this.right == null )
		{
			this.right = new BinarySearchTree<T>( value, this  );
			return;
		}
		this.right.insert( value );
	}
	
	public void insert( T value )
	{
		if( this.value.compareTo( value ) == 0 )
		{
			return;
		}
		
		if(  this.value.compareTo( value )  < 0 )
		{
			insertRight( value );
		}
		else
		{
			insertLeft( value );
		}
	}
	
	private BinarySearchTree<T> searchRight( T value )
	{
		return ( right != null  ) ?  right.search( value )
											 :  null;
	}
	
	private BinarySearchTree<T> searchLeft( T value )
	{
		return ( left != null  ) ? left.search( value )
					  					    : null;
	}

	public BinarySearchTree<T> search( T value )
	{
		if( this.value.compareTo( value ) == 0 )
		{
			return this;
		}
		
		return ( this.value.compareTo( value )  < 0 )  ? searchRight( value )
																	      		 : searchLeft( value );
	}
	
	public void printInOrder()
	{
		// inOrder: left, itself, right
		if( left != null )
		{
			left.printInOrder();
		}
		System.out.print(" " + value  + " ");
		
		if( right != null )
		{
			right.printInOrder();
		}
	}
	
	public void printPreOrder()
	{
		// preOrder: itself, left, right
		System.out.print(" " + value + " ");
		if( left != null )
		{
			left.printPreOrder();
		}

		if( right != null )
		{
			right.printPreOrder();
		}
	}
	
	public void printPostOrder()
	{
		// postOrder:  left, right, itself
		if( left != null )
		{
			left.printPostOrder();
		}

		if( right != null )
		{
			right.printPostOrder();
		}
		System.out.print(" " + value + " ");
	}

	public BinarySearchTree<T> getMin()
	{
		return 	(  left != null  ) ?  left.getMin() 
								 			 : this;
	}
	
	public BinarySearchTree<T> getMax()
	{
		return ( right != null ) ?  right.getMax()
											: this;
	}

	
	public static<T extends Comparable<T> > 
	BinarySearchTree<T> findNextInOrder( T value,  BinarySearchTree<T> bst )
	{
		// search for the value and return null if not found
		BinarySearchTree<T> node = bst.search( value );
		if( node == null )
		{
			return null;
		}
		
		/* 
		 * case 1: right child exists: return right child min value
		 * case 2: no parent i.e root, plus has no right child   
		 * case 3: check if left child of the parent: then return parent  
		 * case 4: if node is right child parent, keep on going up until parent is the left child 
		 * 
		 */
		
		// case 1:
		if( node.getRight() != null )
		{
			return node.getRight().getMin();
		}
		
		BinarySearchTree<T> parent = node.getParent();
		// case 2: 
		if( parent == null )
		{
			return null;
		}
		
		// case 3:
		if( node.equals ( parent.getLeft() ) )
		{
			return parent;
		}
		
		/* 
		 * most interesting 
		 *  right child of a parent with no children of its own. 
		 *  keep on going up 
		 */
		while( parent != null )
		{
			if( node.equals ( parent.getLeft() ) )
			{
				return parent;
			}
			node = parent; 
			parent = node.getParent();
		}

		return parent;
	}
	
	public static<T extends Comparable<T> > 
	BinarySearchTree<T> findPreviousInOrder( T value,  BinarySearchTree<T> bst )
	{
	    // search for the value and return null if not found
        BinarySearchTree<T> node = bst.search( value );
        if( node == null )
        {
            return null;
        }
        
        /* 
         * case 1: left child exists: return left child max value
         * case 2: no parent return null   
         * case 3: check if right child of the parent: then return parent  
         * case 4: if node is right child parent, keep on going up until parent is the left child 
         */
               
        if ( node.getLeft() != null )
        {
            return node.getLeft().getMax() ;
        }
        
        BinarySearchTree<T> parent = node.getParent();
        if ( parent == null )
        {
            return null;
        }
        
        if ( node.equals(  parent.getRight() ) )
        {
            return parent;
        }
        
        /* most interesting case: 
         *  left child of a parent with no children of its own. 
         *  keep on going up until it becomes a right child  
         */

        while( parent != null )
        {
            if ( node.equals(  parent.getRight() ) )
            {
                return parent;
            }
            node = parent;
            parent = node.getParent();
        }
        return parent;
	}
	
	public static void main( String[] args )
    {
	    // testing code 
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
