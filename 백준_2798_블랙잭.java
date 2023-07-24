import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 백준_2798_블랙잭 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int max = Integer.parseInt(input[1]);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    int temp = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    if (temp <= max && temp > result) {
                        result = temp;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
