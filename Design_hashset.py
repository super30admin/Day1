class MyHashSet:

    def __init__(self):
      self.bucket = 1000
      self.bucket_items = 1000
      self.storage = [None] * self.bucket
    
    def hash1(self, key: int) -> int:
      return key % self.bucket
    def hash2(self, key: int) -> int:
      return key // self.bucket_items   

    def add(self, key: int) -> None:
      bucket = self.hash1(key)
      bucket_items = self.hash2(key)
      if self.storage[bucket] == None:
        if bucket ==0 :
          self.storage[bucket] = [None] * (self.bucket_items+1)
        else :
          self.storage[bucket][bucket_items] = True
        

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucket_items = self.hash2(key)
        if self.storage[bucket] == None:
          return False
        return self.storage[bucket][bucket_items]

    def contains(self, key: int) -> bool:
      bucket = self.hash1(key)
      bucket_items = self.hash2(key)
      if self.storage[bucket] == None:
        return False
      return self.storage[bucket][bucket_items]

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)