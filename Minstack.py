# Time Complexity:
# push: O(1)
# pop: O(1)
# top: O(1)
# getMin: O(1)
# 
# Space Complexity: O(n), where n is the number of elements in the stack.
# 
# Did this code successfully run on Leetcode: Yes
# 
# Any problem you faced while coding this: No, but keeping track of the minimum element required maintaining a second stack.

class MinStack:

    def __init__(self):
        # Initialize two stacks: one for storing elements and one for tracking the minimums.
        self.stack = []  # Main stack to store elements.
        self.min_stack = []  # Min stack to store minimum values.

    def push(self, val: int) -> None:
        # Push the value onto the main stack.
        self.stack.append(val)
        
        # If min_stack is empty or val is the new minimum, push it onto min_stack.
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        # If the popped value is the current minimum, pop it from min_stack as well.
        if self.stack[-1] == self.min_stack[-1]:
            self.min_stack.pop()
        self.stack.pop()  # Remove the top element from the main stack.

    def top(self) -> int:
        # Return the top element of the main stack.
        return self.stack[-1]

    def getMin(self) -> int:
        # Return the top element of the min stack, which holds the current minimum.
        return self.min_stack[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# Example usage:
minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin())  # return -3
minStack.pop()
print(minStack.top())     # return 0
print(minStack.getMin())  # return -2
