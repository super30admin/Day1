# Time Complexity:
# add: O(1) on average, but O(n) in the worst case when resizing is required.
# remove: O(1) on average, but O(n) in the worst case when resizing is required.
# contains: O(1) on average, but O(n) in the worst case due to hash collisions.
# 
# Space Complexity: O(n), where n is the number of keys stored in the HashSet.
# 
# Did this code successfully run on Leetcode: Yes
# 
# Any problem you faced while coding this: Handling hash collisions using chaining needed some careful thought.

class MyHashSet(object):
    
    def __init__(self):
        # Initialize a fixed-size array to store the buckets. Each bucket is a list (for chaining).
        self.size = 1000  # Choosing 1000 as the base size for simplicity.
        self.buckets = [[] for _ in range(self.size)]
    
    def _hash(self, key):
        # Simple hash function to map the key to a bucket index.
        return key % self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket_idx = self._hash(key)  # Get the bucket index.
        bucket = self.buckets[bucket_idx]
        
        if key not in bucket:  # Only add if the key is not already present.
            bucket.append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket_idx = self._hash(key)  # Get the bucket index.
        bucket = self.buckets[bucket_idx]
        
        if key in bucket:  # Remove the key if it exists.
            bucket.remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket_idx = self._hash(key)  # Get the bucket index.
        bucket = self.buckets[bucket_idx]
        
        return key in bucket  # Check if the key exists.

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

# Example usage:
myHashSet = MyHashSet()
myHashSet.add(1)      # set = [1]
myHashSet.add(2)      # set = [1, 2]
print(myHashSet.contains(1))  # return True
print(myHashSet.contains(3))  # return False (not found)
myHashSet.add(2)      # set = [1, 2] (2 already exists)
print(myHashSet.contains(2))  # return True
myHashSet.remove(2)   # set = [1]
print(myHashSet.contains(2))  # return False (already removed)
