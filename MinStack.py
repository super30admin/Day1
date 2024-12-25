# Time Complexity : 0(1)
# Space Complexity : 0(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially did mistake in top and getMin function
class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')  

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)    

    def pop(self) -> None:
        self.popped = self.stack.pop()
        if self.popped == self.min:
            self.min = self.stack.pop()
        
           
    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()