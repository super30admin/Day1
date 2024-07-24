class MinStack:

    def __init__(self):
        self.stack=[]
        self.minstack=[]
    def push(self, val: int) -> None:
        self.stack.append(val)

        if not self.minstack:
            self.minstack.append(val)
        elif self.minstack[-1] < val:
            self.minstack.append(self.minstack[-1])
        else:
            self.minstack.append(val)       

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minstack[-1]
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(3)
obj.push(4)
obj.push(5)
obj.push(6)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
param_5 = obj.getMin()
print(param_3)
print(param_4)
print(param_5)