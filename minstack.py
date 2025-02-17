class MinStack:

    def __init__(self):
        
        self.stack = []
        self.min_stack = []
    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.min_stack:
            if val<=self.min_stack[-1]:
                self.min_stack.append(val)
            
            return
        self.min_stack.append(val)


    def pop(self) -> None:
        if self.min_stack:
            if self.stack[-1]==self.min_stack[-1]:
                self.min_stack.pop()
        
        self.stack.pop()
        return
        
    def top(self) -> int:
        return self.stack[-1]
    def getMin(self) -> int:
        return self.min_stack[-1]
        
