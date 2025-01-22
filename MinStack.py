#  Time Complexity : O(1)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this :No

class MinStack:

    def __init__(self):
        self.stack = []
        

    def push(self, val: int) -> None:
        minVal = self.getMin()
        if minVal == None or val< minVal:
            minVal = val
        self.stack.append([val,minVal])
        

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
        

    def top(self) -> int:
        if self.stack:
            return self.stack[-1][0]
        else:
            return None
        

    def getMin(self) -> int:
        if self.stack:
            return self.stack[-1][1]
        else:
            None