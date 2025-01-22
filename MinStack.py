# Time Complexity : O(1) for push, pop, top, and getMin operations
# Space Complexity : O(n) where n is the number of elements in the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No issues faced during implementation

# The MinStack class implements a stack with a min-tracking feature.
# It uses two stacks: one for the main stack and one for the min values.
# The currentMin is updated whenever a new minimum value is pushed onto the stack.
# When popping an element, if it matches the currentMin, the minStack is popped to update the currentMin.

class MinStack:
    def __init__(self):
        self.stack = []
        self.minStack = []
        self.currentMin = float('inf')

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.currentMin >= val:
            self.minStack.append(self.currentMin)
            self.currentMin = val

    def pop(self) -> None:
        popped = self.stack.pop()
        if self.currentMin == popped:
            self.currentMin = self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.currentMin
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()