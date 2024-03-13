
/* BinaryTree.java */
//    // *** Fields ***


// BinaryTree class; stores a binary tree.
//
// CONSTRUCTION: with (a) no parameters or (b) an object to
//    be placed in the root of a one-element tree.
//
//  Author: Mark Allen Weiss
// *******************PUBLIC OPERATIONS**********************
// Various tree traversals, size, height, isEmpty, makeEmpty.
// Also, the following tricky method:
// void merge( Object root, BinaryTree t1, BinaryTree t2 )
//                        --> Construct a new tree
// *******************ERRORS*********************************
// Error message printed for illegal merges.

/**
 * BinaryTree class that illustrates the calling of
 * BinaryNode recursive routines and merge.
 */
public class BinaryTree<AnyType>
{
	private BinaryNode<AnyType> root;
	
    public BinaryTree() {
        root = null;
    }

    public BinaryTree( AnyType rootItem ){
        root = new BinaryNode<AnyType>( rootItem, null, null );
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }
    
    public BinaryNode<AnyType> getRoot() {
        return root;
    }
    
    /**
    Returns the number of nodes in the tree.
    Uses a recursive helper that recurs
    down the tree and counts the nodes.
   */
    public int size() {
        return BinaryNode.size( root );
    }

    /**
    Returns the height (max root-to-leaf depth) of the tree.
    Uses a recursive helper that recurs down to find
    the height (max depth).
   */
    public int height() {
    	//To be implemented
    	return BinaryNode.height(root);
        //return 0;
    }
    
    
    public void printPreOrder() {
    	if( root != null )
            root.printPreOrder();
        //System.out.println( "To be implemented!!" );    
    }

    public void printInOrder(){
        if( root != null )
           root.printInOrder();
    }

    public void printPostOrder() {
    	if( root != null )
            root.printInOrder();
    }
    
    /**
     * Merge routine for BinaryTree class.
     * Forms a new tree from rootItem, t1 and t2.
     * Does not allow t1 and t2 to be the same.
     * Correctly handles other aliasing conditions.
     */
    public void merge( AnyType rootItem, BinaryTree<AnyType> t1, BinaryTree<AnyType> t2 ) {
        if( t1.root == t2.root && t1.root != null ) {
            System.err.println( "leftTree==rightTree; merge aborted" );
            return;
        }

            // Allocate new node
        root = new BinaryNode<AnyType>( rootItem, t1.root, t2.root );

            // Ensure that every node is in just one tree!
        if( this != t1 )
            t1.root = null;
        if( this != t2 )
            t2.root = null;
    }

    
    static public void main( String [ ] args ) {
        
        
    	test1();
    	test2();
    	test3();
    }
    
    private static void test1(){
        BinaryTree<Integer> t4 = new BinaryTree<Integer>( 4 );
        BinaryTree<Integer> t5 = new BinaryTree<Integer>( 5 );
        BinaryTree<Integer> t6 = new BinaryTree<Integer>( 6 );
        BinaryTree<Integer> t1 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t2 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t3 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> temp = new BinaryTree<Integer>( );
        
        t2.merge( 2, t4, t5 );
        t3.merge( 3, t6, temp );
        t1.merge( 1, t2, t3 );

        System.out.println( "t1 should be a tree with 6 nodes; t2 is empty" );
        System.out.println( "----------------" );
        System.out.println( "t1" );
        t1.printInOrder( );
        System.out.println( "----------------" );
        System.out.println( "t2" );
        t2.printInOrder( );
        System.out.println( "----------------" );
        System.out.println( "t1 size: " + t1.size() );
        System.out.println( "t1 height: " + t1.height() );
    }
    
    // create a tree with 7 nodes and minimum possible height
    private static void test2(){
    	BinaryTree<Integer> t4 = new BinaryTree<Integer>( 4 );
        BinaryTree<Integer> t5 = new BinaryTree<Integer>( 5 );
        BinaryTree<Integer> t6 = new BinaryTree<Integer>( 6 );
        BinaryTree<Integer> t7 = new BinaryTree<Integer>( 7 );
        BinaryTree<Integer> t1 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t2 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t3 = new BinaryTree<Integer>(  );
        
        
        t2.merge( 2, t4, t5 );
        t3.merge( 3, t6, t7 );
        t1.merge( 1, t2, t3 );
        
        System.out.println( "t1 should be a tree with 7 nodes" );
        System.out.println( "----------------" );
        System.out.println( "t1" );
        t1.printInOrder( );
        System.out.println( "----------------" );
        System.out.println( "t1 size: " + t1.size() );
        System.out.println( "t1 height: " + t1.height() );
        
        // tesing PreOrder and PostOrder
//        System.out.println( "PreOrder" );
//        t1.printPreOrder( );
//        System.out.println( "-------------" );
//        System.out.println( "PostOrder" );
//        t1.printPostOrder( );
    }
    
    // create a tree with 7 nodes and maximum possible height
    private static void test3(){
    	BinaryTree<Integer> t1 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t2 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t3 = new BinaryTree<Integer>(  );
    	BinaryTree<Integer> t4 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t5 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t6 = new BinaryTree<Integer>(  );
        BinaryTree<Integer> t7 = new BinaryTree<Integer>( 7 );
        
        BinaryTree<Integer> temp1 = new BinaryTree<Integer>( );
        BinaryTree<Integer> temp2 = new BinaryTree<Integer>( );
        BinaryTree<Integer> temp3 = new BinaryTree<Integer>( );
        BinaryTree<Integer> temp4 = new BinaryTree<Integer>( );
        BinaryTree<Integer> temp5 = new BinaryTree<Integer>( );
        BinaryTree<Integer> temp6 = new BinaryTree<Integer>( );
        
        t6.merge(6, t7, temp6);
        t5.merge(5, t6, temp5);
        t4.merge(4, t5, temp4);
        t3.merge(3, t4, temp3);
        t2.merge(2, t3, temp2);
        t1.merge(1, t2, temp1);
        System.out.println( "t1 should be a tree with 7 nodes" );
        System.out.println( "----------------" );
        System.out.println( "t1" );
        t1.printInOrder( );
        System.out.println( "----------------" );
        System.out.println( "t1 size: " + t1.size() );
        System.out.println( "t1 height: " + t1.height() );
    }
}