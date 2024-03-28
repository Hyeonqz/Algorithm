import java.util.Arrays;

public class HigestProfitWins {
  public static int[] minMax(int[] arr) {

    int[] outputArr = new int[2];

    if (arr.length==1) {
      outputArr[0] = arr[0];
      outputArr[1] = arr[0];
      return outputArr;
    }

    Arrays.sort(arr);

    outputArr[0] = arr[0];
    outputArr[1] = arr[arr.length-1];

    return outputArr;

  }

}
