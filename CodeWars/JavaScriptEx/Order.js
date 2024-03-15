function order(words) {
  if (words.length === 0) {
    return "";
  }

  let result = "";

  for (let i = 1; i <= 9; i++) {
    const array = words.split(" ");
    for (let j = 0; j < array.length; j++) {
      if (array[j].includes(i)) {
        result += array[j] + " ";
        break;
      }
    }
  }

  return result.trim();
}
