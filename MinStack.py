# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MinStack:
    def __init__(self):
        self.min = float('inf')
        self.stack = []
    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
    def pop(self) -> None:
        if self.stack[-1] == self.min:
            self.stack.pop()
            self.min = self.stack.pop()
        else:
            self.stack.pop()
    def top(self) -> int:
        return self.stack[-1]
    def getMin(self) -> int:
        return self.min

# Example usage:
min_stack = MinStack()
min_stack.push(-2)
min_stack.push(0)
min_stack.push(-3)
print(min_stack.getMin())  # Output: -3
min_stack.pop()
print(min_stack.top())     # Output: 0
print(min_stack.getMin())  # Output: -2