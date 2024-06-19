#705. Design HashSet

class MyHashSet:

    def __init__(self):
        self.hashset = {}
        
    def add(self, key: int) -> None: #time= O(1)
        self.hashset[key] = True

    def remove(self, key: int) -> None: #time = O(1)
        if key in self.hashset:
            del self.hashset[key]
        

    def contains(self, key: int) -> bool:
        return key in self.hashset
        