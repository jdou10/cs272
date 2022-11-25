// Lab 5 - Jingru - Dou - IntNode.zip

//package CS272program.src;

public class IntNode {
	
	private int data;
	private IntNode link;
	
	// the no-argument constructor which sets the node value to be 0 and the link to be null reference
	public IntNode() {
		this.data = 0;
      this.link = null;
	}
	
	// a constructor with the given node value and the link
	public IntNode(int _data, IntNode _node) {
		this.data = _data;
      this.link=_node;
	}
	
	// get and set methods to get the node value and node link
	
	public int getData() {
		return data;
	}
	public IntNode getLink() {
		return link;
	}
	
	public void setData(int newData) {
		this.data = newData;
	}
	public void setLink(IntNode newLink) {
		this.link = newLink;
	}
	
	
	
	// toString method
	public String toString() {
     String builder = "";
     IntNode start = this;
     for(; start != null; start = start.link) {
        builder += start.data;
        if(start.link != null) {
           builder += "->";
        }
     }
     return builder;		
	}
	
	// a method to add a node after the current node
	public void addNodeAfterThis(int newdata) {
		IntNode node = new IntNode(newdata, null);
      node.setLink(this.link);
      this.setLink(node);
	}
	
	// a method to remove the node after the current node
	public void removeNodeAfterThis() {
		if(this.link != null){
         this.setLink(this.link.link);
     }else {
         this.setLink(null);
     }
	}
	
	// a method to get the number of nodes in the list starting from a given node head
	public static int listLength(IntNode head) {
		IntNode node = head;
      int answer = 0;
      for(; node != null; node = node.link) {
         answer++;
      }
      return answer;

	}
	
	// a method to search a linked list
	public static boolean search(IntNode head, int data) {
		IntNode answer = null;
      for (IntNode cursor = head; cursor != null; cursor = cursor.link) {
         if(cursor.data == data) {
             answer = cursor;
             break;
         }
      }
      return answer != null;
	}
	
	// a method to find the mth-to-last element of the list
	public IntNode findMthToLast (IntNode header, int m){
	   while(header != null){
         int count = 0;
         IntNode link = header;
         while(link != null){
             link = link.link;
             if(link != null){
                 count += 1;
             }
         }
         if(count == m){
             return header;
         }
         header = header.link;
     }
     return null;
	}
   
   // a method to test whether a linked list starting 
   // from the given head is cyclic or acyclic
   public static boolean hasCycle(IntNode head) {
        boolean res = false;
        if (head != null) {
            IntNode node = head.getLink();
            while (node != null) {
                if (node == head) {
                    res = true;
                    break;
                }
                node = node.getLink();
            }
        }
        return res; // return true if it is cyclic
    }
    
    // a method to change the node value at index i
    public static void changeElement(IntNode head,int i,int newValue) {
        IntNode node = head;
        int count = 0;
        while(count < i && (node != null)){
            node = node.getLink();
            count++;
        }

        if(node != null){
            node.setData(newValue);
        }
    }
    
    //a method to modify the linked list such that all even
    // numbers appear before all the odd numbers in the modified list
    public static void segregate_even_odd(IntNode head) {
        if (head == null || head.getLink() == null) {
            return;
        }
        IntNode node = head;
        while (node != null) {
            if ((node.getData() & 1) == 1) {
                IntNode link = node.getLink();
                while (link != null) {
                    if ((link.getData() & 1) == 0) {
                        int val = node.getData();
                        node.setData(link.getData());
                        link.setData(val);
                        break;
                    } else {
                        link = link.getLink();
                    }
                }
            }
            node = node.getLink();
        }
    }
    
    // a method to reverse a linked list
    // this method should return the linked list with the new head
    public static IntNode reverse(IntNode head){
        if(head == null || head.getLink() == null) {
            return head;
        }
        IntNode prev = null;
        IntNode current_node = head;
        IntNode next = null;
        while(current_node != null) {
            next = current_node.getLink();
            current_node.setLink(prev);
            prev = current_node;
            current_node = next;
        }
        return prev;
    }
    
    // a method to swap the current node with the last node
    public void swap(){
        IntNode node = this.findMthToLast(this, 0);
        int value = node.getData();
        node.setData(this.getData());
        this.setData(value);
    }
    
    // a signly linked list, rotate the linked list counter-clockwise
    // by k nodes where k is a positive integer
    public static IntNode rotate(IntNode head, int k) {
        int length = listLength(head);
        IntNode last_node = head.findMthToLast(head, 0);
        IntNode new_last_node = head.findMthToLast(head, length - k);
        IntNode new_head_node = head.findMthToLast(head, length - k - 1);
        last_node.setLink(head);
        new_last_node.setLink(null);
        return new_head_node;
    }


   // a main method
	public static void main(String[] args) {
		IntNode node5 = new IntNode(5, null);
      IntNode node4 = new IntNode(4, node5);
      IntNode node3 = new IntNode(3, node4);
      IntNode node2 = new IntNode(2, node3);
      IntNode node1 = new IntNode(1, node2);
      System.out.println(node1.toString());
      node2.removeNodeAfterThis();
      System.out.println(node1.toString());
      node2.addNodeAfterThis(6);
      System.out.println(node1.toString());
      System.out.println("node[data:3] is in header list: " + IntNode.search(node1,3));
      System.out.println("node[data:6] is in header list: " + IntNode.search(node1,6));
      System.out.println(IntNode.listLength(node1));
      System.out.println(IntNode.listLength(node2));
      node2.setData(12);
      System.out.println(node1.toString());
      node5.setLink(new IntNode(17, null));
      System.out.println(node1.toString());
      System.out.println(node1.findMthToLast(node1,0).getData());
      System.out.println(node1.findMthToLast(node1,1).getData());
	} // end main
} // end class
