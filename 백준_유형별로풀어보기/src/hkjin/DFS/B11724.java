package hkjin.DFS;

/*
* https://www.acmicpc.net/problem/11724
* 백준11724(실버2) - 연결 요소의 개수 구하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11724 {
	static boolean visited[]; // 방문 배열
	static ArrayList<Integer>[] A;

	public static void main (String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n+1];
		A = new ArrayList[n+1];

		for (int i = 1; i <n+1 ; i++) {
			A[i] = new ArrayList<Integer>(); // A 인접 리스트의 각 ArrayList 초기화하기
		}

		for (int i = 0; i <m ; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// 양방향 설정하기
			A[start].add(end);
			A[end].add(start);
		}

		int count = 0;
		for (int i = 1; i <n+1 ; i++) {
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}
	public static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		// 현재 연결 노드 중 방문하지 않은 노드를 찾아야 한다.
		for (int i : A[v]) {
			if(!visited[i]) {
				DFS(i); // 아직 탐색하지 않은 노드가 있다면 현재를 기준으로 다시 DFS 를 구현해줘라
			}
		}
	}

}

