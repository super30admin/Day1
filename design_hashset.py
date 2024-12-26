#  Time Complexity : O(1)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : Handling the edge case of bucket index 0.

#  Your code here along with comments explaining your approach
#  I used a list of lists to store the values. 
#  I used two helper functions to get the bucket index ( used % ) and the bucket item ( used // ).


class MyHashSet:


        def __init__(self):
            self.bucket_size = 1000
            self.bucket_items = 1000
            self.storage = [None] * self.bucket_size
        
        def get_bucket_index(self, key):
            return key % self.bucket_size
        
        def get_bucket(self, key):
            return key // self.bucket_size
        
        def add(self, key):
            bucket_index = self.get_bucket_index(key)
            bucket_item = self.get_bucket(key)
            if self.storage[bucket_index] == None:
                self.storage[bucket_index] = [False] * self.bucket_items
                if bucket_index == 0:
                    self.storage[bucket_index] = [False] * (self.bucket_items + 1)
                else:
                    self.storage[bucket_index] = [False] * self.bucket_items
            self.storage[bucket_index][bucket_item] = True

        
        def remove(self, key):
            bucket_index = self.get_bucket_index(key)
            bucket_item = self.get_bucket(key)
            if self.storage[bucket_index] == None:
                return
            self.storage[bucket_index][bucket_item] = False
                
        def contains(self, key):
            bucket_index = self.get_bucket_index(key)
            bucket = self.get_bucket(key)
            
            if self.storage[bucket_index] == None:
                return False
            return self.storage[bucket_index][bucket]