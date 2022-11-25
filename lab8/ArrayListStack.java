// Lab 8 - Jingru - Dou - Stacks.zip

import java.util.ArrayList;

public class ArrayListStack<T> implements StackInterface<T>{
    private final ArrayList<T> list;

    public ArrayListStack(){
        list = new ArrayList<>();
    }
    @Override
    public void push(T element) {
        list.add(0, element);
    }

    @Override
    public T pop() throws NullPointerException {
        if (!list.isEmpty()) {
            T element = list.get(0);
            list.remove(element);
            return element;
        }
        throw new NullPointerException("no element iin stack");
    }

    @Override
    public T top() throws NullPointerException {
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NullPointerException("no element in stack");
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return !list.isEmpty();
    }
}
