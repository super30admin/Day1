class MyHashSet(object):
    
    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None] * self.buckets
    
    def primaryHash(self, key):
        return key % self.buckets
    
    def secondaryHash(self, key):
        return key // self.bucketitems

    def add(self, key):
        bucket = self.primaryHash(key)
        bucketItem = self.secondaryHash(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketitems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketitems
        self.storage[bucket][bucketItem] = True

    def remove(self, key):
        bucket = self.primaryHash(key)
        bucketItem = self.secondaryHash(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False
        

    def contains(self, key):
        bucket = self.primaryHash(key)
        bucketItem = self.secondaryHash(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)