// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class MinStack:

    def __init__(self):
        self.stack = []
        self.min = float('inf')
        self.stack.append(float('inf'))

    def push(self, val: int) -> None:
        if(val<= self.min):
            self.stack.append(self.min)
            self.stack.append(val)
            self.min = val
        else:
            self.stack.append(val)

    def pop(self) -> None:
        if(self.stack[-1] == self.min):
            self.stack.pop()
            self.min =self.stack[-1]
            self.stack.pop()
        else:
            self.stack.pop()

        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
