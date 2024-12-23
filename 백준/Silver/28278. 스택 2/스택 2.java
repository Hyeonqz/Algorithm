import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<String> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "1":
					stack.add(st.nextToken());
					break;

				case "2":
					if (!stack.empty()) {
						System.out.println(stack.pop());
					} else {
						System.out.println(-1);
					}
					break;

				case "3":
					System.out.println(stack.size());
					break;

				case "4":
					if (stack.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;

				case "5":
					if(!stack.isEmpty()) {
						System.out.println(stack.peek());
					} else {
						System.out.println(-1);
					}
					break;
			}

		}
	}

}

/* completed, partialSuccess, unsolved*/
// 시간 복잡도 2초
// 정수를 저장하는 스택을 구현한다.