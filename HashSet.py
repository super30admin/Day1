"""
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
used the same approach as used in the class. Simply double hashing technique used. 
"""


class MyHashSet:
    def __init__(self):
        # Define and declare the 2 hash functions
        self.hash1 = 1000
        self.hash2 = 1000
        # Create an array of fixed size with Null pointers which serves as our main bucket
        self.main_bucket = [None] * self.hash1

    def add(self, key: int) -> None:
        main_bucket_index = (key % self.hash1)
        # Check if the secondary/nested bucket is NULL
        if self.main_bucket[main_bucket_index] is None:
            # If it is NULL, then check the edge case for the input input range
            if key == 1000000:
                self.main_bucket[main_bucket_index] = [False] * (self.hash2+1)
            else:
                self.main_bucket[main_bucket_index] = [False] * self.hash2

        secondary_bucket_index = (key // self.hash2)
        self.main_bucket[main_bucket_index][secondary_bucket_index] = True

    def remove(self, key: int) -> None:
        main_bucket_index = key % self.hash1
        secondary_bucket_index = key // self.hash2

        if self.main_bucket[main_bucket_index] and self.main_bucket[main_bucket_index][secondary_bucket_index]:
            self.main_bucket[main_bucket_index][secondary_bucket_index] = False

    def contains(self, key: int) -> bool:
        main_bucket_index = key % self.hash1
        secondary_bucket_index = key // self.hash2

        if not self.main_bucket[main_bucket_index] or not self.main_bucket[main_bucket_index][secondary_bucket_index]:
            return False

        return True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
