#Time complexity: O(1) for all operations
#Space complexity: O(n) to store elements, No additional space
#Store tuple of value and minimum at the time to retieve min value in constant time
class MinStack:

    def __init__(self):
        self.stack = []
        

    def push(self, val: int) -> None:
        
        if not self.stack:
            self.stack.append((val, val))
        else:
            self.stack.append((val, min(self.stack[-1][1], val)))
        

    def pop(self) -> None:
        self.stack.pop()        

    def top(self) -> int:
        return self.stack[-1][0]
        

    def getMin(self) -> int:
        return self.stack[-1][1]
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(10)
obj.push(100)
obj.push(110)
obj.push(106)
obj.pop()
param_3 = obj.top()
print(param_3)
param_4 = obj.getMin()
print(param_4)