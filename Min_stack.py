class MinStack:

    def __init__(self):
      self.stack = []
      self.min_val = []

    def push(self, val: int) -> None:
      self.stack.append(val)
      if len(self.min_val) == 0 or self.min_val[-1] >= val:
        self.min_val.append(val)
        print(self.min_val[-1])

    def pop(self) -> None:
      if self.stack[-1] == self.min_val[-1]:
        self.min_val.pop(-1)
      self.stack.pop(-1)


    def top(self) -> int:
      if self.stack[-1] != None:
        return self.stack[-1]
      
        

    def getMin(self) -> int:
      if len(self.min_val) != 0:
        return self.min_val[-1]
         


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()