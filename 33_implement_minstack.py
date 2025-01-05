# Time Complexity -
#     push() - O(1)
#     pop() - O(1)
#     top() - O(1)
#     getMin() - O(1)

# Space Complexity - O(n)

import sys
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = [] # maintaining two stacks
        self.min = int(sys.maxsize) # setting minimum value to infinity
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
        return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()