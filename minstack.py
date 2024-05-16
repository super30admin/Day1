"""
Design-1

Problem 2:(https://leetcode.com/problems/min-stack/)

Time Complexity : O(1)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
The approach we take to make each operation O(1) is whenever we push an element in the stack we check if its less than the current minimum
if yes, then we push the current minimum into stack & then assign the latest value as new minimum & we push the value to stack. The reason we do this
to keep track of minimum. how it's possible is whenever we're popping an element we check if its min value, if yes then we pop it & we pop again to get the previous min before the current one 
and assign it to min. This way we keep track of min in O(1). Other operations like top & min are O(1) since we're directly returning the value.
"""

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
        popped_val = self.stack.pop()
        if popped_val == self.min:
            self.min = self.stack.pop()
        return popped_val
            
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2)
obj.push(3)
obj.push(4)
print(obj.pop())
param_3 = obj.top()
print(param_3)
param_4 = obj.getMin()
print(param_4)
