# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MinStack:

    def __init__(self):
        self.stack=[]
        self.minStack=[]
        self.min=float('inf')
        self.minStack.append(self.min)

    def push(self, val: int) -> None:
        if val < self.min:
            self.min=val
        self.minStack.append(self.min)
        self.stack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.min = self.minStack[-1]

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min