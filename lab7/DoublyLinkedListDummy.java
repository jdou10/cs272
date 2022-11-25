// Lab 7 - Jingru - Dou - DoublyLinkedListDummy.zip

public class DoublyLinkedListDummy{
    private DIntNode head;
    private DIntNode tail;

    public DoublyLinkedListDummy(){
        head = new DIntNode();
        tail = new DIntNode();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public DIntNode getHead(){
        return head;
    }
    public DIntNode getTail() {
        return tail;
    }

    public void setHead(DIntNode node) {
        if(node != null){
            node.setNext(getHead().getNext());
            getHead().getNext().setPrev(node);
            head = node;
        }
    }

    public void setTail(DIntNode node) {
        node.setPrev(getTail().getPrev());
        getTail().getPrev().setNext(node);
        tail = node;
    }

    // time complexity is O(1)
    public void addEnd(int element){
        DIntNode tmp = new DIntNode(element);
        // to update node set prev pointer and the next pointer
        tmp.setPrev(getTail().getPrev());
        tmp.setNext(getTail());
        // to update tail prev node and the tail node
        getTail().getPrev().setNext(tmp);
        getTail().setPrev(tmp);
    }

    // the time complexity is O(1)
    public void removeFromHead(){
        DIntNode tmp = getHead().getNext();
        if(tmp != getTail()) {
            getHead().setNext(tmp.getNext());
            tmp.getNext().setPrev(getHead());
        }
    }

    public String toString(){
        StringBuilder buffer = new StringBuilder();
        buffer.append("(Forward) ");
        for(DIntNode head = getHead().getNext(); head != getTail(); head = head.getNext()) {
            buffer.append(head.getData());
            if(head.getNext() != getTail()){
                buffer.append("<->");
            }else{
                buffer.append("\n");
            }
        }
        buffer.append("(Backward) ");
        for(DIntNode tail = getTail().getPrev(); tail != getHead(); tail = tail.getPrev()) {
            buffer.append(tail.getData());
            if(tail.getPrev() != getHead()) {
                buffer.append("<->");
            }
        }
        return buffer.toString();
    }

    // the time complexity is O(1)
    public int countOccurrence(int e){
        int ans = 0;
        for(DIntNode node = getHead().getNext(); node != getTail(); node = node.getNext()) {
            if (node.getData() == e) {
                ans += 1;
            }
        }
        return ans;
    }

    // the time complexity is O(n)
    public boolean removeAll(int e){
        for(DIntNode node = getHead().getNext(); node != getTail(); node = node.getNext()) {
            if(node.getData() == e) {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            }
        }
        return true;
    }

    // the time complexity is O(n)
    public DoublyLinkedListDummy truncate(int i){
        DIntNode tmp = getHead();
        for(int t = 0; t <= i; ++t) {
            tmp = tmp.getNext();
        }
        DIntNode head = tmp.getNext();
        DIntNode tail = getTail().getPrev();
        tmp.setNext(getTail());
        getTail().setPrev(tmp);
        DoublyLinkedListDummy list = new DoublyLinkedListDummy();
        list.getHead().setNext(head);
        head.setPrev(list.getHead());
        list.getTail().setPrev(tail);
        tail.setNext(list.getTail());
        return list;
    }

    // the time complexity is O(1)
    public void absorb(DoublyLinkedListDummy l2){
        DIntNode next = l2.getHead().getNext();
        DIntNode tail = l2.getTail().getPrev();
        getTail().getPrev().setNext(next);
        next.setPrev(getTail().getPrev());
        tail.setNext(getTail());
        getTail().setPrev(tail);
        l2.getHead().setNext(l2.getTail());
        l2.getTail().setPrev(l2.getHead());
    }

    public static void main(String[] args) {
        DoublyLinkedListDummy l1 = new DoublyLinkedListDummy();
        int[] arr = new int[]{1, 2, 3, 4, 1};
        for (int k : arr) {
            l1.addEnd(k);
        }
        for (int j : arr) {
            System.out.println("countOccurrence(" + j + ") = " + l1.countOccurrence(j));
        }
        l1.addEnd(5);
        System.out.println("add end:\n" + l1.toString());
        l1.removeFromHead();
        System.out.println("remove from head:\n" + l1.toString());
        l1.removeAll(1);
        System.out.println("removeAll(1):\n" + l1.toString());


        DoublyLinkedListDummy l2 = new DoublyLinkedListDummy();
        for (int i = 1; i <= 5; ++i) {
            l2.addEnd(i);
        }
        System.out.println("l2 = \n" + l2.toString());
        DoublyLinkedListDummy ans = l2.truncate(2);
        System.out.println("l2 = \n" + l2.toString());
        System.out.println("ans = \n" + ans.toString());

        DoublyLinkedListDummy l3 = new DoublyLinkedListDummy();
        for (int i = 1; i < 6; ++i) {
            l1.addEnd(i);
        }
        DoublyLinkedListDummy l4 = new DoublyLinkedListDummy();
        l4.addEnd(12);
        l4.addEnd(28);
        l4.addEnd(12);
        l4.addEnd(34);
        System.out.println("l3 = \n" + l3.toString());
        System.out.println("l4 = \n" + l4.toString());
        l3.absorb(l4);
        System.out.println("l3 = \n" + l3.toString());
        if (l4.getTail().getPrev() == l4.getHead()) {
            System.out.println("after absorb,l4 is empty");
        } else {
            System.out.println("l4 = \n" + l4.toString());
        }
    }
}