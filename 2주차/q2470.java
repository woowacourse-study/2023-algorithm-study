import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int[] answerArr = new int[2];

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);

                answerArr[0] = arr[start];
                answerArr[1] = arr[end];
            }

            if (sum == 0) {
                break;
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answerArr[0] + " " + answerArr[1]);
    }
}
