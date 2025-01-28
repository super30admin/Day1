# Approach: The MinStack stores tuples (x, current_min) in the stack. For each push, it calculates 
# the new minimum by comparing the current value (x) with the current minimum. 
# The stack's top always maintains the minimum value for easy retrieval.

# Time Complexity:
# push, pop, top, getMin: O(1) (constant time for all operations).
# Worst Case: Still O(1) for all operations, as no extra traversal or recalculation is needed.
# Space Complexity: O(n), where n is the number of elements in the stack, as the stack stores the value and 
# minimum for each element.
class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        if not self.stack:
            self.stack.append((x, x))
            return
        curr_min = self.stack[-1][1]
        self.stack.append((x, min(x, curr_min)))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()