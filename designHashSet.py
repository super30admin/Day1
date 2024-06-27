class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketLists = 1000
        self.storage = [None] *self.buckets
        

    def getBucket(self,key: int) -> int:
        return key % self.buckets
    
    def getBucketItem(self, key: int) -> int:
        return key // self.bucketLists

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None]*(self.bucketLists+1)
            else:
                self.storage[bucket] = [None] *self.bucketLists
        self.storage[bucket][bucketItem] = True

        

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False
        

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
