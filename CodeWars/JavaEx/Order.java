public class Order {

  public static String order(String words) {

    if (words.isEmpty()) {
      return "";
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < 10; i++) {
      String[] array = words.split(" ");
      for (String arr : array) {
        if (arr.contains(String.valueOf(i))) {
          sb.append(arr + " ");
          break;
        }
      }
    }

    return sb.toString().trim();
  }

}
