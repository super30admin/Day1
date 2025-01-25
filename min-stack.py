"""

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 
Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Method 1
Time Complexity: O(1) for all operations
Space Complexity: O(n) due to maintaining an additional stack

Method 2
Time Complexity: O(1) for all operations
Space Complexity: O(n) since we store previous min values in the stack itself

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# Both methods use an auxiliary mechanism to track the minimum value efficiently.
# Method 1 maintains a separate minStack where each push stores the minimum seen so far, ensuring O(1) retrieval.
# Method 2 stores the previous min value in the stack itself whenever a new min is encountered, avoiding an extra list.

# Method 1
class MinStack:
    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = float("inf")
        self.minStack.append(self.min)

    def push(self, val: int) -> None:
        if val <= self.min:
            self.min = val
        self.stack.append(val)
        self.minStack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.min = self.minStack[-1]

    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min


# Method 2
class MinStack:
    def __init__(self):
        self.stack = []
        self.min = float("inf")
        
    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:
        val = self.stack.pop()
        if val == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()



