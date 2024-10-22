class MinStack:

    def __init__(self):
        self.stack = []
        self.head = -1
        self.min_stack = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        self.min_stack.append(val)
        self.head = self.head + 1
        if self.head > 0:
            for i in range(self.head-1,-1,-1):
                if self.min_stack[i] < self.min_stack[i+1]:
                    self.min_stack[i], self.min_stack[i+1] = self.min_stack[i+1], self.min_stack[i]
                else:
                    break     
        
    def pop(self) -> None:
        if self.head > -1:
            temp = self.stack.pop()
            self.head = self.head - 1
            self.min_stack.remove(temp)        
        
    def top(self) -> int:
        return self.stack[self.head]

    def getMin(self) -> int:
        return self.min_stack[self.head]
        
        

minStack = MinStack()  # Removed 'new'
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin())  # return -3
minStack.pop()
print(minStack.top())     # return 0
print(minStack.getMin()) 