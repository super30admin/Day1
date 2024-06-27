# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MinStack:

    #time comp = O(1) , space comp = O(n)
    def __init__(self):
        self.stack = []
        self.minStack = []
        self.Min = int(sys.maxsize)
        self.minStack.append(self.Min)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.Min = val
        self.stack.append(val) #push val in stack
        self.minStack.append(self.Min) #push min value in min stack

        

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()
        self.Min = self.minStack[-1]

    def top(self) -> int:
        return self.stack[-1]

        
    def getMin(self) -> int:
        return self.Min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()




#--------------Another way using only 1 stack-----------------
class MinStack:

    #all operations time comp = O(1) , space comp = O(n) but space used could be less that first approach
    def __init__(self):
        self.stack = []
        self.Min = int(sys.maxsize)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.stack.append(self.Min)
            self.Min = val
        self.stack.append(val) #push val in stack


    def pop(self) -> None:
        popped = self.stack.pop()
        if popped == self.Min:
            self.Min = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

        
    def getMin(self) -> int:
        return self.Min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()