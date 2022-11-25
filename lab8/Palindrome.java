// Lab 8 - Jingru - Dou - Queues.zip

import java.util.Scanner;

public class Palindrome {

    public static boolean is_palindrome(String words) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        LinkStack<String> stack = new LinkStack<>();
        words = words.toLowerCase();
        String word = "";
        for (int i = 0; i < words.length(); ++i) {
            char tmp = words.charAt(i);
            if (tmp == '\'' || (tmp >= 'a' && tmp <= 'z')) {
                word = word + tmp;
            } else {
                if (!word.isEmpty()) {
                    queue.enqueue(word);
                    stack.push(word);
                    word = "";
                }
            }
        }
        if (!word.isEmpty()) {
            queue.enqueue(word);
            stack.push(word);
        }

        while (!stack.isEmpty() && (!queue.isEmpty())) {
            if (queue.front().equals(stack.top())) {
                queue.dequeue();
                stack.pop();
            } else {
                break;
            }
        }
        return stack.isEmpty() && queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("enter your word by word sentence: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println("detect result:" + is_palindrome(sentence));
    }

}
