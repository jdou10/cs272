// Dou Jingru - CS 272 - Lab 10 - 14 Novemeber 2021

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;

/**
 *  Node for Binary Tree
 * 
 */
class BSTNode{
	private int data;   //the element value for this node
	private BST left;	//the left child of this node
	private BST right;	//the right child of this node
	
	/**
	 * No-argument constructor
	 */
	public BSTNode(){
		data = 0; 
		left = new BST();
		right = new BST();
	}
	
	/**
	 * Constructor with the initial element
	 * @param initData: the initial element
	 */
	public BSTNode(int initData){
		data = initData; 
		left = new BST();
		right = new BST();
	}
	
	/**
	 * Constructor with the initial element, initial left and right children
	 * @param initData: the initial element
	 * @param initParent: the initial parent tree
	 * @param initLeft: left child
	 * @param initRight: right child
	 */
	public BSTNode(int initData, BST initLeft, BST initRight){
		data = initData;
		left = initLeft;
		right = initRight;
	}

	/**
	 * Evaluate whether this node is a leaf node or not
	 * @return true if it is a leaf node; otherwise, return false.
	 */
	public boolean isLeaf()
	{
		return (((left==null)||(left!=null && left.root==null))
				&&((right==null)||(right!=null && right.root==null)));
	}
	
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param set the element in this node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the left child
	 */
	public BST getLeft() {
		return left;
	}

	/**
	 * @param the left child to be set
	 */
	public void setLeft(BST left) {
		this.left = left;
	}

	/**
	 * @return the right child
	 */
	public BST getRight() {
		return right;
	}

	/**
	 * @param the right child to be set
	 */
	public void setRight(BST right) {
		this.right = right;
	}
	
	
	/**
	 * Convert this BTNode to a string
	 */
	public String toString()
	{
		String str="";
		
		if((left==null)||(left!=null && left.root==null)) str +="(null)";
		else str +="("+left.root.getData()+")";
		
		str += data;
		
		if((right==null)||(right!=null&&right.root==null)) str +="(null)";
		else str +="("+right.root.getData()+")";
		
		return str;
	}
}


/**
 * The class for Binary Search Tree
 *
 */
public class BST {
	protected BSTNode root; //the tree root
	
	
	/**
	 * Get the left subtree of this tree
	 * @return the left subtree of this tree
	 */
	private BST getLeftSubtree(){
		return root.getLeft();
	}
	
	/**
	 * Get the right subtree of this tree
	 * @return the right subtree of this tree
	 */
	private BST getRightSubtree(){
		return root.getRight();
	}
	
	/**
	 * Print the tree using in-order traversal strategy
	 */
	public void inOrderPrt(){
		inOrderPrt(0);
	}
	
	/**
	 * private, recursive function
	 *     I slightly changed the method to print right subtree first
	 *     It is to make the display more easier to read
	 * 
	 * @param node
	 * @param indentation
	 * @param branch
	 */
	private void inOrderPrt(int indentation){
		if(root!=null){
			if(getRightSubtree()!=null) getRightSubtree().inOrderPrt(indentation+1);
			
			for(int i=0;i<indentation*4;i++) System.out.print(" ");
			
			System.out.println(root.getData());
			
			if(getLeftSubtree()!=null) getLeftSubtree().inOrderPrt(indentation+1);
		}
	}
	
   /**
	 * find element in the tree is equal to e,if is equal not add
	 *
	 * @param root:tree root node
	 * @param e:new     element to add
	 * @return
	 */
	public boolean insert(BSTNode root, int e) {
		if (root.getData() == e) {
			return false;
		} else if (root.getData() > e) {
			if (root.getLeft().root == null) {
				root.getLeft().root = new BSTNode(e);
				return true;
			} else {
				return insert(root.getLeft().root, e);
			}
		} else {
			if (root.getRight().root == null) {
				root.getRight().root = new BSTNode(e);
				return true;
			} else {
				return insert(root.getRight().root, e);
			}
		}
	}

	/**
	 * insert new element to binary tree,if exist return false
	 *
	 * @param e
	 * @return
	 */
	public boolean insert(int e) {
		if (this.root == null) {
			this.root = new BSTNode(e);
			return true;
		}
		return insert(this.root, e);
	}

	/**
	 * search the node whose node data is e and return this node
	 *
	 * @param bst:root node of binary search tree
	 * @param e:target node data
	 * @return:target node whose data is e if not exist return null
	 */
	public BSTNode search(BSTNode bst, int e) {
		if (bst == null) {
			return null;
		}
		if (bst.getData() == e) {
			return bst;
		} else if (bst.getData() < e) {
			return search(bst.getRight().root, e);
		} else {
			return search(bst.getLeft().root, e);
		}
	}

