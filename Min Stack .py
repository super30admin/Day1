class MinStack:

    def __init__(self):
        self.stack=[]
        self.minstack=[]
        self.Min=int(sys.maxsize)
        self.minstack.append(self.Min)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.Min= val
        self.stack.append(val)
        self.minstack.append(self.Min)
    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        self.Min=self.minstack[-1]
        
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:

        return self.Min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()