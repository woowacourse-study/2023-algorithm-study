import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=java
class Solution {
    public int solution(int n) {
        final int amountOfOne = countNumberOfOne(n);
        while (true) {
            n += 1;
            if (countNumberOfOne(n) == amountOfOne) {
                return n;
            }
        }
    }

    private int countNumberOfOne(final int number) {
        final char[] binaryString = Integer.toBinaryString(number).toCharArray();
        int count = 0;
        for (final char c : binaryString) {
            if (c == '1') {
                count += 1;
            }
        }

        return count;
    }
}
