import java.util.Scanner;
import java.util.PriorityQueue;

public class BessieInterview1 {

    static class Farmer implements Comparable<Farmer> {
        int id;
        int availableAt;

        Farmer(int id, int availableAt) {
            this.id = id;
            this.availableAt = availableAt;
        }

        @Override
        public int compareTo(Farmer other) {
            return Integer.compare(this.availableAt, other.availableAt);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of cows
        int K = scanner.nextInt(); // Number of farmers

        int[] interviewDurations = new int[N];
        for (int i = 0; i < N; i++) {
            interviewDurations[i] = scanner.nextInt();
        }

        PriorityQueue<Farmer> farmerQueue = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            farmerQueue.offer(new Farmer(i, 0)); // Farmers are available at time 0
        }

        int startTime = 0;
        int[] potentialFarmers = new int[K];

        for (int i = 0; i < N; i++) {
            Farmer nextFarmer = farmerQueue.poll();
            if (i == N - 1) {
                startTime = nextFarmer.availableAt; // Bessie's interview start time
            }
            for (int j = 0; j < K; j++) {
                if (nextFarmer.availableAt + interviewDurations[i] >= potentialFarmers[j]) {
                    potentialFarmers[j] = 1; // This farmer could interview Bessie
                }
            }
            nextFarmer.availableAt += interviewDurations[i];
            farmerQueue.offer(nextFarmer);
        }

        System.out.println(startTime);

        for (int potentialFarmer : potentialFarmers) {
            System.out.print(potentialFarmer);
        }
    }
}
