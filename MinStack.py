# Time Complexity O(1) for all
import math


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.current_min = math.inf
        self.min_stack.append(self.current_min)

    def push(self, val: int) -> None:
        self.stack.append(val)
        if val <= self.current_min:
            self.min_stack.append(val)
            self.current_min = val
        else:
            self.min_stack.append(self.current_min)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()
        self.current_min = self.peek(self.min_stack)

    def top(self) -> int:
        return self.peek(self.stack)

    def getMin(self) -> int:
        return self.current_min

    def peek(self, st: []) -> int:
        if st:
            return st[-1]


# Your MinStack object will be instantiated and called as such:
#obj = MinStack()
#obj.push(4)
#obj.push(5)
#obj.push(3)
#obj.push(3)
#obj.push(7)
#obj.pop()
#obj.pop()
#param_3 = obj.top()
#param_4 = obj.getMin()
#print(param_3)
#print(param_4)
