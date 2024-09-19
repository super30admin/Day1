class MyHashSet(object):

    def __init__(self):
        self.primary_buckets = 1000
        self.secondary_buckets = 1000
        # creates a 2D array of size 1000
        self.storage = [[False] for _ in range(self.primary_buckets)]

    def get_primary_hash(self, key):  # Add 'self' as the first parameter
        return key % self.primary_buckets

    def get_secondary_hash(self, key):  # Add 'self' as the first parameter
        return key // self.secondary_buckets

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        # O(1) is the best time complexity and O(n) is the worst time complexity
        primary_index = self.get_primary_hash(key)
        if len(self.storage[primary_index]) == 1:
            if primary_index == 0:
                self.storage[primary_index] = [False] * (self.secondary_buckets + 1)
            else:
                self.storage[primary_index] = [False] * self.secondary_buckets
        secondary_index = self.get_secondary_hash(key)
        self.storage[primary_index][secondary_index] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        # O(1) is the best time complexity and O(1) is the worst time complexity
        primary_index = self.get_primary_hash(key)
        # If value of primary bucket at the above primary_index is empty, return
        if len(self.storage[primary_index]) == 1:
            return
        secondary_index = self.get_secondary_hash(key)
        self.storage[primary_index][secondary_index] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        # O(1) is the best time complexity and O(1) is the worst time complexity
        primary_index = self.get_primary_hash(key)
        # If value of primary bucket at the above primary_index is empty, return False
        if len(self.storage[primary_index]) == 1:
            return False
        secondary_index = self.get_secondary_hash(key)
        return self.storage[primary_index][secondary_index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
