import java.util.Arrays;
public class AreSame {
  public static boolean comp(int[] a, int[] b) {

    if (a == null || b == null) {
      return false;
    }

    if (a.length != b.length) {
      return false;
    }

    int[] squares = Arrays.stream(a)
        .map(x -> x * x)
        .toArray();

    Arrays.sort(b);
    Arrays.sort(squares);

    for (int i = 0; i < a.length; i++) {
      if (squares[i] != b[i]) {
        return false; // 하나라도 다르면 false 반환
      }
    }

    return true;
  }
}

// a 배열 에 수의 제곱이 b 배열에 다 들어있으면 된다.