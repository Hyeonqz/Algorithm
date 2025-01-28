package hkjin.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B24480 {
	static ArrayList<ArrayList<Integer>> graph; // 그래프를 저장할 리스트 배열
	static boolean[] visited;    // 방문 여부를 저장할 배열
	static int[] visitOrder;     // 방문 순서를 저장할 배열
	static int order = 1;        // 방문 순서를 기록할 변수

	public static void main (String[] args) throws IOException {
		Solution();
	}

	private static void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 1; i <= N; i++) {
			graph.get(i).sort(Collections.reverseOrder());
		}

		visited = new boolean[N+1];
		visitOrder = new int[N+1];

		DFS(R);
		for (int i = 1; i <= N ; i++) {
			System.out.println(visitOrder[i]);
		}

	}

	private static void DFS (int node) {
		visited[node] = true;
		visitOrder[node] = order++;

		for(int next : graph.get(node)) {
			if(!visited[next]) {
				DFS(next);
			}
		}
	}

}

/* 내림 차순 으로 그래프를 확인한다. */