#  Time Complexity : O(1)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : -


#  Your code here along with comments explaining your approach
#  I used two stacks, one for the main stack and one for the min stack. 
#  If min stack is empty or the value to be pushed is less than or equal to the top of min stack, 
#  then I push the value to min stack.
#  While popping, if the value to be popped is equal to the top of min stack, 
#  then I pop the value from min stack as well.


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
                self.min_stack.append(val)
                
    def pop(self) -> None:
        if self.min_stack[-1] == self.stack[-1]:
            self.min_stack.pop()
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]
    
    
    def getMin(self) -> int:
        return self.min_stack[-1]
        