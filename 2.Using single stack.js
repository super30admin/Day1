class MinStack {
    constructor() {
        this.stack = []; // Main stack to store elements
        this.min = Infinity; // Initialize min with a very large value (equivalent to Integer.MAX_VALUE)
    }

    /** 
     * @param {number} x
     * @return {void}
     */
    push(x) {
        // If the value is smaller than or equal to the current min, push the old min onto the stack
        if (x <= this.min) {
            this.stack.push(this.min);
            this.min = x;
        }
        this.stack.push(x); // Push the new value onto the stack
    }

    /** 
     * @return {void}
     */
    pop() {
        const popped = this.stack.pop(); // Pop the top element

        // If the popped element is the current min, update the min
        if (popped === this.min) {
            this.min = this.stack.pop(); // Pop the previous minimum from the stack and update min
        }
    }

    /** 
     * @return {number}
     */
    top() {
        return this.stack[this.stack.length - 1]; // Return the top element
    }

    /** 
     * @return {number}
     */
    getMin() {
        return this.min; // Return the current minimum value
    }
}

// Example usage:
const minStack = new MinStack();
minStack.push(5);
minStack.push(3);
console.log(minStack.getMin()); // Returns 3
minStack.push(7);
console.log(minStack.getMin()); // Returns 3
minStack.pop();
console.log(minStack.getMin()); // Returns 3
minStack.pop();
console.log(minStack.getMin()); // Returns 5
