import java.util.*;
public class stackPractice {
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(27);
        stack.push(23);
        stack.push(56);
        stack.pop();
        stack.peek();
        stack.empty();
        stack.contains(23);

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        

    }
}
