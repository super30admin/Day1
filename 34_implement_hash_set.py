# Time Complexity -
#     add() - O(1)
#     remove() - O(1)
#     contains() - O(1)

# Space Complexity - O(10^6)

class MyHashSet:

    def __init__(self):
        self.primary_size = 1000 # upper bound of sqrt(max #keys)
        self.secondary_size = 1000 # upper bound of sqrt(max #keys)
        self.storage = [None] * self.primary_size
    
    def hash1(self, key: int) -> int: # for primary array
        return key % self.primary_size
    
    def hash2(self, key: int) -> int: # for secondary array
        return key // self.secondary_size
        
    def add(self, key: int) -> None:
        f_val = self.hash1(key)
        s_val = self.hash2(key)
        if self.storage[f_val] == None:
            if f_val == 0: # only to take care of the 10^6th key, gives index out of range otherwise
                self.storage[f_val] = [False] * (self.secondary_size + 1)
            else:
                self.storage[f_val] = [False] * self.secondary_size
        self.storage[f_val][s_val] = True

    def remove(self, key: int) -> None:
        f_val = self.hash1(key)
        s_val = self.hash2(key)
        if self.storage[f_val] == None:
            return
        self.storage[f_val][s_val] = False
        

    def contains(self, key: int) -> bool:
        f_val = self.hash1(key)
        s_val = self.hash2(key)
        if self.storage[f_val] == None:
            return False
        return self.storage[f_val][s_val]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)