	/**
	 * get the node whose data is e
	 *
	 * @param e:target data
	 * @return:the node whose data is e if not exist return null
	 */
	public BSTNode searchRecursion(int e) {
		// The current time complexity is O(log2n)
		return search(this.root, e);
	}

	/**
	 * get the node whose data is e  by non recursion
	 *
	 * @param e:target data
	 * @return:target node whose data is e if not exist return null
	 */
	public BSTNode searchNonRecursion(int e) {
		BSTNode node = this.root;
		while (node != null) {
			if (node.getData() == e) {
				break;
			} else if (node.getData() < e) {
				if (node.getRight() != null) {
					node = node.getRight().root;
				} else {
					node = null;
				}
			} else {
				if (node.getLeft() != null) {
					node = node.getLeft().root;
				} else {
					node = null;
				}
			}
		}
		return node;
	}

	
	/**
	 * Debug function, print the tree for debugging purpose
	 */
	public String toString()
	{
		if(root!=null) return root.toString();
		else return null;
	}
	
   /**
	 * get the tree total nodes
	 *
	 * @param bst:tree root node
	 * @return
	 */
	public int countNodes(BSTNode bst) {
		if (bst == null) {
			return 0;
		}
		return countNodes(bst.getLeft().root) + 1 + countNodes(bst.getRight().root);
	}


	/**
	 * find the kth node in binary search tree,is k is out of index range return null
	 *
	 * @param bst:binary search tree
	 * @param k:node     position
	 * @return: the kth node in binary search tree
	 */
	public static BSTNode findKthNode(BST bst, int k) {
		if (bst.root == null) {
			return null;
		}
		int counts = bst.countNodes(bst.root.getLeft().root);
		if (counts + 1 == k) {
			return bst.root;
		} else if (counts >= k) {
			return findKthNode(bst.getLeftSubtree(), k);
		} else {
			return findKthNode(bst.getRightSubtree(), k - counts - 1);
		}
	}

	/**
	 * return the sum of node data
	 *
	 * @param bst
	 * @return
	 */
	public int sum(BSTNode bst) {
		if (bst == null) {
			return 0;
		}
		return sum(bst.getLeft().root) + bst.getData() + sum(bst.getRight().root);
	}

	/**
	 * @return:the sum of the binary search tree's node data
	 */
	public int sum() {
		return sum(this.root);
	}

	/**
	 * get the minimum data node of current binary search tree
	 *
	 * @param node:root node of binary search tree
	 * @return
	 */
	private BSTNode findMinNode(BSTNode node) {
		if (node == null) {
			return null;
		}
		if (node.getLeft().root == null) {
			return node;
		}
		return findMinNode(node.getLeft().root);
	}


	/**
	 * remove the node whose data is e and return the root node after removing operation
	 *
	 * @param e:node      data
	 * @param node:binary search tree root node
	 * @return:the root node after removing
	 */
	public BSTNode remove(int e, BSTNode node) {
		if (node == null) {
			return null;
		}
		if (e > node.getData()) {
			node.getRight().root = remove(e, node.getRight().root);
		} else if (e < node.getData()) {
			node.getLeft().root = remove(e, node.getLeft().root);
		} else {
			if (node.getLeft().root != null && node.getRight().root != null) {
				node.setData(findMinNode(node.getRight().root).getData());
				node.getRight().root = remove(node.getData(), node.getRight().root);
			} else {
				node = (node.getLeft().root != null) ? node.getLeft().root : node.getRight().root;
			}
		}
		return node;
	}

	/**
	 * remove the node whose data is e from binary search tree return true else return false
	 *
	 * @param e:the node to be removed
	 * @return:if remove success return true else return false
	 */
	public boolean remove(int e) {
		BSTNode node = this.searchNonRecursion(e);
		if (node == null) {
			return false;
		}
		this.root = remove(e, this.root);
		return true;
	}

