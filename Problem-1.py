#Approach

# to design the hashset i am using the dictionary and adding the elements

#Complexity

# Time Complexity : O(1)
# Space Complexity : O(N)



class MyHashSet:

    def __init__(self):
        self.hash = dict()

    def add(self, key: int) -> None:
        self.hash[key] = True

    def remove(self, key: int) -> None:
        if key in self.hash:
            del self.hash[key]

    def contains(self, key: int) -> bool:
        if key in self.hash:
            return True
        else:
            return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)