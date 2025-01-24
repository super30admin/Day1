# Time Complexity :0(1)
# Space Complexity :
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

class MinStack(object):

    def __init__(self):
        self.stack=[]
        self.min_stack=[]

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.stack.append(val)
        if len(self.min_stack)==0:
            self.min_stack.append(val)
        elif val<=self.min_stack[-1]:
            self.min_stack.append(val)
        

    def pop(self):
        if len(self.stack)>0:
            popped_val=self.stack.pop()
            if popped_val==self.min_stack[-1]:
                self.min_stack.pop()
        

    def top(self):
        if len(self.stack)>0:
            return self.stack[-1]
        else:
            print("stack is empty")

    def getMin(self):
        if len(self.min_stack)>0:
            return self.min_stack[-1]
        else:
            print("stack is empty")


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()