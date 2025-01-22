# Time Complexity : O(1) for add, remove, and contains operations on average
# Space Complexity : O(n) where n is the number of keys in the hash set. Specifically O(B + N) where B is the number of buckets and N is the number of keys in the hash set.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No issues faced during implementation

# The MyHashSet class implements a double hashing technique for efficient hash set operations.
# It uses a boolean array of buckets to store the presence of keys.
# Each bucket can hold multiple items using a list, allowing for efficient add, remove, and contains operations.

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.items = 1000
        self.hashSet = [None]*self.buckets

    def hashBucket(self, n):
        return n%self.buckets

    def hashItem(self, n):
        return n//self.items

    def add(self, key: int) -> None:
        bucket = self.hashBucket(key)
        if self.hashSet[bucket] is None:
            self.hashSet[bucket] = [False]*(self.items + (1 if bucket == 0 else 0))
        item = self.hashItem(key)
        self.hashSet[bucket][item] = True

    def remove(self, key: int) -> None:
        bucket = self.hashBucket(key)
        if self.hashSet[bucket] is None:
            return
        item = self.hashItem(key)
        self.hashSet[bucket][item] = False

    def contains(self, key: int) -> bool:
        bucket = self.hashBucket(key)
        if self.hashSet[bucket] is None:
            return False
        item = self.hashItem(key)
        return self.hashSet[bucket][item]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)