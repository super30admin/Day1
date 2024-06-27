#This MyHashSet class uses a defaultdict from the collections module to simulate a hash set. In the __init__ method, an empty defaultdict named mp is initialized to store keys, defaulting values to integers. The add method sets the value for a key to True, marking it as present in the set. The remove method sets the value to False, indicating removal. The contains method returns the boolean state of the key, signifying its presence. This implementation ensures average O(1) time complexity for add, remove, and contains operations. The space complexity is O(n), where n is the number of unique keys added, since each unique key requires space in the dictionary.

class MyHashSet:

    def __init__(self):
        self.mp=defaultdict(int)
        

    def add(self, key: int) -> None:
        self.mp[key]=True
        

    def remove(self, key: int) -> None:
        self.mp[key]=False

    def contains(self, key: int) -> bool:
        return self.mp[key]

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)