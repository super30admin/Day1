#TC: O(1)
#SC : O(1)
class MinStack:

    def __init__(self):
        self.stack= []
        self.min_stack= []
        #self.min_stack.append(float('inf'))
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack:
            self.min_stack.append(val)
        else:
            if val <= self.min_stack[-1]:
                self.min_stack.append(val)
    
    def pop(self) -> None:
        temp = self.top()
        self.stack.pop()
        if self.min_stack[-1]==temp:
            self.min_stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()