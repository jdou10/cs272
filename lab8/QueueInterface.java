// Lab 8 - Jingru - Dou - Queues.zip

public interface QueueInterface<T> {

    void enqueue(T element);

    T dequeue();

    T front();

    int size();

    boolean isEmpty();
}
