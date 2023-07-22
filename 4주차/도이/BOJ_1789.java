package 도이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        System.out.println((long) (Math.sqrt(1 + 8 * S) - 1) / 2);
    }
}
