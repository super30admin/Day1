# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

class MyHashSet:

    def __init__(self):
        # Initialize an array of size 1,000,001 with all elements as False
        self.size = 1000001
        self.set = [False] * self.size
        
    def add(self, key: int) -> None:
        # Mark the index corresponding to key as True
        self.set[key] = True

    def remove(self, key: int) -> None:
        # Mark the index corresponding to key as False
        self.set[key] = False

    def contains(self, key: int) -> bool:
        # Return the value at the index corresponding to key
        return self.set[key]
    

# Time Complexity : o(1)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class MyHashSet:
    def __init__(self):
        # Create a list of buckets, each bucket is a list (initially empty)
        self.bucket_size = 1000
        self.buckets = [[] for _ in range(self.bucket_size)]

    def hash(self, key: int) -> int:
        # Hash function to determine which bucket a key goes to
        return key % self.bucket_size   

    def add(self, key: int) -> None:
        # Find the appropriate bucket for the key
        bucket = self.buckets[self.hash(key)]
        if key not in bucket:
            bucket.append(key)

    def remove(self, key: int) -> None:
        # Find the appropriate bucket for the key
        bucket = self.buckets[self.hash(key)]
        # Remove the key if it exists in the bucket
        if key in bucket:
            bucket.remove(key)

    def contains(self, key: int) -> bool:
        # Find the appropriate bucket for the key and check for existence
        bucket = self.buckets[self.hash(key)]
        return key in bucket