// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

var MinStack = function () {
  this.stack = [];
  this.min = Infinity;
  this.stack.push(this.min);
};

/**
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function (val) {
  if (val <= this.min) {
    this.stack.push(this.min);
    this.min = val;
  }
  this.stack.push(val);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  let poped = this.stack.pop();
  if (poped == this.min) {
    this.min = this.stack.pop();
  }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  return this.min;
};

test("Scenario #1:", () => {
  var obj = new MinStack();
  obj.push(5);
  obj.push(6);
  obj.push(7);
  obj.pop();
  expect(obj.top()).toStrictEqual(6);
  expect(obj.getMin()).toStrictEqual(5);
});

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
