class MyHashSet(object):
    # implemented s30 solution.
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def getBucket(self, key):
        return key % self.buckets

    def getBucketItems(self, key):
        return key / self.bucketItems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)
        


        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                self.storage[bucket] = [False] * self.bucketItems
        self.storage[bucket][bucketItem] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)        
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)
        if self.storage[bucket] == None:
            return False
        
        return self.storage[bucket][bucketItem]     


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(1)
# obj.add(2)
# obj.remove(1)
# param_3 = obj.contains(1)