class MyHashSet:
    def __init__(self):
        self.py_size = 1000  # py array size
        self.sy_size = 1000  # sy array size
        self.storage = [None] * self.py_size  # 2D Array

    # Create 2 hash functions
    def hash1(self, key):
        return key % self.py_size

    def hash2(self, key):
        return key // self.py_size

    def add(self, key):
        # get py and sy indices
        py_index = self.hash1(key)
        sy_index = self.hash2(key)

        # check if value at py index is null
        # if so, just assign a secondary array to it
        # otherwise go to the secondary array in that py index and do true in that sy_index
        if self.storage[py_index] is None:
            # edge case, if py_index is 0, need 1 extra space
            if py_index == 0:
                self.storage[py_index] = [False] * (self.sy_size + 1)
            else:
                self.storage[py_index] = [False] * self.sy_size
        self.storage[py_index][sy_index] = True

    def remove(self, key):
        # get py and sy index
        # see if value at py index is None, meaning no data to remove, just return
        # else, got to the sy index of sy array within py index and make it false
        py_index = self.hash1(key)
        sy_index = self.hash2(key)
        if self.storage[py_index] is None:
            return
        self.storage[py_index][sy_index] = False

    def contains(self, key):
        # find py and sy index
        py_index = self.hash1(key)
        sy_index = self.hash2(key)
        if self.storage[py_index] is None:
            return
        return self.storage[py_index][sy_index]


obj = MyHashSet()
obj.add(3)
obj.add(2)
obj.remove(3)
print(obj.contains(3))
