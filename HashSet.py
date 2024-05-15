"""
I have used double hashing technique to implement the HashSet. 
We will create two arrays named bucket and bucket_items 
The length of the buckets were taken as the square root of total size constaint of the problem 
We used modulas and division operator as a hash function 
"""
class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucket_items = 1000
        self.storage = [None]*self.bucket
        
    def get_bucket(self, key):
        return key % self.bucket 
    
    def get_bucket_item(self, key):
        return key // self.bucket_items
    
    def add(self, key: int) -> None:
        i = self.get_bucket(key)
        j = self.get_bucket_item(key)
        if self.storage[i] is None and i == 0:
            self.storage[i] = [False]*(self.bucket_items + 1)
        elif self.storage[i] is None :
            self.storage[i] = [False]*(self.bucket_items)
        self.storage[i][j] = True
        

    def remove(self, key: int) -> None:
        i = self.get_bucket(key)
        j = self.get_bucket_item(key)
        if self.storage[i] is not None:
            self.storage[i][j] = False

    def contains(self, key: int) -> bool:
        i = self.get_bucket(key)
        j = self.get_bucket_item(key)
        return self.storage[i] is not None and self.storage[i][j]
        