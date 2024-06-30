class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.min = sys.maxsize
        self.minStack.append(self.min)

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.min > val:
            self.min = val
        self.minStack.append(self.min)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.min = self.minStack[-1]
        

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