# Time Complexity :O(1)
# Space Complexity :O(n+k) where n is the number of keys stored in the hash set and k is the number of buckets (which is 1000 in this case).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially had difficulty in using double hashing(array inside array) and module operator.


# Your code here along with comments explaining your approach
# This implementation uses an array of 1000 buckets (sublists) to store keys and handles collisions using chaining. 
# Each key is mapped to a bucket using the modulus operation (key % 1000) to distribute keys evenly across buckets. 
# The add, remove, and contains methods operate by checking the appropriate bucket for the presence of the key and performing the necessary operations.


class MyHashSet:
    def __init__(self):
        # Initialize the main storage array1 with 1000 empty sublists
        # Each sublist will act as a bucket to handle collisions using chaining
        self.array1 = [[] for i in range(1000)] 
        

    def add(self, key):
        # Compute the hash index by taking the modulus of the key with 1000. Use 1000 because that is max size
        subkey = key % 1000

        # Check if the key is already present to avoid duplicates
        if not self.contains(key):
            # Add the key to the appropriate bucket
            self.array1[subkey].append(key)

        

    def remove(self, key):
        subkey = key % 1000
         # Check if the key is present in the bucket
        if self.contains(key):
             # Remove the key from the bucket
            self.array1[subkey].remove(key)
        

    def contains(self, key):
        subkey = key % 1000
        # Check if the key is present in the bucket and return the result
        return key in self.array1[subkey]
    
    
hashset = MyHashSet()
hashset.add(1)
hashset.add(2)
print(hashset.contains(1))  # Output: True
print(hashset.contains(3))  # Output: False
hashset.add(2)
print(hashset.contains(2))  # Output: True
hashset.remove(2)
print(hashset.contains(2))  # Output: False