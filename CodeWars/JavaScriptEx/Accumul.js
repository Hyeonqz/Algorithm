function accum(s) {
  let result = [];

  for (let i = 0; i <s.length ; i++) {
    let currentChar = s.charAt(i).toUpperCase();
    result += currentChar;

    for (let j = 0; j < i; j++) {
      result += s.charAt(i).toLowerCase();
    }

    if (i < s.length -1 ) {
      result += '-';
    }
  }
  return result;
}