'''
Time Complexity :
push : O(1)
pop : O(1)
top : O(1)
getMin : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

class MinStack(object):

    def __init__(self):
        self.stack=[]
        self.min_stack = []
        
    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if not self.min_stack or val<=self.min_stack[-1]:
            self.min_stack.append(val)
        

    def pop(self):
        """
        :rtype: None
        """
        if not self.stack:
            return None
        element = self.stack.pop()
        if element == self.min_stack[-1]:
            self.min_stack.pop()
        
        return element
        

    def top(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1]
        return None
        

    def getMin(self):
        """
        :rtype: int
        """
        if self.min_stack:
            return self.min_stack[-1]
        return None

        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()