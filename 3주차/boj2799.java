import java.util.Scanner;

public class boj2799 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int maxCol = n * 5 + 1;

        int[] windows;
        int[] answer = new int[5];

        for (int k = 0; k < m; k++) {
            String emptySpace = sc.next();
            int wIdx = 0;
            windows = new int[n];

            for (int windowRow = 0; windowRow < 4; windowRow++) {
                String window = sc.next();
                wIdx = 0;

                for (int c = 1; c < maxCol; c += 5) {
                    if (window.charAt(c) == '*') {
                        windows[wIdx]++;
                        wIdx++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                answer[windows[i]]++;
            }
        }

        String emptySpace = sc.next();

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
