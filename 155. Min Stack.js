// Time Complexity : O(1) (all 4 operation in O(1) push,pop,top,getmin()) 
// Space Complexity : O(n) (created 1 more stack)
// Did this code successfully run on Leetcode: Yes
/*
Any problem you faced while coding this :

Designing stack using js 
created multiple operations run in O(1)

*/
var MinStack = function() {
    this.stack = [];
    this.minStack = [];
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.stack.push(val);
    if (this.minStack.length === 0) {
    this.minStack.push(val);
    } else if (val <= this.minStack[this.minStack.length - 1]) {
    this.minStack.push(val);
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    const poppedValue = this.stack.pop();
    if (poppedValue === this.minStack[this.minStack.length - 1]) {
        this.minStack.pop();
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minStack[this.minStack.length - 1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */