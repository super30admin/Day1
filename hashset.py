class MyHashSet:

    def __init__(self):
        self.firstHash = 1001
        self.secondHash = 1001
        self.storage = [None]*self.firstHash

    def hash1(self,key):
        return key%self.firstHash
    def hash2(self,key):
        return key//self.firstHash
    def add(self, key: int) -> None:

        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if not self.storage[hash1]:
            self.storage[hash1]=[False]*self.secondHash
            
        self.storage[hash1][hash2]= True
        return

    def remove(self, key: int) -> None:
        
        hash1 = self.hash1(key)
        if self.storage[hash1]:
            hash2 = self.hash2(key)
            self.storage[hash1][hash2] = False
        
        return

    def contains(self, key: int) -> bool:
        hash1 = self.hash1(key)
        hash2 = self.hash2(key)
        if self.storage[hash1]:

            return self.storage[hash1][hash2]
        
        else:
            return False
