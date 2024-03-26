public class PINcode {

  public static boolean validatePin(String pin) {

    if (pin == null || (pin.length() != 4 && pin.length() != 6)) {
      return false;
    }

    for (int i = 0; i < pin.length(); i++) {
      if (!Character.isDigit(pin.charAt(i))) { // 지정된 문자가 숫자인지 확인한다.
        return false;
      }
    }
    return true;

  }
}

// 정수 4개 아니면, 정수 6개만 입력을 받을 수 있다
// 입력 받은 것중에 문자가 섞여 있거나, 문자일때는 무조건 false