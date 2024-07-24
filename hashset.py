''' initializing a list with 10 elements i.e. False. In add function we are changing the value to True, to show that at that index/key the value 
has been added. In remove we are removing an element from the same key or index. In contains function we are just returning the key.
'''
class MyHashSet:

    def __init__(self):
        self.data = [False]*10
        

    def add(self, key: int) -> None:
        self.data[key]=True
        return self.data
        

    def remove(self, key: int) -> None:
        self.data[key]=False
        return self.data

    def contains(self, key: int) -> bool:
        return self.data[key]
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
print(obj.add(4))
print(obj.add(4))
print(obj.add(6))
print(obj.add(7))
print(obj.remove(7))
param_3 = obj.contains(6)
print(param_3)