# Time Complexity : 0(1)
# Space Complexity : 0(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes Bit of Python and Java Confusion

class MyHashSet:

    def __init__(self):
        self.Array1_size = 1000 # defining size of primary array
        self.Array2_size = 1001 # defining size of secondary array
        self.Table = [None] * self.Array1_size # initializing array with None

    def Hash_1(self, key):
        return key % self.Array1_size # First Hash Function

    def Hash_2(self, key):
        return key // self.Array2_size # Second Hash Function


    def add(self, key: int) -> None:
        primary_index = self.Hash_1(key)
        secondary_index = self.Hash_2(key)
        if self.Table[primary_index] is None:
            self.Table[primary_index] = [False] * self.Array2_size
        self.Table[primary_index][secondary_index] = True
    
    def remove(self, key: int) -> None:
        primary_index = self.Hash_1(key)
        secondary_index = self.Hash_2(key)
        if self.Table[primary_index] is not None:
            self.Table[primary_index][secondary_index] = False


    def contains(self, key: int) -> bool:
        primary_index = self.Hash_1(key)
        secondary_index = self.Hash_2(key)
        if self.Table[primary_index] is not None and self.Table[primary_index][secondary_index] is not False:
            return True
        else:
            return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)