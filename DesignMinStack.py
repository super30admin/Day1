# Time Complexity :O(1)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : difficulty in understanding storing tuples in stack
# This implementation uses a stack to store tuples containing the value and the minimum value at each stack level.
# The push operation updates the current minimum and stores it alongside the value, ensuring constant time retrieval of the minimum.
# The pop, top, and getMin operations all retrieve their respective values from the stack in constant time.

class MinStack:

    def __init__(self):
        # Initialize an empty list to store the stack elements and their corresponding minimum values
        self.array1 = []

    def push(self, val: int) -> None:
        # Determine the new minimum value
        if len(self.array1) == 0:
            min_val = val
        else:
            min_val = min(self.array1[-1][1], val) # The new minimum is the lesser of the current value and the last stored minimum
        # Append the value and the current minimum to the stack
        self.array1.append([val, min_val])

    def pop(self) -> None:
        # Remove the top element from the stack
        self.array1.pop()

    def top(self) -> int:
        # Return the top element's value
        return self.array1[-1][0]

    def getMin(self) -> int:
        # Return the current minimum value
        return self.array1[-1][1]
