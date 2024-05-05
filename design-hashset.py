# Link to problem : https://leetcode.com/problems/design-hashset/
# 

class MyHashSet:

    def __init__(self):
        self.myl = []

    def add(self, key: int) -> None:
        if not key in self.myl:
            self.myl.append(key)
        
    def remove(self, key: int) -> None:
        if key in self.myl:
            self.myl.remove(key)

    def contains(self, key: int) -> bool:
        return key in self.myl
        