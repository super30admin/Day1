class MinStack(object):

    def __init__(self):
        #initialize teo stakes
        self.stack = []
        self.min_stack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        #push on to the stack
        self.stack.append(val)
        #push onto min stack if it is null or value less than 
        #or eual to current minimum
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        if self.stack:
            popped = self.stack.pop()

            # if pop value is current minimum than remove it
            #from the min stack as well
            if popped == self.min_stack[-1]:
                self.min_stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        #return top element from the stack
        return self.stack[-1] if self.stack else None

    def getMin(self):
        """
        :rtype: int
        """
        #return minimum element from th min_stack
        return self.min_stack[-1] if self.min_stack else None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()