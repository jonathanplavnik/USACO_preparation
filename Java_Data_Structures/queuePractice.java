import java.util.*;
public class queuePractice {
    public static void main(String[] args) {
        
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(290);
        queue.offer(43);

        queue.poll();

        queue.peek();

        System.out.println(queue);
        System.out.println(queue.peek());
    }
}
