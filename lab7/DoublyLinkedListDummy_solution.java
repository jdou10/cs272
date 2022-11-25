package lab7;


public class DoublyLinkedListDummy {
	private DIntNode head;
	private DIntNode tail;
	
	public DoublyLinkedListDummy( ){
		head = new DIntNode();
		tail = new DIntNode();
		head.setNext(tail);
		tail.setPrev(head);}
	
	public DIntNode getHead() {
		return head;
	}
	
	public DIntNode getTail() {
		return tail;
	}
	
	public void setHead(DIntNode node) {
		head = node;
	}
	
	public void setTail(DIntNode node) {
		tail = node;
	}
	
	public void addEnd(int e) {
		DIntNode cur = tail.getPrev();
		
		
		DIntNode newNode = new DIntNode(e, cur, tail);
		// link next-to-last to new node
		cur.setNext(newNode);

		// link tail to new node
		tail.setPrev(newNode); 

	}
	public String toString() {
	    String s = "fwd: ";
	    DIntNode c1 = head.getNext();
	    while (c1 != tail) {
	      s += c1.getData();
	      c1 = c1.getNext();
	      if (c1 != tail)
	        s += "<->";
	    }
	    s += "\nbwd: ";
	    
	    DIntNode c2 = tail.getPrev();
	    while (c2 != head) {
	      s += c2.getData();
	      c2 = c2.getPrev();
	      if (c2 != head)
	        s += "<->";
	    }
	    
	    return s;
	  }
	public void removeFromHead() {
		if(head.getNext() == tail)
			return;
		DIntNode cur = head.getNext();
		DIntNode next = cur.getNext();
		head.setNext(cur.getNext());
		next.setPrev(head);

	}
	
	public int countOccurrence(int e) {
		int foundNum = 0;
		
		DIntNode cur = head.getNext();
		while (cur != tail) {
			if (cur.getData() == e)
				foundNum++;
			cur = cur.getNext();
		}
		return foundNum;
	}

	public boolean removeAll(int e) {
		boolean remove = false;
		
		DIntNode cur = head.getNext();
		while (cur != tail) {
			if (cur.getData() == e) {
				cur.getPrev().setNext(cur.getNext());
				cur.getNext().setPrev(cur.getPrev());
				remove = true;
			} 

			cur = cur.getNext();

		}
		return remove;
	}
	public int getSize() {
		int count = 0;
		DIntNode curCount = head.getNext();
		while (curCount != tail) {
			count++;
			curCount = curCount.getNext();
		}
		return count;
	}
	public DoublyLinkedListDummy truncate(int i)
	   {
		  if(i<0 || i>getSize()) {
			  return null;
		  }
		  DoublyLinkedListDummy newList = new DoublyLinkedListDummy();
	   
	      DIntNode temp = head.getNext();
	      DIntNode temp1 = head.getNext();
	      for(int j = 0; j < i - 1; j++)
	      {
	         temp = temp.getNext();
	         temp1 = temp1.getNext();
	      }
	      
	      temp1 = temp1.getNext();
	      
	      while(temp1 != tail)
	      {
	         newList.addEnd(temp1.getData());
	         temp1 = temp1.getNext();
	      }
	      
	      temp.setNext(tail);
	      tail.setPrev(temp);
	      
	      return newList;
	   }
	
	public void absorb(DoublyLinkedListDummy l2) {
	  DIntNode l2head = l2.getHead();
      DIntNode temp = l2head.getNext(); 
      
      while(temp != l2.tail)
      {
         this.addEnd(temp.getData());
         
         temp = temp.getNext();
      }
      l2head.setNext(l2.getTail());
      l2.getTail().setPrev(l2head);
			
	}

	public static void main ( String [ ] args ) {
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		
		test.addEnd(1);
		
		test.addEnd(2);
		test.addEnd(2);
		test.addEnd(3);
		test.addEnd(3);
		
		
		System.out.println(test.toString());
		
		System.out.println(test.toString());
		

		
		System.out.println(test.countOccurrence(0));
		
		System.out.println(test.truncate(3));
		System.out.println(test);
		
	}
}
