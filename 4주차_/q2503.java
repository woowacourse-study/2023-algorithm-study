import java.util.Scanner;

public class q2503 {

    public static String[] output;
    public static String[] strikeCount;
    public static String[] ballCount;
    public static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int question = sc.nextInt();

        output = new String[question];
        strikeCount = new String[question];
        ballCount = new String[question];
        answer = 0;

        for (int i = 0; i < question; i++) {
            output[i] = sc.next();
            strikeCount[i] = sc.next();
            ballCount[i] = sc.next();
        }

        for (int i = 123; i <= 987; i++) {
            bruteforce(String.valueOf(i));
        }

        System.out.println(answer);
    }

    public static void bruteforce(String input) {
        int correct = 0;
        char[] arr = input.toCharArray();

        for (int i = 0; i < output.length; i++) {
            if (isSkipCase(arr)) {
                continue;
            }

            int strike = 0;
            int ball = 0;

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (arr[j] == output[i].charAt(k)) {
                        if (j == k) {
                            // st
                            strike++;
                        } else {
                            // ba
                            ball++;
                        }
                    }
                }
            }

            if (strike == Integer.parseInt(strikeCount[i]) && ball == Integer.parseInt(ballCount[i])) {
                correct++;
            }
        }

        if (correct == output.length) {
            answer++;
        }
    }

    private static boolean isSkipCase(final char[] arr) {
        return arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2] || arr[0] == '0' || arr[1] == '0' || arr[2] == '0';
    }
}
