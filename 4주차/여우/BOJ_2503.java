import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2503 {
    static int N;
    static boolean[] check = new boolean[1000];

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        경우의수만들기();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int req = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int ans = 123; ans < 1000; ans++) {
                if (check[ans]) {
                    int ns = 0;
                    int nb = 0;

                    for (int first = 0; first < 3; first++) {
                        final var reqSplit = Integer.toString(req).charAt(first);
                        for (int second = 0; second < 3; second++) {
                            final var ansSplit = Integer.toString(ans).charAt(second);

                            if (reqSplit == ansSplit) {
                                if (Integer.toString(req).indexOf(reqSplit) == Integer.toString(ans)
                                        .indexOf(ansSplit)) {
                                    ++ns;
                                } else {
                                    ++nb;
                                }
                            }
                        }
                    }

                    if (s == ns && b == nb) {
                        check[ans] = true;
                    } else {
                        check[ans] = false;
                    }
                }

            }
        }
        int ansCount = 0;
        for (int j = 123; j < 1000; j++) {
            if (check[j]) {
                ++ansCount;
            }
        }

        System.out.println(ansCount);
    }

    private static void 경우의수만들기() {
        for (int i = 123; i < 1000; i++) {
            final var str = Integer.toString(i);
            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
                continue;
            }

            if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)) {
                continue;
            }

            check[i] = true;
        }
    }
}
