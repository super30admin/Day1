# Complexity : for push,pop,top, getMin  time complexity is O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class MinStack:

    def __init__(self):
        # initialize
        self.stack = []
        self.minStack = []
        self.min = None

    def push(self, val: int) -> None:
        
        # if min is none then assign val as min
        if self.min is None:
            self.min = val
        # else if there is min and it is greater than val then push current min to minstack and val will become current min
        elif val <= self.min:
            self.minStack.append(self.min)
            self.min = val
        # min is resolved push val to stack
        self.stack.append(val)
        

    def pop(self) -> None:
        # if stack is not empty then pop
        if self.stack:
            num = self.stack.pop()
            if num == self.min and not self.minStack:
                self.min = None
            elif num == self.min:
                self.min = self.minStack.pop()

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        else:
            return -1

    def getMin(self) -> int:
        if self.min is not None:
            return self.min
        else:
            return -1
