// Lab 8 - Jingru - Dou - Queues.zip

public class QueueTest {
    public static void main(String[] args){
       try {
           LinkedQueue<String> queue = new LinkedQueue<>();
           queue.enqueue("queue");
           queue.enqueue("stack");
           queue.enqueue("queue stack");
           while (!queue.isEmpty()) {
               System.out.println("queue size:" + queue.size() + "\t queue front:" + queue.front());
               queue.dequeue();
           }
           //will throw exception
           queue.dequeue();
       } catch (NullPointerException e) {
           System.out.println("queue exception:" + e.getMessage());
       }

    }
}
