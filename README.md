Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

#Time Complexity : add(),remove(),contains():O(1)
#Space Complexity:O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Implementation of a hash set using a list of lists for collision handling.
# Utilizes a dynamic size array - where i can change it to store slots of key-value pairs, where each slot is a seperate list.
# Collisions are managed by appending keys to the respective bucket lists.

class MyHashSet(object):

    def __init__(self):
        self.size = 1000
        #Implemented hashset using a list of lists
        self.lists = [[] for i in range(self.size)]
    
    def _hash(self, key):
        return key % self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        #Adding a key to the hashset
        lists_idx = self._hash(key)
        list = self.lists[lists_idx]
        if key not in list:
            list.append(key)
        return "null"

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        list_idx = self._hash(key)
        list = self.lists[list_idx]
        if key in list:
            list.remove(key)
        return "null"

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        list_idx = self._hash(key)
        list = self.lists[list_idx]
        if key in list:
            return True
        else:
            return False

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
print(obj.add(40))
print(obj.add(60))
print(obj.remove(60))
print( obj.contains(40))
print(obj.contains(80))

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

#Time Complexity : push(),pop(),top(),getMin():O(1)
#Space Complexity:O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

#Implementing auxiliary stack to keep track of minimum values as elements are pushed and popped.
# Updates the minimum value on push and pop operation based on comparisons with the current top of the auxiliary stack

class MinStack(object):

    def __init__(self):
        #Initialize an auxiliary stack to store elements 
        self.aux_stack = []
        self.min_value = float('inf')

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        # If the new value is less than or equal to the current minimum value,push the current minimum value onto the auxillary stack first.
        if val <= self.min_value:
            self.aux_stack.append(self.min_value)
            self.min_value = val
        # Push the new value onto the stack.
        self.aux_stack.append(val)
        return "null"

    def pop(self):
        """
        :rtype: None
        """
        if self.aux_stack:
            top = self.aux_stack.pop()
            # If the popped value is the current minimum,update the minimum to the next value on the stack.
            if top == self.min_value:
                self.min_value = self.aux_stack.pop()
        return "null"

    def top(self):
        """
        :rtype: int
        """
        if not self.aux_stack:
            return None
        return self.aux_stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_value
    
# Your MinStack object will be instantiated and called as such:
obj = MinStack()
print(obj.push(60))
print(obj.push(80))
print(obj.getMin())
print(obj.push(100))
print(obj.pop())
print(obj.top())
print(obj.getMin())


