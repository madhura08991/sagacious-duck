//Builds binary search tree from a given array

import java.io.*;
import java.util.*;

class BNode {
  private int value;
  private BNode parent;
  private BNode left;
  private BNode right;
  
  BNode() {
    parent = null;
    left = null;
    right = null;
    
  }
  
  BNode(int value) {
    this.value = value;
    parent = new BNode();
    left = new BNode();
    right = new BNode();
  }
  
  public int getValue() {
    return this.value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
  public BNode getParent() {
    return this.parent;
  }
  
  public void setParent(BNode parent) {
    this.parent = parent;
  }
  
  public BNode getLeft() {
    return this.left;
  }
  
  public void setLeft(BNode left) {
    this.left = left;
  }  
  
  public BNode getRight() {
    return this.right;
  }
  
  public void setRight(BNode right) {
    this.right = right;
  }
  
}
  
  class BinaryTree {
    private List<BNode> treeBNodes;
    private BNode root;
    
    BinaryTree(List<BNode> treeBNodes) {
      this.treeBNodes = treeBNodes;
      this.root = new BNode();
    }
    
    BinaryTree() {
      this.treeBNodes = new ArrayList<BNode>();
      this.root = new BNode();
    }
    
    public BNode getRoot() {
      return this.root;
    }
    
    public void setRoot(BNode root) {
      this.root = root;
    }
    
    public List<BNode> getTreeBNodes() {
      return this.treeBNodes;
    }
    
    public void setTreeBNodes(List<BNode> treeBNodes) {
      this.treeBNodes = treeBNodes;
    }
  } 


class BinarySearchTree {
  public static void main(String[] args) {
    int[] sortedArray = new int[] {2,4,6,7,10,13};
    BinaryTree bst = new BinaryTree();
    bst = buildBst(bst, sortedArray);
    inOrderTraversal(bst, bst.getRoot());
  }
  
  public static void inOrderTraversal(BinaryTree bst, BNode start) {
	  if(start == null) {
		  return;
	  }
	  
	  if(start.getLeft() != null && start.getRight() != null) {
		  inOrderTraversal(bst, start.getLeft());
		  System.out.println(start.getValue());
		  inOrderTraversal(bst, start.getRight());
	  }
	  else
	  {
		  return;
	  }
  }
  
  public static BinaryTree buildBst(BinaryTree bst, int[] sortedArray) {
    if(sortedArray.length == 0) {
      return null;
    }
    
    if(sortedArray.length == 1) {
      BNode BNode = new BNode(sortedArray[0]);
      BinaryTree tree = new BinaryTree();
      tree.setRoot(BNode);
      return tree;
    }
    
    if(sortedArray.length == 2) {
      BNode root = new BNode(sortedArray[0]);
      BinaryTree tree = new BinaryTree();
      tree.setRoot(root);
      if(sortedArray[0]>=sortedArray[1]) {
        BNode leftChild = new BNode(sortedArray[1]);
        root.setLeft(leftChild);
        leftChild.setParent(root);
      }
      else {
        BNode rightChild = new BNode(sortedArray[1]);
        root.setRight(rightChild);
        rightChild.setParent(root);
      }
      return tree;
      
    }
    
    int arrayLength = sortedArray.length;
    int middleElement = sortedArray[arrayLength/2];
    int[] lowerArray = Arrays.copyOfRange(sortedArray, 0, arrayLength/2);
    int[] upperArray = Arrays.copyOfRange(sortedArray, arrayLength/2+1, arrayLength);
    bst.setRoot(new BNode(middleElement));
    BinaryTree leftSubTree = new BinaryTree();
    leftSubTree = buildBst(leftSubTree, lowerArray);
    BinaryTree rightSubTree = new BinaryTree();
    rightSubTree = buildBst(rightSubTree, upperArray); 
    bst.getRoot().setLeft(leftSubTree.getRoot());
    bst.getRoot().setRight(rightSubTree.getRoot());
    leftSubTree.getRoot().setParent(bst.getRoot());
    rightSubTree.getRoot().setParent(bst.getRoot());
    return bst;
  }
}
