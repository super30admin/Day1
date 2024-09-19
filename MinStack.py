# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : To understand why we need to have two different stacks 

# Your code here along with comments explaining your approach:

class MinStack:
    #Initialising main stack and min stack
    def __init__(self):
        self.stack = []
        self.minStack = []
    def push(self, val: int) -> None:
        #Pushing the element into main
        self.stack.append(val)
        #Checking if the current val is smaller than the existing top in minStack and appending accordingly 
        if self.minStack:
            val1 = min(val, self.minStack[-1])
        else:
            val1 = val
        self.minStack.append(val1)
    def pop(self) -> None:
        #Removing items from the top of each stack
        self.stack.pop()
        self.minStack.pop()
    def top(self) -> int:
        #To retrieve the top element in the main stack
        return self.stack[-1]
    def getMin(self) -> int:
        #To retrieve the minimum element from the minStack
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
