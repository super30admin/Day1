# Time Complexity : O(1) for push, pop, top, and min operation
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I missed few cases of duplicate values equal to the min value, then I rectified it. 
# Your code here along with comments explaining your approach:
    # - Used lists to implement stack.
    # - For the push operation, I am comparing the value to the min variable, and if it less than or equal to the min variable, then old min is pushed first and then the value is pushed.
    # - Else, I simply push the value in the stack.
    # - For the Pop Operation, we pop twice is top is min, else we just pop once
    # - Returning the last element of the list as the top element




import math
class MinStack(object):


    def __init__(self):
        self.stack = []
        self.min = math.pow(2,31)

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val <= self.min:
            # push old min
            self.stack.append(self.min)
            # push the new value
            self.stack.append(val)
            # update min
            self.min = val
        
        else:
            self.stack.append(val)
        

        

    def pop(self):
        """
        :rtype: None
        """
        top = self.stack[-1]
        if self.min == top:
            # pop twice, the second pop will be the old min
            self.stack.pop()
            self.min = self.stack.pop()

        else:
            # if the top element is not the min value, then just popping
            self.stack.pop() 
            

        

    def top(self):
        """
        :rtype: int
        """
        if self.stack:
            return self.stack[-1] # last element is the top element
        
        return -1;
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min # returning the min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()