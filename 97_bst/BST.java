/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if (_root == null) { //empty tree
      _root = newNode;
      return;
    }
    insert(_root, newNode);
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    //smaller
    if (newNode.getValue() < stRoot.getValue()) {
      //if no left child, make newNode the left child
      if (stRoot.getLeft() == null) {
        stRoot.setLeft(newNode);
      }
      else { //go down the left subtree
        insert(stRoot.getLeft(), newNode);
        return;
      }
    }
    //larger
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if (stRoot.getRight() == null) {
        stRoot.setRight(newNode);
      }
      else { //go down right subtree
        insert(stRoot.getRight(), newNode);
        return;
      }
    }
  }//end insert()



  public void remove(int num) {
    TreeNode remNum = search(num);
    if (remNum == null) { //exist?
      System.out.println("running!");
      return;
    } else {
      _root = remove(num, _root);
    }
  }

  public TreeNode remove(int num, TreeNode tn) {
    //System.out.println("running!");
    if (num < tn.getValue()) {
      tn.setLeft(remove(num, tn.getLeft()));
    }
    else if (num > tn.getValue()) {
      tn.setRight(remove(num, tn.getRight()));
    }
    else { //found
      if(tn.getLeft() == null && tn.getRight() == null) { //no children
          return null;
      }
      if (tn.getLeft() == null) { //one child
        return tn.getRight();
      }
      if (tn.getRight() == null) { //one child
        return tn.getLeft();
      }
      else { //two children
        TreeNode temp = tn.getLeft();
        while (temp.getRight() != null) {
          temp = temp.getRight();
        }
        tn.setValue(temp.getValue());
        //temp.set(temp.getLeft());
        System.out.println("removed!");
        tn.setLeft(remove(tn.getValue(), tn.getLeft()));
      }
    }

    return tn;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if (currNode == null) {
      return;
    }
    System.out.print(currNode.getValue() + " ");
    preOrderTrav(currNode.getLeft());
    preOrderTrav(currNode.getRight());
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav(_root);
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if (currNode == null) {
      return;
    }
    inOrderTrav(currNode.getLeft());
    System.out.print(currNode.getValue() + " ");
    inOrderTrav(currNode.getRight());
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav(_root);
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if (currNode == null) {
      return;
    }
    postOrderTrav(currNode.getLeft());
    postOrderTrav(currNode.getRight());
    System.out.print(currNode.getValue() + " ");
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
      return search(_root, target);
    }

    TreeNode search( TreeNode currNode, int target )
    {
      if (currNode == null) {
        return null;
      }
      if (currNode.getValue() == target) {
        return currNode;
      }
      if (target < currNode.getValue()) { //go left
        return search(currNode.getLeft(), target);
      } else { //go right
        return search(currNode.getLeft(), target);
      }
    }//end of search


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
    	return height (_root);
    }

    public int height(TreeNode currNode) {
      if (currNode == null) {
        return 0;
      }
      return Math.max(height(currNode.getLeft()), height(currNode.getRight())) + 1;
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
    	return numLeaves(_root);
    }

    public int numLeaves(TreeNode currNode)
    {
      if (currNode == null) {
        return 0;
      }
      if (currNode.getLeft() == null && currNode.getRight() == null) { //leaf
        return 1;
      }
      return numLeaves(currNode.getLeft()) + numLeaves(currNode.getRight());
    }

  //main method for testing
  public static void main( String[] args )
  {

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );

      /**

          4
         / \
        2  5
       /\   \
      1 3    6

      **/

      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
      /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

      //test new methods
      System.out.println("search for 2: " + arbol.search(2));
      System.out.println("search for 100: " + arbol.search(100)); //null
      System.out.println("num of leaves: " + arbol.numLeaves()); //3
      System.out.println("height: " + arbol.height()); //3

      System.out.println("Tree: ");
  	  arbol.inOrderTrav();

    	arbol.remove(2);
    	System.out.println("\nRemoved 2:");
      arbol.inOrderTrav();
  }

}//end class
