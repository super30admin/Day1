# Problem 1:

# Time Complexity :
# add(): O(1)
# remove(): O(1)
# contains(): O(1)

# Space Complexity :
# add(): O(N)
# remove(): O(1)
# contains(): O(1)

# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this : 
# I made a mistake of using the key recieved from hashing for primary index for secondary hashing function.
# Once I switched to using the value directly for both the hashing function I could solve all the test cases.



class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.hashset = [None] * self.size

    def add(self, key: int) -> None:
        index_prim = self.hasing_prim_func(key)
        index_second = self.hashing_secondary_func(key)
        if self.hashset[index_prim] is None:
            if index_prim == 0:
                self.hashset[index_prim] = [False] * (self.size + 1)
            else:    
                self.hashset[index_prim] = [False] * self.size
        self.hashset[index_prim][index_second] = True

    def remove(self, key: int) -> None:
        index_prim = self.hasing_prim_func(key)
        index_second = self.hashing_secondary_func(key)
        if self.hashset[index_prim] is not None:
            self.hashset[index_prim][index_second] = False

    def contains(self, key: int) -> bool:
        index_prim = self.hasing_prim_func(key)
        if self.hashset[index_prim] is None:
            return False
        index_second = self.hashing_secondary_func(key)
        return self.hashset[index_prim][index_second] 
    
    def hasing_prim_func(self, val: int) -> int:
        return val % self.size

    def hashing_secondary_func(self, val: int) -> int:
        return val // self.size
