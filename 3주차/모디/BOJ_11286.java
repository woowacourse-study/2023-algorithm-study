import java.io.*;
import java.util.*;

public class BOJ_11286 {

    private static class NumberWithAbs {
        public int number;
        public int abs;
        public NumberWithAbs(int number, int abs) {
            this.number = number;
            this.abs = abs;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        PriorityQueue<NumberWithAbs> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt((NumberWithAbs n) -> n.abs)
            .thenComparingInt(n -> n.number));

        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (priorityQueue.size() == 0) {
                    bw.write("0\n");
                } else {
                    NumberWithAbs target = priorityQueue.poll();
                    bw.write(target.number + "\n");
                }
            } else {
                priorityQueue.add(new NumberWithAbs(number, Math.abs(number)));
            }
        }

        bw.flush();
        bw.close();
    }
}