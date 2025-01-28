package hkjin.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B24479_PartialSolved {
	static ArrayList<ArrayList<Integer>> graph; // 그래프를 저장할 리스트 배열
	static boolean[] visited;    // 방문 여부를 저장할 배열
	static int[] visitOrder;     // 방문 순서를 저장할 배열
	static int order = 1;        // 방문 순서를 기록할 변수

	public static void main(String[] args) throws IOException {
		Solution();
	}

	private static void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력 받기
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점 번호

		graph = new ArrayList<>();
		// 그래프 초기화
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 간선 정보 입력받아 그래프 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// 그래프의 인접 정점 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		// 방문 여부 및 방문 순서 배열 초기화
		visited = new boolean[N + 1];
		visitOrder = new int[N + 1];

		dfs(R);

		for (int i = 1; i <= N; i++) {
			System.out.println(visitOrder[i]); // 각 정점의 방문 순서 출력
		}
	}

	// DFS 함수
	private static void dfs(int node) {
		visited[node] = true;        // 현재 노드 방문 처리
		visitOrder[node] = order++; // 방문 순서 기록

		// 인접 정점을 방문
		for (int next : graph.get(node)) {
			if (!visited[next]) { // 방문하지 않은 정점만 탐색
				dfs(next);
			}
		}
	}

}
