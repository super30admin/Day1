# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MinStack:
    def __init__(self):
        # Set min value as infinity
        self.min = float('inf')
        # Array defined as stack to maintain the values
        self.stack = []
    def push(self, val: int) -> None:
        if val <= self.min: # If value is less than or equal to minimum value
            self.stack.append(self.min) # Add min to stack
            self.min = val # Set the new min as the val
        self.stack.append(val) # Add val to stack
    def pop(self) -> None:
        if self.stack[-1] == self.min: # If the last value entered into array (stack.top) is minimum value
            self.stack.pop() # Pop the minimum
            self.min = self.stack.pop() # Set the new minimum as the second array value and pop the stack again
        else:
            self.stack.pop() # Just pop the stack otherwise
    def top(self) -> int:
        return self.stack[-1] # Return the last entered value from array
    def getMin(self) -> int:
        return self.min # Return the set minimum value

# Example usage:
min_stack = MinStack()
min_stack.push(-2)
min_stack.push(0)
min_stack.push(-3)
print(min_stack.getMin())  # Output: -3
min_stack.pop()
print(min_stack.top())     # Output: 0
print(min_stack.getMin())  # Output: -2