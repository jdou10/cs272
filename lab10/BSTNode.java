// Dou Jingru
// CS 272
// Lab 10
// 8 Novemeber 2021

public class BSTNode {
   private int key;
   private BSTNode left;
   private BSTNode right;
   public BSTNode(int key) {
      super();
      this.key = key;
      this.left = null;
      this.right = null;
   }
   public BSTNode(int key, BSTNode left, BSTNode right) {
      super();
      this.key = key;
      this.left = left;
      this.right = right;
   }
   public int getKey() {
      return key;
   }
   public void setKey(int key) {
      this.key = key;
   }
   public BSTNode getLeft() {
      return left;
   }
   public void setLeft(BSTNode left) {
      this.left = left;
   }
   public BSTNode getRight() {
      return right;
   }
   public void setRight(BSTNode right) {
      this.right = right;
   }
} // end class