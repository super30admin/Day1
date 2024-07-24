class MyHashSet(object):
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [-1]*1001

    def getBuckets(self, key):
        return key / self.bucketItems

    def getBucketItems(self, key):
        return key % self.buckets

    def add(self, key):
        bucket = self.getBuckets(key)
        bucketItem = self.getBucketItems(key)
        if self.storage[bucket] == -1:
            self.storage[bucket] = [-1]*1000
        self.storage[bucket][bucketItem] = key

    def remove(self, key):
        bucket = self.getBuckets(key)
        bucketItem = self.getBucketItems(key)
        if self.contains(key):
            self.storage[bucket][bucketItem] = -1


    def contains(self, key):
        bucket = self.getBuckets(key)
        bucketItem = self.getBucketItems(key)
        if self.storage[bucket] != -1 and self.storage[bucket][bucketItem] == key:
            return True
        else:
            return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)