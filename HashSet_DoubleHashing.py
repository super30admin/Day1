# Time Complexity = O(1)
# Space Complexity = O(1)


class MyHashSet:

    def __init__(self):
        self.primary_buckets = 1000
        self.secondary_buckets = 1000
        self.arr = [None for i in range(self.primary_buckets)]

    def get_primary_hash(self, key: int):
        return key % self.primary_buckets

    def get_secondary_hash(self, key: int):
        return int(key / self.secondary_buckets)

    def add(self, key: int) -> None:
        primary_hash = self.get_primary_hash(key)
        if (self.arr[primary_hash] is None):
            if (primary_hash == 0):
                self.arr[primary_hash] = [False for i in range(self.secondary_buckets + 1)]
            else:
                self.arr[primary_hash] = [False for i in range(self.secondary_buckets)]

        secondary_hash = self.get_secondary_hash(key)
        self.arr[primary_hash][secondary_hash] = True

    def remove(self, key: int) -> None:
        primary_hash = self.get_primary_hash(key)
        if self.arr[primary_hash] is None:
            return
        secondary_hash = self.get_secondary_hash(key)
        self.arr[primary_hash][secondary_hash] = False

    def contains(self, key: int) -> bool:
        primary_hash = self.get_primary_hash(key)
        if self.arr[primary_hash] is None:
            return False
        secondary_hash = self.get_secondary_hash(key)
        return self.arr[primary_hash][secondary_hash]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(500)
# obj.remove(200)
# param_3 = obj.contains(200)
# print(param_3)