# Time Complexity : O(1) for push, pop, top, getMin
# Space Complexity : O(2*size)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

import sys
class MinStack(object):
    size = 100

    def __init__(self):
        self.stack = []
        self.min = sys.maxsize

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """

        if val <= self.min:
            self.stack.append(self.min)
            self.min = val

        self.stack.append(val)

    def pop(self):
        """
        :rtype: None
        """
        popped = self.stack.pop()
        if popped == self.min:
            self.min = self.stack.pop()

    def top(self):
        """
        :rtype: int
        """

        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """

        return self.min

# obj = MinStack()
# obj.push(3)
# obj.push(5)
# obj.push(2)
# obj.push(1)
# print(obj.getMin())
# obj.pop()
# print(obj.getMin())
# obj.pop()
# obj.pop()
# print(obj.getMin())
