# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MinStack:

    def __init__(self):
        self.stack = [] # Stores the actual elements being pushed.
        self.min_stack = []   # Tracks the current minimum element at each level of the main stack.

    def push(self, val: int) -> None:
        self.stack.append(val) # Push val to the main stack.
        
        # Push the current minimum (either val or the previous minimum) onto the min stack.
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()   # Pop the top element from both the main stack and the min stack.     

    def top(self) -> int:
        return self.stack[-1]  # Return the top element from the main stack

    def getMin(self) -> int:
        return self.min_stack[-1] # Return the top element from the min stack, which represents the current minimum.
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()