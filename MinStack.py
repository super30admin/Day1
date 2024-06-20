class MinStack(object):

    def __init__(self):
        self.st = []
        self.minSt = []
        self.min = float('inf')

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.min = min(self.min, val)
        self.st.append(val)
        self.minSt.append(self.min)
        

    def pop(self):
        self.st.pop()
        self.minSt.pop()
        self.min = self.minSt[-1] if self.minSt else float('inf')

    def top(self):
        return self.st[-1] if self.st else None
        

    def getMin(self):
        return self.min
    
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()