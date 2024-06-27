# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets
    
    def getBucket(self,key):
        return key % self.buckets

    def getBucketItem(self,key):
        return key // self.buckets

    # works in TC O(1)    
    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.buckets + 1) # 0 to 1000 -> if key is 1000000
            else:
                self.storage[bucket] = [None] * self.buckets  # 0 to 999
        self.storage[bucket][bucketItem] = True
        
    #works in TC O(1)    
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False

    # works in TC O(1)    
    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem] == True

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)