"""
Using 1 stack (deque)
TC - O(1) for all 4 operations
SC - O(n)
"""
import sys
from collections import deque


class MinStack:

    def __init__(self):
        self.minstack = deque()
        self.minVal = sys.maxsize
        self.minstack.append(self.minVal)

    def push(self, val: int) -> None:
        if val <= self.minVal:
            self.minstack.append(self.minVal)
            self.minVal = val
        self.minstack.append(val)

    def pop(self) -> None:
        if len(self.minstack) != 0:
            if self.minstack.pop() == self.minVal:
                self.minVal = self.minstack.pop()

    def top(self) -> int:
        if len(self.minstack) != 0:
            return self.minstack[-1]
        return -1

    def getMin(self) -> int:
        return self.minVal


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(5)
obj.push(4)
print("Min val is: ", obj.getMin())
obj.push(3)
obj.push(10)
obj.pop()
print("Min val is: ", obj.getMin())
obj.push(0)
print("Min val is: ", obj.getMin())
obj.pop()
obj.pop()
obj.pop()
print("Min val is: ", obj.getMin())
print(obj.top())
