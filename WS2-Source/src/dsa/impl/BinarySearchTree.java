package dsa.impl;


import dsa.iface.IBinarySearchTree;
import dsa.iface.INode;

public class BinarySearchTree<T extends Comparable<T>> extends ProperLinkedBinaryTree<T> implements IBinarySearchTree<T> {

	/**
	 *  1. Return the node if it is external.
	 *  2. Compare the element of the node with 'value'.
	 *  3. If the value is less than the node's element, recursively call this method to search the left sub-tree.
	 *  4. If the value is greater than the node's element, recursively call this method to search the right sub-tree.
	 *  5. If the value is equal to the node's element, we have found it! Return this node.
	 * @param node
	 * @param value
	 * @return the objected node
	 */
   protected INode<T> find( INode<T> node, T value ) {
      if(isExternal(node)) {
    	  return node;
      }
      while(node!=null && !isExternal(node)) {
    	  if(node.element().compareTo(value)>0) {
    		  node=left(node);
    	  }else if(node.element().compareTo(value)<0) {
    		  node=right(node);
    	  }else {
    		  break;
    	  }
      }
      return node;
   }
   
   /**
	 *  1. Return the node if it is external.
	 *  2. Compare the element of the node with 'value'.
	 *  3. If the value is less than the node's element, recursively call this method to search the left sub-tree.
	 *  4. If the value is greater than the node's element, recursively call this method to search the right sub-tree.
	 *  5. If the value is equal to the node's element, we have found it! Return this node.
	 * @param node
	 * @param value
	 * @return the objected node
	 */
  protected INode<T> findRecursively( INode<T> node, T value ) {
     if(isExternal(node)) {
   	  return node; 
     }
     if(node.element().compareTo(value)>0)
     {
    	 return findRecursively(left(node), value);
     }else if(node.element().compareTo(value)<0) {
    	 return findRecursively(right(node), value);
     }else {
    	 return node;
     }
  }

  /**
   * 
   * 1. Use the 'find' 'method to find the external node where this should be inserted (beginning at the root)
   * 2. Expand the external node that is found, to insert the element.
   * 3. You can use the expandExternal(INode<T>, T e) method from ProperLinkedBinaryTree for this.
   * 
   * @param node
   * @param value
   * @return 
   */
   public void insert( T value ) {
	   INode<T> temp_node = find(root(), value);
	   expandExternal(temp_node, value);
   }

   /**
    * 
    * 1. Use the 'find' method (starting at the root) to find the node that contains the value.
	* 2. If an internal node with at least one external child was returned you can remove it using the remove(INode<T> n) method from ProperLinkedBinaryTree
	* 3. If the node has two internal children, find the node with the next biggest value, swap the value and delete that node.
    * @param node
    * @param value
    * @return 
    */
   public void remove( T value ) {
	   INode<T> temp_node = find(root(), value);
	   INode<T> node = null;
	   if(temp_node==null) {
		   throw new RuntimeException("The tree does not contain the value");
	   }else {
		   if(hasLeft(temp_node) && hasRight(temp_node)) {
			   node = findMin(right(temp_node));
			   replace(temp_node, node.element());
			   remove(node);
		   }else {
			   remove(temp_node);
		   }
	   }
   }
   
   private INode<T> findMin(INode<T> node){
	   if(isExternal(node)) {
		   return parent(node);
	   }else if(!hasLeft(node)) {
		   return node;
	   }else {
		   return findMin(left(node));
	   }
   }

   public boolean contains( T value ) {
	   INode<T> node = find(root(), value);
	   
	   if(isInternal(node)) {
		   return true;
	   }else if(node==null){
		   return false;
	   }else {
		   return false;
	   }
   }
}