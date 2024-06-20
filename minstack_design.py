"""
Time Complexity: O(1)
Space Complexity: O(n)

"""

class MinStack:

    def __init__(self):
        self.stack = []
        self.minstack = []
        

    def push(self, val: int) -> None:
        self.stack.append(val)
        minvalue = min(val, self.minstack[-1] if self.minstack else val)
        self.minstack.append(minvalue)

        

    def pop(self) -> None:
        if self.stack:
            self.stack.pop() 

        if self.minstack:
            self.minstack.pop() 

        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minstack[-1]