# // Time Complexity : O(1)
# // Space Complexity : O(n2) worst case
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


class MinStack(object):

    def __init__(self):
        self.st = []
        self.minSt = []

    def push(self, val):
        if len(self.st) == 0:
            self.minSt.append(val)
        elif val <= self.getMin():
            self.minSt.append(val)
        self.st.append(val)
        # print("st",self.st)
        # print("minSt",self.minSt)

        
        
    def pop(self):
        if self.getMin() == self.top():
            self.minSt.pop()     
            p = self.st.pop()
            # print("st",self.st)
            # print("minSt",self.minSt)   
            return p
        else:
            return self.st.pop()
        

    def top(self):
        return self.st[len(self.st) - 1]

    def getMin(self):
        if len(self.minSt) != 0:
            return self.minSt[len(self.minSt) - 1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()