import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026 {
    static int N;
    public static void main(String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        final var A = new ArrayList<Integer>();
        final var B = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        final var sortB = new ArrayList<>(B);
        sortB.sort(Collections.reverseOrder());
        final var copyOfB = new ArrayList<>(B);
        final var sortIndex = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            sortIndex.add(B.indexOf(sortB.get(i)));
            B.set(B.indexOf(sortB.get(i)), -99);
        }

        A.sort(Integer::compareTo);
        final var A재배치 = new int[N];
        for (int i = 0; i < N; i++) {
            A재배치[sortIndex.get(i)] = A.get(i);
        }

        int 결과 = 0;
        for (int i = 0; i < N; i++) {
            결과 += (A재배치[i] * copyOfB.get(i));
        }

        System.out.println(결과);
    }
}
