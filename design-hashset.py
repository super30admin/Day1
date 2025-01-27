# tc O(1), sc O(1).
class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets

    def hash_level_1(self, key):
        return key % self.buckets

    def hash_level_2(self, key):
        return key // self.bucketItems

    def add(self, key):
        bucketIndex = self.hash_level_1(key)
        if self.storage[bucketIndex] is None:
            self.storage[bucketIndex] = [False] * (self.bucketItems + (1 if bucketIndex == 0 else 0))
        bucketItemIndex = self.hash_level_2(key)
        self.storage[bucketIndex][bucketItemIndex] = True

    def remove(self, key):
        bucketIndex = self.hash_level_1(key)
        if self.storage[bucketIndex] is not None:
            bucketItemIndex = self.hash_level_2(key)
            self.storage[bucketIndex][bucketItemIndex] = False

    def contains(self, key):
        bucketIndex = self.hash_level_1(key)
        if self.storage[bucketIndex] is not None:
            bucketItemIndex = self.hash_level_2(key)
            return self.storage[bucketIndex][bucketItemIndex]
        return False