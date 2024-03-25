package com.ems.lunchbe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsec {


  public static String longestConsec(String[] strarr, int k) {
    int n = strarr.length;

    if (n == 0 || k > n || k <= 0) {
      return "";
    }

    String longest = "";
    for (int i = 0; i <= n - k; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = i; j < i + k; j++) {
        sb.append(strarr[j]);
      }
      String tempStr = sb.toString();
      if (tempStr.length() > longest.length()) {
        longest = tempStr;
      }
    }
    return longest;
  }
}

// 가장 긴 것을 찾고, k 는 몇개를 찾을건지를 쓴다.
// 결국 제일 긴 2개를 찾는 것이다. 순서는 상관없이.

// EX2

class BestEx {

  public static String longestConsec(String[] strarr, int k) {
    if (k <= 0) {
      return "";
    }

    return IntStream.rangeClosed(0, strarr.length - k)
        .mapToObj(i -> Arrays.stream(strarr, i, i + k).collect(Collectors.joining()))
        .max(Comparator.comparingInt(String::length))
        .orElse("");
  }
}