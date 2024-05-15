"""
Time Complexity: O(1)
Space Complexity: O(n)
Did this run on leetcode.com: Yes
approach: the idea is to keep a running track of the minimum with a min variable AND a min stack, with every push to the og stack i also push the 
current min to the min stack and with every pop i pop the og stack and the min stack and then update the min variable with peeking the min stack
Things to remember:
1. dont forget to update the min variable after popping both stacks
"""

class MinStack:

    def __init__(self):
        self.min = float('inf')
        self.stack = []
        self.min_stack = [self.min]
        

    def push(self, val: int) -> None:
        if val <= self.min:
            self.min = val
        self.min_stack.append(self.min)
        self.stack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()
        self.min = self.min_stack[-1]

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min