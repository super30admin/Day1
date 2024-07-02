class MyHashSet:

    def _hash_func(self, value):
        return value % self.SIZE
    
    def _pos(self,value):
        return value // self.SIZE

    def __init__(self):
        self.SIZE = 1000
        self.data = [None] * self.SIZE
        # print(f"data:{data[:5]}  datasize:{len(data)}")
        

    def add(self, key: int) -> None:
        # check if list is not there
        hashed_val = self._hash_func(key)
        if self.data[hashed_val] is None:
            self.data[hashed_val] = [False] * (self.SIZE + 1)
        self.data[hashed_val][self._pos(key)] = True
        return
        

    def remove(self, key: int) -> None:
        hashed_val = self._hash_func(key)
        if self.data[hashed_val] is None:
            return
        self.data[hashed_val][self._pos(key)] = False
        return
        

    def contains(self, key: int) -> bool:
        hashed_val = self._hash_func(key)
        if self.data[hashed_val] is None:
            return False
        return self.data[hashed_val][self._pos(key)]        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)