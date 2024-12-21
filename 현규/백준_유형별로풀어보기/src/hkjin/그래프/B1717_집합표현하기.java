package hkjin.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1717_집합표현하기 {
	public static int[] parent;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];

		// 초기화
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		// 질의 계산
		for (int i = 0; i < M; i++) {
			int question = Integer.parseInt(br.readLine());
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());

			// 합친다 union
			if(question == 0) {
				union(a,b);
			}
			// find 해라 -> 두 원소가 같은지 보자
			else {
				boolean result = checkSame(a,b);
				if(result) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	private static void union (int a, int b) {
		a = find(a);
		b = find(b);

		if(a != b) {
			// 두개를 연결
			parent[b] = a;
		}
	}

	private static int find (int a) {
		if(a == parent[a]) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	private static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) {
			return true;
		} else {
			return false;
		}
	}

}

/* 문제 풀이
* 초기에 {0},{1},{2},,{n} 이 각 n+1 개의 집합을 이루고 있다
* 합집합 연산과 두 원소가 같은 집합에 포함돼 있는지를 확인하는 연산을 수행하자
* 합집합 연산 -> m
* 집합을 이루는 데이터 -> n
* 0 a b -> a 와 b 를 합집합해라 (a 와 b 를 선을 이어라)
* 1 a b -> 교집합 -> a,b 가 같은 집합인가? (즉 이미 이어져 있나?)
*
* m 개의 줄에는 각각의 연산이 주어진다.
* 최대 원소의 개수 1,000,000 과 질의 개수 100,000 이 큰편이므로 경로 압축이 필요한 유니온 파인드 문제이다
* find 연산을 해주고, union 인지 아닌지 체크를 한다.
* */
/* 손으로 풀어 보기
* 1) 처음에는 노드가 연결되어 있지않으므로 각 노드의 대표 노드는 자기 자신이다.
* 2) find 연산으로 특정 노드의 대표 노드를 찾는다.
* */