package hkjin.sort.위상정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 학생  수
		int m = Integer.parseInt(st.nextToken()); // 키 비교 횟수

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		int[] inDegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);

			// 진입차수 배열 데이터 저장
			inDegree[end]++;
		}

		// 위상정렬 구현
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		// 큐가 빌 때까지 반복한다
		while (!queue.isEmpty()) {
			int now = queue.poll();
			bw.write(now + " ");

			for (int next : list.get(now)) {
				inDegree[next]--;
				if(inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}

		bw.flush();

		br.close();
		bw.close();
	}

}

// 답 여러가지 인 경우 ? -> 위상 정렬
/*
 * A 가 B 앞에 서야 한다
 * 4는 2보다 무조건 앞에 서야함
 * 3은 1보다 무조건 앞에 서야함
 */

/*
 * 학생들을 노드로 생각하고, 키 순서 비교 데이터로 에지를 만든다. -> 노드의 순서를 도출하자
 * 1 2
 * 3 4
 * */