class MyHashSet:

    def __init__(self):
        self.buckets = 1000  # initial array size
        self.bucketItems = 1000  # each item array size
        self.storage = [None] * self.buckets

    def get_hash1(self, key: int) -> int:
        return key % self.buckets

    def get_hash2(self, key: int) -> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        hash1 = self.get_hash1(key)
        hash2 = self.get_hash2(key)
        if self.storage[hash1] == None:
            if hash1 == 0:
                self.storage[hash1] = [None] * (self.bucketItems + 1)
            else:
                self.storage[hash1] = [None] * self.bucketItems
        self.storage[hash1][hash2] = key

    def remove(self, key: int) -> None:
        hash1 = self.get_hash1(key)
        hash2 = self.get_hash2(key)
        if self.storage[hash1] == None:
            return

        self.storage[hash1][hash2] = None

    def contains(self, key: int) -> bool:
        hash1 = self.get_hash1(key)
        hash2 = self.get_hash2(key)
        if self.storage[hash1] == None:
            return False
        if self.storage[hash1][hash2] == None:
            return False
        else:
            return True

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)