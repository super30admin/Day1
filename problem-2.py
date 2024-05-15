# Time Complexity :

# push: O(1)
# pop: O(1)
# top: O(1)
# getMin: O(1)

# space complexity : O(n)

# Approach :

# Set initiailly the minimum as infinity
# In case of a push operation, if a new value is smaller than the current minimum, a new minimum set and the old minimum is pushed on the stack, and push the new value in the stack.
# In case of pop, if the minimum is equal to the popped element, then pop twice and make the second popped element as min. Else, just pop the top element


class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')

    def push(self, val: int) -> None:

        if (val <= self.min):
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:

        poppedItem = self.stack.pop()
        if (poppedItem == self.min):
            self.min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
