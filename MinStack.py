
"""
// Time Complexity : O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
used the same approach as used in the class.
"""


class MinStack:

    def __init__(self):
        self.main_stack = []
        self.min_stack = []
        self.cur_min = float('inf')

    def push(self, val: int) -> None:

        if self.cur_min >= val:
            self.min_stack.append(self.cur_min)
            self.cur_min = val
        self.main_stack.append(val)

    def pop(self) -> None:
        if self.cur_min == self.main_stack[-1]:
            self.cur_min = self.min_stack.pop()

        self.main_stack.pop()

    def top(self) -> int:
        return self.main_stack[-1]

    def getMin(self) -> int:
        return self.cur_min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
