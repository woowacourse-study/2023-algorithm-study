//투포인터
//1. 리스트를 정렬한다
//2. 특정 원소를 타겟으로 설정한다 (i)
//3. start 를 첫 시작, end 를 N - 1 만큼으로 지정하여 start < end 조건으로 탐색을 한다
//4. sum 이 타겟과 같을 때
// - start 와 end 가 둘다 i 가 아닐때 값을 늘려준다
// - start 가 i 이면 start 를 하나 늘리고 end 가 i 이면 end 를 감소시킨다
//5. sum 이 타겟보다 작거나 크면 start, end 를 조절한다


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            int target = nums[i];

            int start = 0;
            int end = N - 1;

            while (start < end) {

                int sum = nums[start] + nums[end];
                if (sum == target) {
                    if (start != i && end != i) {
                        count++;
                        break ;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }

                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}
