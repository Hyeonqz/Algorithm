package hkjin.DFS_BFS;

public class 타겟넘버 {
    int count = 0;
    public static void main(String[] args) {

    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        // 재귀를 통해 탐색을 진행한다.
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(numbers, target, index +1, sum+numbers[index]);
        dfs(numbers, target, index +1, sum - numbers[index]);
    }
}
