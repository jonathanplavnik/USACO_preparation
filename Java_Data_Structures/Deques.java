import java.util.*;
public class Deques {
    public static void main(String[] args) {
        //combo of a stack and queue

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        //all methods are used below

        deque.addFirst(1); //add = offer (interchangeable)
        deque.addLast(2);
        deque.addFirst(4);
        deque.removeLast();
        deque.removeFirst();
        deque.peekFirst();
        deque.peekLast();

    }
}
