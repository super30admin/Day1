'''
Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes(#155)
Any problem you faced while coding this : No. Was using the space optmizied 2 stk technique per lecture.
'''
class MinStack:

    def __init__(self):
        self.min = float('inf')
        self.stk = []
        self.minStk = []

    def push(self, val: int) -> None:
        if self.min >= val:
            self.minStk.append(self.min)
            self.min = val
        self.stk.append(val)

    def pop(self) -> None:
        poppedVal = self.stk.pop()
        if poppedVal == self.min:
            self.min = self.minStk.pop()

    def top(self) -> int:
        return self.stk[-1]

    def getMin(self) -> int:
        return self.min

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(10)
obj.push(20)
obj.push(5)
obj.push(7)
obj.push(1)
obj.pop()
print(obj.top())
print(obj.getMin())
obj.pop()
obj.pop()
print(obj.getMin())