class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None]*self.buckets

    def getbucket(self, key: int) -> int:
        return key%self.buckets

    def getbucketitems(self, key: int) -> int:
        return key//self.bucketitems

    def add(self, key: int) -> None:
        bucket = self.getbucket(key)
        bucketitem = self.getbucketitems(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [None]*(self.bucketitems+1)
            else:
                self.storage[bucket] = [None]*self.bucketitems
        self.storage[bucket][bucketitem] = True

    def remove(self, key: int) -> None:
        bucket = self.getbucket(key)
        bucketitem = self.getbucketitems(key)
        if self.storage[bucket] is not None:
            self.storage[bucket][bucketitem] = None
        return

    def contains(self, key: int) -> bool:
        bucket = self.getbucket(key)
        bucketitem = self.getbucketitems(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucketitem] is True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)