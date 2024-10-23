# The MinStack class defines a stack that can push, pop, and retrieve the minimum element efficiently. 
# It uses two lists: stack stores all the elements, and minStack keeps track of the minimum values. 
# Every time a new value is pushed, it is compared with the last minimum in minStack, updating minStack with the current overall minimum. 
# This ensures that the top of minStack always contains the minimum value of the stack up to that point. 
# Popping an element removes the top element from both stack and minStack, maintaining the integrity of the minimum values.

# TC: O(1) for all operations
# SC: O(n) where n is the number of elements in the stack

# Successful on Leetcode
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(val, self.minStack[-1] if self.minStack else val)
        self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]
