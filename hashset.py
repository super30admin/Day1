#Time Complexity : O(1)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No.

class MyHashSet:
    def __init__(self):
        self.buckets=1000
        self.bucketItems=1000
        self.storage = [None]* self.buckets

    def bucket(self, key):
        return key%self.buckets

    def bucketItem(self, key):
        return key//self.bucketItems

    def add(self, key: int) -> None:
        bucket=self.bucket(key)
        if not self.storage[bucket]:
            if bucket==0:
                self.storage[bucket]=[False]*(self.buckets+1)
            else:
                self.storage[bucket]=[False]*(self.buckets)
        bucketItem=self.bucketItem(key)
        self.storage[bucket][bucketItem]=True
        
    def remove(self, key: int) -> None:
        bucket=self.bucket(key)
        if not self.storage[bucket]:
            return
        bucketItem=self.bucketItem(key)
        self.storage[bucket][bucketItem]=False
        
    def contains(self, key: int) -> bool:
        bucket=self.bucket(key)
        if not self.storage[bucket]:
            return False
        bucketItem=self.bucketItem(key)
        return self.storage[bucket][bucketItem]