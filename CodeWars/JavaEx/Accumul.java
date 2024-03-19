package com.ems.lunchbe;

public class Accumul {

  public static String accum(String s) { // abcd

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i); // a
      sb.append(Character.toUpperCase(currentChar));
      for (int j = 0; j < i; j++) {
        sb.append(Character.toLowerCase(currentChar));
      }

      if (i < s.length() - 1) {
        sb.append("-");
      }
    }

    return sb.toString();
  }
}

// 인덱스 처음은 대문자로 고정이 되야하고 끊는건 "-" 로 끊고, 나머지는 index 의 자릿수만큼 나와야한다.
// "abcd" -> A-Bb-Ccc-Dddd