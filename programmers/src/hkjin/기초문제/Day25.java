package hkjin.기초문제;

import java.util.Arrays;

public class Day25 {
	public static void main (String[] args) {
	}

	/** 정수를 나선형으로 배치하기 */
	public int[][] solution(int n) {
		int[][] result = new int[n][n];
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		int x = 0, y = 0, dir = 0;
		for (int i = 1; i <= n * n; i++) {
			result[x][y] = i;
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || result[nx][ny] != 0) {
				dir = (dir + 1) % 4;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			x = nx;
			y = ny;
		}

		return result;
	}

	/** 특별한 2차원 배 2 */
	public int solution(int[][] arr) {
		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == arr[j][i]) {
					answer = 1;
				} else {
					answer = 0;
					break;
				}
			}
		}

		return answer;
	}

	/** 정사각형으로 만들기 */
	public int[][] solution1(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;

		if (rows > cols) {
			int[][] result = new int[rows][rows];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					result[i][j] = arr[i][j];
				}
			}
			return result;
		}
		else if (cols > rows) {
			int[][] result = new int[cols][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					result[i][j] = arr[i][j];
				}
			}
			return result;
		}
		return arr;
	}

	/** 이차원 배열 대각선 순회하기 */
	public int solution(int[][] board, int k) {
		int answer = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j <board[0].length ; j++) {
				if(i+j <= k) {
					answer += board[i][j];
				}
			}
		}

		return answer;
	}
}
