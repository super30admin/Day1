# Problem 2:

# Time Complexity :
# push(): O(1)
# pop(): O(1)
# top(): O(1)
# getMin(): O(1)

# Space Complexity :
# push(): O(1)
# pop(): O(1) (Average Case)
# top(): O(1)
# getMin(): O(1)


# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : I followed class solution was able to understand and run it directly


class MinStack:

    def __init__(self):
        self.stack = []
        self. min = 2 **31 -1

    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:
        if self.stack.pop() == self.min:
            self.min = self.stack.pop()

    def top(self) -> int:
        if len(self.stack) < 1:
            return 0
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min
