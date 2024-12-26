class MinStack:
#Using one Stack 
    def __init__(self):
        self.stack = []
        self.Min = int(sys.maxsize)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.stack.append(self.Min)
            self.Min = val
        self.stack.append(val)    

    def pop(self) -> None:
        popped = self.stack.pop()
        if popped == self.Min:
            self.Min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.Min

#TC: Push = O(1), Pop = O(1), Push = O(1),top = O(1), getmin = O(1)

#Using two Stacks
    def __init__(self):
        self.stack = []
        self.MinStack = []
        self.Min = int(sys.maxsize) # assigning infinite integer value
        self.MinStack.append(self.Min)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.Min = val
        self.stack.append(val)
        self.MinStack.append(self.Min)                

    def pop(self) -> None:
        self.stack.pop()
        self.MinStack.pop()  
        self.Min = self.MinStack[-1]      

    def top(self) -> int:
        return self.stack[-1]        

    def getMin(self) -> int:
        return self.Min

#TC: Push = O(1), Pop = O(1), Push = O(1),top = O(1), getmin = O(1)
