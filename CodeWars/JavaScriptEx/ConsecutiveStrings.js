function longestConsec(strarr, k) {
  let n = strarr.length;

  if (n === 0 || k > n || k <= 0) {
    return "";
  }

  let longest = "";
  for (let i = 0; i <= n - k; i++) {
    let sb = "";
    for (let j = i; j < i + k; j++) {
      sb += strarr[j];
    }
    let tempStr = sb.toString();
    if (tempStr.length > longest.length) {
      longest = tempStr;
    }
  }
  return longest;
}
