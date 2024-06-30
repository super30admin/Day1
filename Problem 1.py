# using the simplest approach and defined a 2D arrays
# using remainder and quotient as indexes of repective arrays
# this ensures O(1) time and space complexity.

class MyHashSet:

    def __init__(self):
        self.primary = 1000
        self.secondary = 1000
        self.storage = [None]*self.primary
        
    def getprimary(self,  key: int) -> int:
        return key % self.primary

    def getsecondary(self,  key: int) -> int:
        return key // self.secondary

    def add(self, key: int) -> None:
        p = self.getprimary(key)
        s = self.getsecondary(key)
        if self.storage[p] == None:
            if p == 0:
                self.storage[p] = [None]*(self.secondary + 1)
            else:
                self.storage[p] = [None]*self.secondary
        self.storage[p][s] = True

    def remove(self, key: int) -> None:
        p = self.getprimary(key)
        s = self.getsecondary(key)
        if self.storage[p] == None:
            return
        else:
           self.storage[p][s] = False

    def contains(self, key: int) -> bool:
        p = self.getprimary(key)
        s = self.getsecondary(key)
        if self.storage[p] == None:
            return False
        return self.storage[p][s] == True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)