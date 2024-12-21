package hkjin.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1707_이분그래프판별하기 {
	private static ArrayList<Integer>[] A;
	static int[] check;
	static boolean[] visited;
	static boolean isEven;

	public static void main (String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(bf.readLine());
		for (int t = 0; t < testCase ; t++) {
			String[] s = bf.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			// 0번 노드를 쓰지 않기 위해서 +1 을 함
			A = new ArrayList[V+1];
			visited = new boolean[V+1];
			check = new int[V+1];
			isEven = true;

			for (int i = 1; i <= V; i++) {
				A[i] = new ArrayList<Integer>();
			}

			// 엣지 데이터 저장하기
			for (int i = 0; i < E; i++) {
				s = bf.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				A[end].add(end);
				A[start].add(start);
			}

			for (int i = 1; i <= V ; i++) {
				if(isEven)
					DFS(1);
				else
					break;
			}

			if(isEven) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static void DFS (int node) {
		visited[node] = true;
		// 인접 리스트로 받아서 start 에서 연결된 모든 노드 탐색을 한다.
		for (int i : A[node]) {
			if(!visited[i]) {
				// 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요.
				check[i] = (check[node] + 1) % 2;
				DFS(i);
			}
			else if(check[node] == check[i]) {
					isEven = false;
			}
		}
	}

}
/*
* 이분 그래프란?
* 1 -- 2 -- 3
* A -- B -- A
* 서로 인접한 노드가 다른걸 이분 그래프 라고 한다.
* 서로 인접한 애들끼리 같은 집합이 아니고, 같은 집합에 속한 노드는 서로 인접하지 않는다면 -> 이분 그래프 이다.
*
* 노드와 엣지의 개수가 주어진다.
* 각 줄에 인접한 두 노드의 번호가 공백 문자를 사이에 두고 주어진다.
* 2 // 테스트 케이스 개수
* 3 2 // 노드 개수, 엣지 개수
* 1 3
* 2 3
*
* 트리의 경우에는 항상 이분 그래프가 된다.
* 사이클이 발생하지 않기 때문에 이분 그래프가 맞다.
* 사이클이 발생한다면 이분 그래프가 불가능 할 때가 있다.
*
* DFS: 이미 탐색한 노드는 다시 그 노드를 탐색하지 않는다.
*
* - 손으로 풀어보기
* 1) 입력 된 그래프 데이터를 인접 리스트로 구현합니다. (가중치는 필요없다 -> ArrayList 내부 구조를 Integer 로 하면 된다 )
* 2) 모든 노드로 DFS 탐색 알고리즘을 적용해 탐색을 수행한다.
* 	- 연결된 노드 중 이미 방문한 노드가 나와 같은 집합이면 이분 그래프가 아닌 것으로 판별한다.
* 3) 이분 그래프 여부를 정답으로 출력한다 -> Yes or No
* */