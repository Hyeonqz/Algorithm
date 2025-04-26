package hkjin.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준24060 - 알고리즘 수업 - 병합 정렬1 */
public class B24060 {
	int[] A;
	static int[] tmp;
	static int result = -1;
	static int cnt = 0;
	static int K;

	public static void main (String[] args) throws IOException {
		Solution();
	}

	private static void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 배열 크기
		K = Integer.parseInt(st.nextToken()); // 저장 횟수

		int[] A = new int[N];
		tmp = new int[N];

		st = new  StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(A, 0, N-1);
		System.out.println(result);
	}

	private static void mergeSort(int[] A, int p , int r) {
		if(cnt > K) return; //저장 횟수가 진행 횟수보다 넘어가게 되면 더이상 분해 or 병합 진행X
		if(p < r){
			int q = (p+r)/2; //중간으로 쪼갠다.
			mergeSort(A, p, q);
			mergeSort(A,q+1, r);
			merge(A, p, q, r);
		}
	}

	private static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;

		//시작 인덱스가 중간 인덱스(1번쨰)보다 작고,
		//중간인덱스(2번째)가 마지막인덱스보다 작을 경우 반복
		while(i <= q && j <= r){
			if(A[i] < A[j]){
				tmp[t++] = A[i++];
			}
			else{
				tmp[t++] = A[j++];
			}
		}

		//다 정렬하고도 남은 경우
		while(i <= q){ //왼쪽 배열이 남은 경우
			tmp[t++] = A[i++]; //tmp배열에 저장하는 정수
		}

		while(j <= r){ //오른쪽 배열이 남은 경우
			tmp[t++] = A[j++]; //tmp배열에 저장하는 정수
		}

		i = p;
		t = 0;
		while(i <= r){
			cnt++;

			if(cnt == K){
				result = tmp[t];
				break;
			}

			A[i++] = tmp[t++];
		}
	}

}
