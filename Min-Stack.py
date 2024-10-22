#Time Complexity : O(1)
#Space Complexity : O(n)

class MinStack:

    def __init__(self):
        self.stack = []
        self.head = -1
        self.min_stack = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        self.head = self.head + 1
        if not self.min_stack or self.min_stack[-1] >= self.stack[-1]:
            self.min_stack.append(val)
             
    def pop(self) -> None:
        if self.head > -1:
            temp = self.stack.pop()
            self.head = self.head - 1
        if temp == self.min_stack[-1]:
            self.min_stack.pop()        
        
    def top(self) -> int:
        return self.stack[self.head]

    def getMin(self) -> int:
        return self.min_stack[-1]
        
        