	///////////////////////////////////////
    ///////////////////////////////////////
	// Please add the functions required for your lab homework here.
	/**
	 * Test cases provided by the instructor
	 * @throws Exception
	 */
	private static void test1() throws Exception{
		BST tree = new BST();
		System.out.println("Initial tree:");
		tree.inOrderPrt(); //test inOrder traversal
		
		boolean rc = true;
		
		//test 1: insert method, and test 2 in-order traversal
		rc = tree.insert(12); System.out.println("\nInsert 12, inserted="+rc+", after adding 12:"); tree.inOrderPrt();
		rc = tree.insert(6);  System.out.println("\nInsert 6, inserted="+rc+", after adding 6:"); tree.inOrderPrt();
		rc = tree.insert(19); System.out.println("\nInsert 19, inserted="+rc+", after adding 19:"); tree.inOrderPrt();
		rc = tree.insert(4);  System.out.println("\nInsert 4, inserted="+rc+", after adding 4:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8, inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(16); System.out.println("\nInsert 16, inserted="+rc+", after adding 16:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8 (second), inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(5);  System.out.println("\nInsert 5, inserted="+rc+", after adding 5:"); tree.inOrderPrt();
		rc = tree.insert(9);  System.out.println("\nInsert 9, inserted="+rc+", after adding 9:"); tree.inOrderPrt();
		rc = tree.insert(20);  System.out.println("\nInsert 20, inserted="+rc+", after adding 20:"); tree.inOrderPrt();
		
		System.out.println("Inorder traversal results:");
		tree.inOrderPrt(); 
		System.out.print("\n\n");
		
		//test 3: search method
		BSTNode node = tree.searchRecursion(6);
		System.out.println("searchRecursion 6, node="+node);
		node = tree.searchRecursion(22);
		System.out.println("searchRecursion 22, node="+node);
		node = tree.searchRecursion(8);
		System.out.println("searchRecursion 8, node="+node+"\n");
		
		node = tree.searchNonRecursion(6);
		System.out.println("searchNonRecursion 6, node="+node);
		node = tree.searchNonRecursion(22);
		System.out.println("searchNonRecursion 22, node="+node);
		node = tree.searchNonRecursion(8);
		System.out.println("searchNonRecursion 8, node="+node);
		
		//test 4: remove method
		rc = tree.remove(30); //test case 0: e does not exist
		System.out.println("\nRemove 30, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(20); //test case 1: leaf
		System.out.println("\nRemove 20, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(4); //test case 2: left is empty
		System.out.println("\nRemove 4, rc="+rc);
		tree.inOrderPrt();
		
		
		rc = tree.remove(19); //test case 3: right is empty
		System.out.println("\nRemove 19, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(6); //test case 4: no subtree is empty
		System.out.println("\nRemove 6, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(12); //more tests: remove root
		System.out.println("\nRemove 12, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(5); //more tests
		System.out.println("\nRemove 5, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		rc = tree.remove(16); //more tests
		System.out.println("\nRemove 16, rc="+rc);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("\nAdding a series of numbers:");
		tree.insert(30);
		tree.insert(20);tree.insert(10);tree.insert(25);tree.insert(28);tree.insert(24);
		tree.insert(11);tree.insert(5);tree.insert(11);tree.insert(12);
		tree.insert(50);tree.insert(40);tree.insert(35);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.print("sum="+tree.sum()+"\n");
		System.out.print("\n\n");
		
		System.out.println("\nRemove 20 (removeNode case 4):");
		tree.remove(20);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("Inorder traversal results: ");
		tree.inOrderPrt();
		System.out.print("\n");
		System.out.print("sum="+tree.sum()+"\n");
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//You need to let your program pass the  test cases in this function
		test1(); 
		
		//You can add your own test cases here. 
		//test find kth element way
		BST tree = new BST();
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(30);
		numbers.add(20);
		numbers.add(15);
		numbers.add(15);
		numbers.add(25);
		numbers.add(35);
		numbers.add(40);
		numbers.add(32);
		numbers.add(66);
		numbers.add(54);
		numbers.add(22);
		numbers.add(50);
		for (Integer number : numbers) {
			boolean rc = tree.insert(number);
			System.out.println("\ninsert " + number + ", inserted=" + rc + ", after adding " + number + ":");
			tree.inOrderPrt();
			System.out.println("total tree sum is[" + tree.sum() + "]");
		}
		System.out.println("test find kth tree, initial tree:");
		tree.inOrderPrt();
		System.out.println();

		//test findKthNode
		ArrayList<Integer> positions = new ArrayList<>();
		positions.add(0);
		positions.add(4);
		positions.add(7);
		positions.add(20);
		for (Integer position : positions) {
			BSTNode ans = findKthNode(tree, position);
			if (ans != null) {
				System.out.println("bst node " + ans + " at position " + position);
			} else {
				System.out.println("non bst node at position " + position);
			}
		}
		System.out.println();


		for (Integer num : numbers) {
			boolean rc = tree.remove(num);
			System.out.println("\nremove " + num + ", removed=" + rc + ", after removing " + num + ":");
			tree.inOrderPrt();
		}
		System.out.println();
	}

}
