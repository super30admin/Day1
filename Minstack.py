class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def hash1(self, key : int) -> int:
        return key % self.buckets

    def hash2(self, key : int) -> int:
        return key // self.bucketItems   

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems +1)
            else: 
                self.storage[bucket] = [False] * self.bucketItems
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem]
        