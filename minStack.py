class MinStack:

    """
    Time Complexity = O(1)
    Space Complexity = O(n)
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    """

    def __init__(self):
        self.stack = [] # List to store the values 
        self.min_stack = [] # Stack to always store the Minimum value at the end of the List.

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.min_stack:
        # always checking whether the given val is less than last element of min_stack and then storing the minimum value at the end of the min_stack.
            val = min(self.min_stack[-1],val)
        self.min_stack.append(val)

    def pop(self) -> None:
        # removes the last element from the stacks
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        # Gets last value in the stack
        return self.stack[-1]

    def getMin(self) -> int:
        # Gets last value in the min_stack
        return self.min_stack[-1]