# Time complexity: O(1)
# Space complexity: O(n)
import sys
class MinStack:

    def __init__(self):
        self.min = None
        self.stack = []
        self.minStack = []
        self.minStack.append(sys.maxsize)

    def push(self, val: int) -> None:
        if self.min == None: self.min = val
        elif val <= self.min:
            self.minStack.append(self.min)
            self.min = val
        self.stack.append(val)    

    def pop(self) -> None:
        top = self.stack.pop()
        if top == self.min:
            self.min = self.minStack.pop()

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