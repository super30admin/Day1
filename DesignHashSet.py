class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None] * self.buckets
        
    def getBucket(self, key):
        return key % self.buckets
    def getBucketItem(self, key):
        return key // self.bucketitems

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)

        if self.storage[bucket]!= None:
            if not self.storage[bucket][bucketItem]:
                self.storage[bucket][bucketItem] = True
        else:
            if bucket==0:
                self.storage[bucket] = [False] * 1001    
            else:
                self.storage[bucket] = [False] * self.bucketitems
            self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] and self.storage[bucket][bucketItem]:
            self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)

        if self.storage[bucket]:
            if self.storage[bucket][bucketItem]:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.remove(2)
print(obj.contains(1))