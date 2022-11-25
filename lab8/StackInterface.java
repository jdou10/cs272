// Lab 8 - Jingru - Dou - Stacks.zip

public interface StackInterface<T> {

   // 5 functions push pop top size and isEmpty.
   void push(T element);

   T pop() throws NullPointerException;

   T top() throws NullPointerException;

   int size();

   boolean isEmpty();
}
