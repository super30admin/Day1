# Time Complexity : 
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        # Initialize an array of size 1,000,001 with all elements as False
        self.size = 1000001
        self.set = [False] * self.size
        
    def add(self, key: int) -> None:
        # Mark the index corresponding to key as True
        self.set[key] = True

    def remove(self, key: int) -> None:
        # Mark the index corresponding to key as False
        self.set[key] = False

    def contains(self, key: int) -> bool:
        # Return the value at the index corresponding to key
        return self.set[key]