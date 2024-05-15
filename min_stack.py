# Time Complexity : all the operations: push, pop, top, and getMin are O(1)
# Space Complexity : is O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None, although I want to optimize the function even further


# Your code here along with comments explaining your approach
# here we are using 2 stacks, the forst to store elements as is and the second to only keep track of min_values.
# using these 2 stacks we are able to solve the question

from collections import deque
class MinStack:

    def __init__(self):
        self.minstack = deque()
        self.s = deque()
        self.minstack.append(float('inf'))

    def push(self, val: int) -> None:
        if val < self.minstack[-1]:
            self.minstack.append(val)
        else:
            self.minstack.append(self.minstack[-1])
        
        self.s.append(val)

    def pop(self) -> None:

        if self.minstack[-1] != float('inf'):
            self.minstack.pop()
            self.s.pop()

    def top(self) -> int:
        if self.minstack[-1] != float('inf'):
            return self.s[-1]

    def getMin(self) -> int:
        return self.minstack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()