import java.io.*;
import java.util.*;

public class BOJ_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>(N);
		int start = 0;
		while(N-- > 0) {
			int target = Integer.parseInt(br.readLine());
			if (target > start) {
				for(int i = start + 1; i <= target; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				start = target;
			} else if (stack.peek() != target) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-\n");	
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
