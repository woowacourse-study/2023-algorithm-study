//2023.07.04
//https://www.acmicpc.net/problem/1082

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1082 {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final List<NumberPrice> numberPrices = new ArrayList<>();
        final int[] numberPrice = new int[N];
        final StringTokenizer numbersSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            final int price = Integer.parseInt(numbersSt.nextToken());
            numberPrices.add(new NumberPrice(i, price));
            numberPrice[i] = price;
        }
        Collections.sort(numberPrices);

        int M = Integer.parseInt(br.readLine());
        final int[] numbers = new int[51];

        final NumberPrice minPriceNumber = numberPrices.get(0);
        int cursor = 0;
        if (minPriceNumber.number == 0) {
            if (N == 1) {
                System.out.println(0);
                return;
            }
            final NumberPrice secondMinPriceNumber = numberPrices.get(1);
            numbers[cursor] = secondMinPriceNumber.number;
            cursor += 1;
            M -= secondMinPriceNumber.price;
        }

        while (M >= minPriceNumber.price) {
            numbers[cursor] = minPriceNumber.number;
            cursor += 1;
            M -= minPriceNumber.price;
        }

        for (int i = 0; i < cursor; i++) {
            for (int j = N - 1; j >= 0; j--) {
                final int currentPrice = numberPrice[numbers[i]];
                if (M + currentPrice - numberPrice[j] >= 0) {
                    M = M + currentPrice - numberPrice[j];
                    numbers[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < cursor; i++) {
            System.out.print(numbers[i]);
        }
    }

    /*
6
1 5 4 3 10 5
29
     */
    private static class NumberPrice implements Comparable<NumberPrice> {
        private final int number;
        private final int price;

        public NumberPrice(final int number, final int price) {
            this.number = number;
            this.price = price;
        }

        @Override
        public int compareTo(final NumberPrice other) {
            if (this.price == other.price) {
                return other.number - this.number;
            }

            return this.price - other.price;
        }
    }
}

