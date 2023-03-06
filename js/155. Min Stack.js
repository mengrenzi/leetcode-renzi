class MinStack {
  stack = [];

  push(x) {
    // If the stack is empty, then the min value
    // must just be the first value we add
    if (this.stack.length === 0) {
      this.stack.push([x, x]);
      return;
    }

    const currentMin = this.stack[this.stack.length - 1][1];
    this.stack.push([x, Math.min(currentMin, x)]);
  }

  pop() {
    this.stack.pop();
  }

  top() {
    return this.stack[this.stack.length - 1][0];
  }

  getMin() {
    return this.stack[this.stack.length - 1][1];
  }
}
