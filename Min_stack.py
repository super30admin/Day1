class MinStack:

    def __init__(self):
        self.st = []
        self.minst = []
        self.Min = int(sys.maxsize)
        self.minst.append(self.Min)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.Min = val
        self.st.append(val)
        self.minst.append(self.Min)


    def pop(self) -> None:
        self.st.pop()
        self.minst.pop()
        self.Min = self.minst[-1]
        

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.Min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()