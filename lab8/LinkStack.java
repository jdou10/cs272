// Lab 8 - Jingru - Dou - Stacks.zip

public class LinkStack<T> implements StackInterface<T>{
    private SNode<T> top;

    public LinkStack(){
        top = null;
    }

    @Override
    public void push(T element) {
        SNode<T> top = new SNode<>(element);
        top.setNext(top);
        top = top;
    }

    @Override
    public  T pop() throws NullPointerException {
        if (top != null) {
            T element = top.getElement();
            top = top.getNext();
            return element;
        }
        throw new NullPointerException("no element in stack");
    }

    @Override
    public T top() throws NullPointerException {
        if(top != null) {
            return top.getElement();
        }
        throw new NullPointerException("no element in stack");
    }

    @Override
    public int size() {
        int size = 0;
        SNode<T> tmp = top;
        while (tmp != null) {
            size++;
            tmp = tmp.getNext();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
