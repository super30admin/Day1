# We will initialize 2 stacks one for normal stack and another for min stack
# we will push the value in normal stack and if the value is less than the min value we will push it in minStack
# similarly we will pop the value from normal stack and if the value is equal to the min value we will pop it from minStack.

# // Time Complexity :  o(1) for all functions
# // Space Complexity : O(n) for both stacks in worst case
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Failed single stack approach multiple times


# // Your code here along with comments explaining your approach

class MinStack:

    def __init__(self): # 2 stack appraoch
        self.stack = []
        self.minStack = [float('inf')]

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.minStack.append(min(self.minStack[-1], val))
        
    def pop(self) -> None:
        if self.stack :
            temp = self.stack.pop()
            if temp == self.minStack[-1] or temp >= self.minStack[-1]:
                self.minStack.pop()
        

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        else:
            return None

    def getMin(self) -> int:
        if self.minStack:
            return self.minStack[-1]
        else:
            return None


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
obj.getMin() #// return -3
obj.pop()
obj.top()   #// return 0
obj.getMin() #// return -2