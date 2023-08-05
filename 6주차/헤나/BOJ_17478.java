package 헤나;

import java.util.Scanner;

public class BOJ_17478 {

    private static final String START = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    private static final String QUESTION = "\"재귀함수가 뭔가요?\"";
    private static final String DEPTH = "____";
    private static final String[] RECURSION_ANSWER = {
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    };
    private static final String BEFORE_END_ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    private static final String END_ANSWER = "라고 답변하였지.";

    public static void main(String[] args) throws Exception {
        final int n = new Scanner(System.in).nextInt();
        System.out.println(START);
        recursion(0, n);
    }

    private static void recursion(final int count, final int n) {
        System.out.println(DEPTH.repeat(count) + QUESTION);
        if (count == n) {
            System.out.println(DEPTH.repeat(count) + BEFORE_END_ANSWER);
            System.out.println(DEPTH.repeat(count) + END_ANSWER);
            return;
        }
        for (final String recursionAnswer : RECURSION_ANSWER) {
            System.out.println(DEPTH.repeat(count) + recursionAnswer);
        }
        recursion(count + 1, n);
        System.out.println(DEPTH.repeat(count) + END_ANSWER);
    }
}
