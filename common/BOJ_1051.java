//1. N, M 이 50보다 작다
//2. 꼭지점은 기준점에서 3점만 살펴본다
//3. 최대 정사각형의 길이는 N,M 중 작은 것이다
//4. 정사각형의 최대 길이를 len 이라고 한다
//5. 길이 조사는 N - len, M - len 까지 한다
//6. 세 점을 비교해서 같다면 len * len 이 정답
//7. 정사각형이 존재하지 않는다면 len 을 1 줄여서 비교한다

import java.io.*;
import java.util.*;

public class BOJ_1051 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int len = Math.min(N, M);

        while (len > 1) {
            for (int i = 0; i <= N - len; i++) {
                for (int j = 0; j <= M - len; j++) {
                    int num = map[i][j];

                    if (num == map[i][j+len-1] && num==map[i+len-1][j] && num == map[i + len - 1][j + len - 1]) {
                        System.out.println(len * len);
                        return ;
                    }

                }
            }
            len--;
        }
        System.out.println(1);
    }
}
