class MinStack(object):

    def __init__(self):
        self.stack = []
        self.minstack = []
        

    def push(self, val): 
        """
        :type val: int
        :rtype: None
        """
        if len(self.minstack) > 0:
            if val <= self.minstack[-1]:
                self.minstack.append(val)
        if len(self.stack) == 0:
            self.minstack.append(val)
        self.stack.append(val)
        return

    def pop(self):
        """
        :rtype: None
        """
        if self.stack[-1] <= self.minstack[-1]:
            self.minstack.pop()
        self.stack.pop()
        return
                

    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) >0: return self.stack[-1]


    def getMin(self):
        """
        :rtype: int
        """
        return self.minstack[-1]


# Your MinStack object will be instantiated and called as such:
#obj = MinStack()
#obj.pop()
#param_3 = obj.top()
#print(param_3)
#param_4 = obj.getMin()
#print(param_4)