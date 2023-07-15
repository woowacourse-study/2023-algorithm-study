// 각 층마다 window 의 블라인드 수를 저장하는 배열을 만듬
// 한 층을 돌면 해당 배열에서 블라인드 수를 추출해서 그 블라인드 수에 맞는 결과 배열의 수를 늘려줌


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int stair = Integer.parseInt(st.nextToken());
        int window = Integer.parseInt(st.nextToken());

        int res[] = new int[5];

        int count[] = new int[window];

        int index = 0;

        for (int i = 0; i < stair; i++) {
            br.readLine();

            for (int j = 0; j < 4; j++) {
                String s = br.readLine();

                for (int k = 1; k < 5 * window + 1; k += 5) {
                    if (s.charAt(k) == '*') {
                        count[index]++;
                        index++;
                    }
                }
                index = 0;
            }

            for (int m = 0; m < window; m++) {
                res[count[m]]++;
            }
            Arrays.fill(count, 0);
        }
        br.readLine();

        for (int i = 0; i < 5; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
