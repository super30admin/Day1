
""" 
Time Complexity : push/pop/top/getMin - O(1)
Space Complexity : push/pop/top/getMin - O(1) - Amortized
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
"""

class MinStack:

    def __init__(self):
        self.minStack = []
        self.minStackIdx = 0
        self.stack = []
        self.stackIdx = 0

    def push(self, val: int) -> None: 
        self.stack.append(val)
        self.stackIdx += 1
        # peek and check
        if len(self.minStack) == 0 or val <= self.minStack[self.minStackIdx - 1]:
            self.minStack.append(val)
            self.minStackIdx += 1

    def pop(self) -> None:
        # remove pop from both stacks
        val = self.stack.pop()
        self.stackIdx -= 1
        if val == self.minStack[self.minStackIdx - 1]:
            self.minStack.pop()
            self.minStackIdx -= 1        

    def top(self) -> int:
        return self.stack[self.stackIdx - 1]

    def getMin(self) -> int:
        return self.minStack[self.minStackIdx - 1]
