class MinStack:

    def __init__(self):
        self.stack = []
        # self.minStack = []
        self.minVal = int(sys.maxsize)
        self.stack.append(self.minVal)

    def push(self, val: int) -> None:
        if val <= self.minVal:
            self.stack.append(self.minVal)
            self.minVal = val
        self.stack.append(val)

        # self.minStack.append(self.minVal)

    def pop(self) -> None:
        popped = self.stack.pop()
        if popped == self.minVal:
            self.minVal = self.stack.pop()
        # self.minVal = self.minStack[-1]
        # self.minVal = self.stack[-1]

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        # return self.minStack[-1]
        # return self.stack[-1]
        return self.minVal

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()