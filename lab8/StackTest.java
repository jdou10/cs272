// Lab 8 - Jingru - Dou - Stacks.zip

public class StackTest {
    public static void main(String[] args) {
        ArrayListStack<Integer> stack1 = new ArrayListStack<>();
        try {
            for (int i = 0; i < 3; ++i) {
                stack1.push(i);
            }
            for (int i = 0; i < 3; ++i) {
                System.out.println("current top element in array list stack:" + stack1.top());
                stack1.pop();
            }
            stack1.pop();
        } catch (NullPointerException e){
            System.out.println("exception error message:"+e.getMessage());
        }

        System.out.println("----------------------------------------");
        LinkStack<Integer> stack = new LinkStack<>();
        for (int i = 0; i < 4; ++i) {
            stack.push(i);
        }
        for (int i = 0; i < 4; ++i) {
            System.out.println("current top element in link stack:" + stack.top());
            stack.pop();
        }

    }
}
