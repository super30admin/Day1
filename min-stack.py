class MinStack:
    # tc O(1), sc O(n).
    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.minstack:
            self.minstack.append(val)
        else:
            self.minstack.append(min(self.minstack[-1], val))

    def pop(self) -> None:
        if not self.stack:
            return None
        self.stack.pop()
        self.minstack.pop()

    def top(self) -> int:
        if not self.stack:
            return None
        return self.stack[-1]
        

    def getMin(self) -> int:
        if not self.stack:
            return None
        return self.minstack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()