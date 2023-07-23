import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1700 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int size = 0;

        int[] arr = new int[k];
        boolean[] using = new boolean[101];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int item = arr[i];

            if (!using[item]) {
                if (size < n) {
                    using[item] = true;
                    size++;
                } else {
                    List<Integer> afterUsing = new ArrayList<>();

                    // 나중에 사용할 것들 찾음
                    for (int j = i; j < k; j++) {
                        if (using[arr[j]] && !afterUsing.contains(arr[j])) {
                            afterUsing.add(arr[j]);
                        }
                    }

                    if (afterUsing.size() != n) {
                        for (int j = 0; j < using.length; j++) {
                            if (using[j] && !afterUsing.contains(j)) {
                                using[j] = false;
                                break;
                            }
                        }
                    } else {
                        int lastItem = afterUsing.get(afterUsing.size() - 1);
                        using[lastItem] = false;
                    }

                    using[item] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
