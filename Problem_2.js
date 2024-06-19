// Time Complexity : push - O(1), pop - O(1), peek - O(1) and getMin - O(1)
// Space Complexity : O(n) - n is number of items stored
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var MinStack = function() {
    this.stack = [];
    this.minVal = [];
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.stack.push(val);
    let min = val; 
    if (this.minVal.length > 0){
        min = this.minVal[this.minVal.length-1] < val ? this.minVal[this.minVal.length-1] : val;
    }
    this.minVal.push(min)
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.stack.pop();
    this.minVal.pop();
}
/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.stack.length-1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minVal[this.minVal.length - 1]
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */