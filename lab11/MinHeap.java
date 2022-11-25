// Dou Jingru
// CS 272
// Lab 11
// 30 Novemeber 2021

import java.util.ArrayList;

public class MinHeap {
   private final ArrayList<Integer> heap;

   public MinHeap() {
      this.heap = new ArrayList<>();
   }

   public void add(int e) {
      this.heap.add(e);
      int idx = this.heap.size() - 1;
      while (idx > 0) {
         int pos = (idx - 1) / 2;
         int father = this.heap.get(pos);
         if (e < father) {
            this.heap.set(idx, father);
            this.heap.set(pos, e);
            idx = pos;
         } else {
            break;
         }
      }
   }


   public boolean empty() {
      return this.heap.isEmpty();
   }

   public void swap(int left, int right) {
      int element = this.heap.get(left);
      this.heap.set(left, this.heap.get(right));
      this.heap.set(right, element);
   }

   public int size() {
       return this.heap.size();
   }

   public Integer remove() {
      if (this.heap.isEmpty()) {
         return null;
      }
      if (this.heap.size() == 1) {
         int element = this.heap.get(0);
         this.heap.remove(0);
         return element;
      }
      int result = this.heap.get(0);
      this.heap.set(0, this.heap.get(this.heap.size() - 1));
      this.heap.remove(this.heap.size() - 1);
      int root = 0;
      int left = 1;
      int right = 2;
      while (root < this.size()) {
         left = root * 2 + 1;
         right = root * 2 + 2;
         if (left >= this.size()) {
            break;
         }
         if (this.heap.get(left) < this.heap.get(root)) {
            if (right < this.size()) {
               if (this.heap.get(right) < this.heap.get(root) && this.heap.get(right) < this.heap.get(left)) {
                  this.swap(right, root);
                  root = right;
                  continue;
               }
            }
            this.swap(left, root);
            root = left;
         } else {
            if (right < this.size() && this.heap.get(right) < this.heap.get(root)) {
               this.swap(right, root);
                  root = right;
               } else {
                  break;
               }
         }
      }
      return result;
   } // end remove

   public static void main(String[] args) {
      MinHeap heap = new MinHeap();
      heap.add(22);
      heap.add(11);
      heap.add(66);
      heap.add(55);
      heap.add(33);
      heap.add(44);
      while (!heap.empty()) {
         System.out.println(heap.remove());
      }
   }// end main
}// end class
