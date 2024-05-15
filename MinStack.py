"""
We have used a single stack approach to keep track on Minimum value in the stack. 
We handled duplicate values by pushing the both duplicate values to the stack and poping them twice during the pop operation 
All the operations have O(1) time complexity
This solution has O(n) space complexity

"""
class MinStack:

    def __init__(self):
        self.min = float('inf')
        self.stack = []
        

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:
        popped = self.stack.pop()
        if popped == self.min:
            self.min = self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        
