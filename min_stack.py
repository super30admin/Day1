class MinStack(object):

    def __init__(self):
        self.st = []
        self.min_st = []
        self.min = float("inf")
        # current/initial previous minimum is infinity
        self.min_st.append(self.min)

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        # find minimum of previous minimum in min_St and current inserted value and append it to the min_st stack
        self.min = min(self.min, val)
        self.st.append(val)

        self.min_st.append(self.min)

    def pop(self):
        """
        :rtype: None
        """
        # pop from st and min_st and update minimum to previous min which is on tos
        if self.st:
            self.st.pop()
            self.min_st.pop()
            self.min = self.min_st[-1]

    def top(self):
        """
        :rtype: int
        """
        # if there is something in the stack return it else None
        if self.st:
            return self.st[-1]
        return None

    def getMin(self):
        """
        :rtype: int
        """
        # return the min current minimum value
        return self.min


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(5)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()
print(param_3, param_4)

# Above driver code returns None

# time complexity of push(),pop(),top() and getMin() is all O(1)
