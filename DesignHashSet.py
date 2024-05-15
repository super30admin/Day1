# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class DesignHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * self.buckets # Creates a list of size buckets of all nulls

    def getBucket(self, val): # First hashing function
        return val % self.buckets

    def getBucketItem(self, val): # Second hashing function
        return val // self.bucketItems

    def add(self, val):
        # Compute the hash keys for the corresponding value
        bucket = self.getBucket(val)
        bucketItem = self.getBucketItem(val)
        if self.storage[bucket] is None: # If the bucket is empty
            if bucket == 0:
                self.storage[bucket] = [False] * (self.bucketItems + 1) # For bucket 0, create a list of booleans of size bucketItems+1 to handle the final element (10^6)
            else:
                self.storage[bucket] = [False] * self.bucketItems # For other buckets, create a list of booleans of size bucketItems
        self.storage[bucket][bucketItem] = True # Set the particular slot to true

    def remove(self, val):
        # Compute the hash keys for the corresponding value
        bucket = self.getBucket(val)
        bucketItem = self.getBucketItem(val)
        if self.storage[bucket] is None:
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, val):
        # Compute the hash keys for the corresponding value
        bucket = self.getBucket(val)
        bucketItem = self.getBucketItem(val)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucketItem]

# Example usage : 
hash_set = DesignHashSet()
hash_set.add(1)
hash_set.add(2)
hash_set.add(1)
print(hash_set.contains(3))  # Output: False
hash_set.add(3)
hash_set.add(1000000)
print(hash_set.contains(1))  # Output: True
print(hash_set.contains(1000000))  # Output: True
hash_set.remove(2)
print(hash_set.contains(2))  # Output: False
