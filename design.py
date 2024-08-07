# Time Complexity : o(1)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class MyHashSet(object):

    def __init__(self):
        self.set = set()
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.set.add(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.set.discard(key)
    

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        return key in self.set


# Problem 2

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class MinStack(object):

    def __init__(self):
        self.stack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if not self.stack:
            self.stack.append((val, val))
        else:
            current_min = self.stack[-1][1]
            self.stack.append((val, min(val, current_min)))
        

    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1][0]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

