
var MinStack = function() {
    this.stack = [];
    this.min = [];
};

/** 
 * @param {number} val
 * @return {void}
 */
// Time Complexity: O(1)
// Space Complexity: O(1)
MinStack.prototype.push = function(val) {
    this.stack.push(val);
    if(this.min.length === 0 || val <= this.min[this.min.length -1]){
        this.min.push(val)
    }
};

/**
 * @return {void}
 */
// Time Complexity: O(1)
// Space Complexity: O(1)
MinStack.prototype.pop = function() {
    let pop;
    if (this.stack.length > 0) pop = this.stack.pop()
    else return null;
    if(pop === this.min[this.min.length - 1]) this.min.pop()
};

/**
 * @return {number}
 */
// Time Complexity: O(1)
// Space Complexity: O(1)
MinStack.prototype.top = function() {
    if (this.stack.length > 0) return this.stack[this.stack.length-1]
    else return null
};

/**
 * @return {number}
 */
// Time Complexity: O(1)
// Space Complexity: O(1)
MinStack.prototype.getMin = function() {
    if (this.min.length > 0) return this.min[this.min.length - 1];
    else return null;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */