# Design-1

## Problem 2:
# Design MinStack (https://leetcode.com/problems/min-stack/)

#Approach
# For Push - check if min_val >=current_value; if yes: append previous min_value to stack and set min_val to current_value. Append current_value to stack.
# For Pop- If popped value is equal to min_val, pop one more element and set it as new min_value (this will set min_value to previous min value)
# For top - return the last element (top most element) from stack. For Getmin - return the min_Value

# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_val = float('inf')

    # Time Complexity : O(1)
    def push(self, val: int) -> None:
        if self.min_val >= val:
            self.stack.append(self.min_val)
            self.min_val = val
        self.stack.append(val)
        
    # Time Complexity : O(1)
    def pop(self) -> None:
        if self.min_val == self.stack.pop():
            self.min_val = self.stack.pop()

    # Time Complexity : O(1)
    def top(self) -> int:
        return self.stack[-1]
        
    # Time Complexity : O(1)
    def getMin(self) -> int:
        return self.min_val