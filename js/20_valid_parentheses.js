var isValid = function (s) {
  const stack = [];
  console.log(stack.pop());

  for (let i = 0; i < s.length; i++) {
    let c = s.charAt(i);
    if (c === '(' || c === '{' || c === '[') {
      stack.push(c);
    } else if (c === ')') {
      if (stack.pop() !== '(') {
        return false;
      }
    } else if (c === ']') {
      if (stack.pop() !== '[') {
        return false;
      }
    } else if (c === '}') {
      if (stack.pop() !== '{') {
        return false;
      }
    }
  }

  return stack.length === 0;
};
