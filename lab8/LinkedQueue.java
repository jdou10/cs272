// Lab 8 - Jingru - Dou - Queues.zip

public class LinkedQueue<T> implements QueueInterface<T> {
    private SNode<T> front;
    private SNode<T> rear;
    private int size;

    public LinkedQueue(){
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        SNode<T> node = new SNode<>(element);
        if(front != null){
            rear.setNext(node);
        }else {
            front = node;
        }
        rear = node;
        size++;
    }

    @Override
    public T dequeue() {
        if (rear == null) {
            throw new NullPointerException("no element in queue");
        }
        T value = front.getElement();
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.getNext();
        }
        size--;
        return value;
    }

    @Override
    public T front() {
        if (front != null) {
            return front.getElement();
        }
        throw new NullPointerException("no element in queue");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }
}
