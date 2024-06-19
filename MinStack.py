class MinStack(object):

    def __init__(self):
        # initialize 2 stacks, 1 normal and other min stack
        self.stack = []
        self.min_stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if len(self.min_stack) == 0:
            self.min_stack.append(val)
        elif self.min_stack[-1] < val:
            self.min_stack.append(self.min_stack[-1])
        else:
            self.min_stack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.min_stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_stack[-1]

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(10)
obj.push(1)
obj.push(20)
obj.pop()
obj.push(4)
obj.pop()
obj.push(3)
param_3 = obj.top()
print(param_3)
param_4 = obj.getMin()
print(param_4)