# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack(object):

    def __init__(self):
        self.stack = []

        # Python initialization of infinite number is float('inf). Assign infinity number as min.
        self.min = float('inf')
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()
        
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min
        


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
param_3 = obj.getMin()
print(param_3)

obj.pop()
param_5 = obj.top()
print(param_5)

param_4 = obj.getMin()
print(param_4)