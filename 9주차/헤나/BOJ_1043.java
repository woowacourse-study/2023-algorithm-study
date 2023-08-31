package 헤나;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1043 {

    private static final int MAX_N = 50, MAX_M = 50;
    private static final int ALREADY_KNEW = 0;

    private static int N, M;
    private static int[][] party;
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        parent = new int[MAX_N + 1];
        party = new int[MAX_M + 1][MAX_N + 1];

        for (int i = 0; i < MAX_N; i++) {
            parent[i] = i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        final int alreadyKnewCount = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= alreadyKnewCount; i++) {
            final int alreadyKnewPerson = Integer.parseInt(st.nextToken());
            parent[alreadyKnewPerson] = ALREADY_KNEW;
        }

        for (int partyIndex = 1; partyIndex <= M; partyIndex++) {
            st = new StringTokenizer(br.readLine());
            final int peopleCount = Integer.parseInt(st.nextToken());
            party[partyIndex][0] = peopleCount;

            int tempPerson = Integer.parseInt(st.nextToken());
            party[partyIndex][1] = tempPerson;
            for (int personIndex = 2; personIndex <= peopleCount; personIndex++) {
                party[partyIndex][personIndex] = Integer.parseInt(st.nextToken());
                unionParent(tempPerson, party[partyIndex][personIndex]);
                tempPerson = party[partyIndex][personIndex];
            }

        }

        int answerCount = 0;
        for (int partyIndex = 1; partyIndex <= M; partyIndex++) {
            boolean isCanLie = true;
            for (int peopleIndex = 1; peopleIndex <= party[partyIndex][0]; peopleIndex++) {
                if (isCannotLie(party[partyIndex][peopleIndex])) {
                    isCanLie = false;
                    break;
                }
            }

            if (isCanLie) {
                answerCount++;
            }
        }

        System.out.println(answerCount);
    }

    private static int getParent(final int number) {
        if (parent[number] == number) {
            return number;
        }

        return getParent(parent[number]);
    }

    private static void unionParent(int left, int right) {
        left = getParent(left);
        right = getParent(right);

        if (left < right) {
            parent[right] = left;
        } else {
            parent[left] = right;
        }
    }

    private static boolean isCannotLie(final int number) {
        return getParent(number) == ALREADY_KNEW;
    }
}
