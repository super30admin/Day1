class MyHashSet:

    def __init__(self):
        self.primaryBucket = 1001
        self.secondaryBucket = 1000
        self.storage = [False] * self.primaryBucket
    
    def primaryHash(self, key):
        return key // self.primaryBucket
    
    def secondaryHash(self, key):
        return key % self.secondaryBucket
    
    def add(self, key: int) -> None:
        ph = self.primaryHash(key)
        if self.storage[ph] == False:
            self.storage[ph] = [False]*self.secondaryBucket
        sh = self.secondaryHash(key)
        self.storage[ph][sh] = True

    def remove(self, key: int) -> None:
        ph = self.primaryHash(key)
        if self.storage[ph] == False:
            return
        sh = self.secondaryHash(key)
        self.storage[ph][sh] = False  

    def contains(self, key: int) -> bool:
        ph = self.primaryHash(key)
        if self.storage[ph] == False:
            return False
        sh = self.secondaryHash(key)
        return self.storage[ph][sh]  
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()

obj.add(10)
obj.add(20)
obj.add(100)
obj.remove(20)
param_3 = obj.contains(20)
print(param_3)