# MyHashSet class uses a hash table with a fixed number of buckets (size = 1000). 
# Each bucket is a list to handle collisions via chaining. Keys are hashed using key % size to determine the bucket index, 
# and operations like add, remove, and contains are performed within the corresponding bucket.

# /*Time Complexity:
# The add, remove, and contains O(1)
# worst case O(n)
# Space Complexity: O(N + M)
class MyHashSet:
    def __init__(self):
        self.size = 1000
        self.buckets = [[]] * self.size

    def hash(self, key):
        return key % self.size

    def add(self, key: int) -> None:
        bucket_index = self.hash(key)
        if key not in self.buckets[bucket_index]:
            self.buckets[bucket_index].append(key)

    def remove(self, key: int) -> None:
        bucket_index = self.hash(key)
        if key in self.buckets[bucket_index]:
            self.buckets[bucket_index].remove(key)

    def contains(self, key: int) -> bool:
        bucket_index = self.hash(key)
        return key in self.buckets[bucket_index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)