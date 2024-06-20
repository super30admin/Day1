"""
Time Complexity: O(1)
Space Complexity: O(n)
"""

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketitems = 1000
        self.storage = [None] * self.buckets 

    def hash_bucket(self,key):
        return key%self.buckets

    def hash_bucketitems(self,key):
        return key//self.bucketitems
        

    def add(self, key: int) -> None:
        hash1 = self.hash_bucket(key)  
        hash2 = self.hash_bucketitems(key)

        if self.storage[hash1] is None:
            if hash1 == 0:
                self.storage[hash1] = [False]*(self.bucketitems+1)   
            else:
                self.storage[hash1] = [False]*(self.bucketitems)

        self.storage[hash1][hash2] = True   


    def remove(self, key: int) -> None:
        hash1 = self.hash_bucket(key)
        hash2 = self.hash_bucketitems(key)

        if self.storage[hash1] is not None:
            self.storage[hash1][hash2] = False 
        

    def contains(self, key: int) -> bool:
        hash1 = self.hash_bucket(key)
        hash2 = self.hash_bucketitems(key)

        if self.storage[hash1] is not None:
            return self.storage[hash1][hash2]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)