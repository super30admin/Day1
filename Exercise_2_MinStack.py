#  Time Complexity :   O(1) for push(), pop(), top(), getMin()
#  Space Complexity :   O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach

class MinStack(object):

    def __init__(self):
        self.minVal = 1E16   # max value
        self.numStack = []   # to push numbers
        self.minStack = []   # to push minimum number for each push()
        self.minStack.append(self.minVal)

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        # check if val is less than minVal, then update minVal
        if(val <= self.minVal):
            self.minVal = val

        # push minVal to minStack and val to numStack
        self.minStack.append(self.minVal)
        self.numStack.append(val)       

    def pop(self):
        """
        :rtype: None
        """
        self.numStack.pop()
        self.minStack.pop()

        #update minVal to be equal to top element of minStack
        self.minVal = self.minStack[-1]  


    def top(self):
        """
        :rtype: int
        """
        # here it is assumend we call top() only if numStack is not empty()
        return self.numStack[-1] 
        
        
    def getMin(self):
        """
        :rtype: int
        """
        return self.minVal
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()