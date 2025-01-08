class MinStack:

    def __init__(self):
        # self.minElement = 2147483647
        # self.stack = []
        # self.minstack = []
        # self.minstack.append(self.minElement)
        self.min = int(sys.maxsize)
        self.st = []

        

    def push(self, val: int) -> None:
        # if val < self.minElement:
        #     self.minElement = val
        # self.stack.append(val)
        # self.minstack.append(self.minElement)
        if val<= self.min:
            self.st.append(self.min)
            self.min = val
        self.st.append(val)


        

    def pop(self) -> None:
        # self.stack.pop()
        # self.minstack.pop()
        # self.minElement = self.minstack[-1]
        popped = self.st.pop()
        if popped == self.min:
            self.min = self.st.pop()


    def top(self) -> int:
        #return self.stack[-1]
        return self.st[-1]

    def getMin(self) -> int:
        #return self.minElement
        return self.min
        
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()