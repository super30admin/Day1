# Time complexity: O(1)
# Space complexity: O(N) + O(N) = O(N)
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.Min = int(sys.maxsize)
        self.minStack.append(self.Min)
        

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.Min = val
        self.stack.append(val)
        self.minStack.append(self.Min)
   

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.Min = self.minStack[-1]

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]
      
# Method-2
# time complexity--> O(1)
# space complexity --> 2*O(N) [in worst case]
class MinStack:

    def __init__(self):
        self.stack = []
        self.Min = int(sys.maxsize)
        
    def push(self, val: int) -> None:
        if val <= self.Min:
            self.Min = val
        self.stack.append((val,self.Min))
   
    def pop(self) -> None:
        self.stack.pop()
        if self.stack:
            self.Min = self.stack[-1][1]
        else:
            self.Min = sys.maxsize  # Reset self.Min if stack is empty

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
            return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
