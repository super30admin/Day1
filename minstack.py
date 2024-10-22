# Time Complexity : push - O(1), pop - O(1), top - O(1), getMin - O(1)
# Space Complexity :
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
# Instantiate two stacks, one to store all vals and another one to store the minimum vals for every push

class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        self.min = float('inf')

    def push(self, val: int) -> None:
        if self.min > val:
            self.min = val
        self.minstack.append(self.min)
        self.stack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
        if len(self.minstack) == 0:
            self.min = float('inf')
        else:
            self.min = self.minstack[-1]

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minstack[-1]
