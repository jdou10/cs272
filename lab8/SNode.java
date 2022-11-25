// Lab 8 - Jingru - Dou - Stacks.zip

public class SNode<T> {
    private T element;
    private SNode<T> next;

    
    //construct
    //@param element:node data value
     
    public SNode(T element){
        element = element;
        next = null;
    }

   
    // get the data value stored in the node
    //  @return:node value
      
    public T getElement() {
        return element;
    }

    
      // get the reference to the next node,if has no next node return null
//      @return:next node
     
    public SNode<T> getNext() {
        return next;
    }

    
      // update node value by the parameter
//       @param element:new node value
//      
    public void setElement(T element){
        element = element;
    }

    
      // update the reference to the next node by new node
//       @param next:new node reference
     
    public void setNext(SNode<T> next){
        next = next;
    }

}
