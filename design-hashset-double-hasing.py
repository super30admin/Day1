'''
Time Complexity : O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes(#705)
Any problem you faced while coding this : No. Was using the double hasing technique per lecture instead of channing using Linked List/ BST.
'''
import math

class MyHashSet:

    def __init__(self):
        self.maxSize = int(math.sqrt(10**6))
        self.storage = [None] * self.maxSize

    def _bucketHash(self, key):
        return key % self.maxSize

    def _bucketItemHash(self, key):
        return key // self.maxSize

    def add(self, key: int) -> None:
        bucket = self._bucketHash(key)
        if not self.storage[bucket]:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.maxSize + 1) # since key contraint is 0 to 10^6 which means (1M + 1) keys.
            else:
                self.storage[bucket] = [False] * (self.maxSize)
        bucketItem = self._bucketItemHash(key)
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self._bucketHash(key)
        bucketItem = self._bucketItemHash(key)
        if self.storage[bucket]:
            self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self._bucketHash(key)
        bucketItem = self._bucketItemHash(key)
        if not self.storage[bucket]:
            return False
        return self.storage[bucket][bucketItem] == True

# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(10)
obj.add(20)
obj.add(30)
obj.remove(20)
print(obj.contains(20))
print(obj.contains(30))