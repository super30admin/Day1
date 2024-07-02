class MinStack:

    def __init__(self):
        self.minStack = []
        self.dataStack = []
        

    def push(self, val: int) -> None:
        self.dataStack.append(val)
        self.minStack.append(min(val,self.minStack[-1] if self.minStack else val))

        

    def pop(self) -> None:
        self.dataStack.pop()
        self.minStack.pop()
        

    def top(self) -> int:
        return self.dataStack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()