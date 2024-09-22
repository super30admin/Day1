# Solution:

# 1. Define two stacks one for reguler push and pop and another for tracking minimum
# 2. While pushing into minStack compare the previous minimum and upcoming value and push the minimum of them in MinStack.
# 3. Top of the MinStack will always give minimum value till the elements


class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minStack = []        

    def push(self, val):
        self.stack.append(val)
        val = min(self.minStack[-1] if self.minStack else val, val)
        self.minStack.append(val)
        

    def pop(self):
        self.stack.pop()
        self.minStack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()