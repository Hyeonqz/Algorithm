function validatePin(str) {

  if(str.length !== 4 && str.length !==6) {
    return false;
  }

  for (let i = 0; i < str.length; i++) {
    // 아스키 코드 로 비교하기.
    if (str[i] < '0' || str[i] > '9') {
      return false;
    }
  }
  return true;
}