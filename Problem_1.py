# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

# Approach
# Create a list with len approximately equal to the squareroot of total elements
# For each index in the primary list, create a new list holding the elements in that range. This will avoid collision. 
# To optimize it further , save the elements in boolean form in the secondary list.

# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.storage = [None for _ in range(1000)]

    # Time Complexity : O(1)
    def add(self, key: int) -> None:
        idx1 = key % 1000
        idx2 = key//1000
            
        if self.storage[idx1] is None:
            if idx1 == 0:
                self.storage[idx1] = [False for _ in range(1001)]
            else:
                self.storage[idx1] = [False for _ in range(1000)]
        self.storage[idx1][idx2] = True

    # Time Complexity : O(1)    
    def remove(self, key: int) -> None:
        idx1 = key%1000
        idx2 = key // 1000
        if not self.storage[idx1]:
            return
        if self.storage[idx1][idx2] == True:
            self.storage[idx1][idx2] = False
    
    # Time Complexity : O(1)
    def contains(self, key: int) -> bool:
        idx1 = key%1000
        idx2 = key // 1000
        if not self.storage[idx1]:
            return False
        return self.storage[idx1][idx2]