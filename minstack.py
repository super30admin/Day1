class MinStack:

    def __init__(self):
        self.st = []
        self.minst = []
        self.min = int(sys.maxsize)
        self.minst.append(self.min)
        

    def push(self, val: int) -> None:
        if val <= self.min:
            self.min = val
        self.st.append(val)
        self.minst.append(self.min)

    def pop(self) -> None:
        self.st.pop()
        self.minst.pop()
        self.min = self.minst[-1]
        
    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()