import java.io.*;
import java.util.*;

public class BOJ_17298 {

    private static class NumberWithIdx {
        public int number;
        public int idx;
        public NumberWithIdx(int number, int idx) {
            this.number = number;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<NumberWithIdx> stack = new ArrayDeque<>();

        int[] NGE = new int[N];
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peekLast().number < number) {
                NumberWithIdx previous = stack.pollLast();
                NGE[previous.idx] = number;
            }
            stack.add(new NumberWithIdx(number, i));
        }

        while (!stack.isEmpty()) {
            NumberWithIdx previous = stack.pollLast();
            NGE[previous.idx] = -1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(NGE[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
