#Time Complexity : O(1) 
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minStack:
            val = min(val, self.minStack[-1])
        else:
            val = val
        self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[len(self.stack)-1] 

    def getMin(self) -> int:
        if self.minStack:
            return self.minStack[len(self.minStack)-1] 


#Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()