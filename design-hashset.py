# Time Complexity : O(1) for add, remove, contains
# Space Complexity : O(10^6) for worst case
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyHashSet(object):

    def __init__(self):
        self.buckets = 1000
        self.bucket_items = 1000
        self.storage = [None] * 1000

    def first_hash_func(self, key):
        return key % self.buckets

    def second_hash_func(self, key):
        return key // self.bucket_items

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """

        r = self.first_hash_func(key)
        if self.storage[r] is None:
            if r == 0:
                self.storage[r] = [False] * (self.bucket_items + 1)
            else:
                self.storage[r] = [False] * self.bucket_items
        c = self.second_hash_func(key)
        self.storage[r][c] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        r = self.first_hash_func(key)
        if self.storage[r] is None: return
        c = self.second_hash_func(key)
        self.storage[r][c] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """

        r = self.first_hash_func(key)
        if self.storage[r] is None: return False
        c = self.second_hash_func(key)
        return self.storage[r][c]


# obj = MyHashSet()
# obj.add(2)
# obj.remove(3)
# status = obj.contains(2)
# print(status)
