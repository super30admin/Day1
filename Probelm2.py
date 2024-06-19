class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        

    def push(self, val: int) -> None:
        """
        Time Complexity : O(1)
        Space Complexity :O(N + M) n is the main stack and m is the min stack

        """
        self.stack.append(val)
        min_val = min(val, self.min_stack[-1] if self.min_stack else val)
        self.min_stack.append(min_val)

    def pop(self) -> None:
        """
        Time Complexity : O(1)
        Space Complexity :O(N + M) n is the main stack and m is the min stack

        """
        self.stack.pop() if self.stack else None
        self.min_stack.pop() if self.min_stack  else None
    

    def top(self) -> int:
        """
        Time Complexity : O(1)
        Space Complexity :O(N + M) n is the main stack and m is the min stack

        """
        return self.stack[-1] if self.stack else None

    def getMin(self) -> int:
        """
        Time Complexity : O(1)
        Space Complexity :O(N + M) n is the main stack and m is the min stack

        """
        return self.min_stack[-1] if self.min_stack else None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()