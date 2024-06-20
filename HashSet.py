"""
- Uses a boolean list of size 1,000,001 to represent keys.
- `add` sets the index to `True`, and `remove` sets it to `False`.
- `contains` checks the boolean value at the index.


"""

class MyHashSet:

    def __init__(self):
        self.data = [False] * 1000001

    def add(self, key: int) -> None:
        self.data[key] = True
        

    def remove(self, key: int) -> None:
        self.data[key] = False

    def contains(self, key: int) -> bool:
        return self.data[key]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)