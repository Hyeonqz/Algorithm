function comp(array1, array2) {
  if (array1 == null || array2 ==null) {
    return false;
  }

  if (array1.length != array2.length) {
    return false;
  }

  let square = [];
  for (let i = 0; i < array1.length; i++) {
    square[i] = array1[i] * array1[i];
  }

  square.sort();
  array2.sort();

  for (let i = 0; i < square.length; i++) {
    if (square[i]!== array2[i]) {
      return false;
    }
  }
  return true;
}

function Ex2(array1, array2) {

}