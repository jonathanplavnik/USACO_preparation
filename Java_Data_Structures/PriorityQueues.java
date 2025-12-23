import java.util.*;
public class PriorityQueues {
    public static void main(String[] args) {

        Queue<Double> queue = new PriorityQueue<>();

        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        
        Queue<Double> queueReverse = new PriorityQueue<>(Collections.reverseOrder());

        queueReverse.offer(3.0);
        queueReverse.offer(2.5);
        queueReverse.offer(4.0);
        queueReverse.offer(1.5);
        queueReverse.offer(2.0);

        while(!queueReverse.isEmpty()) {
            System.out.println(queueReverse.poll());
        }

        Queue<String> queueLetters = new PriorityQueue<>();

        queueLetters.offer("B");
        queueLetters.offer("C");
        queueLetters.offer("A");
        queueLetters.offer("F");
        queueLetters.offer("D");

        while(!queueLetters.isEmpty()) {
            System.out.println(queueLetters.poll());
        }
        
    }
}
