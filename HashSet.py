class MyHashSet:

    def __init__(self):
        # simulating hashset using a dictionary and initialising it
        self.d = {}

    def add(self, key: int) -> None:
        # assigns the value 1 for the element inserted.
        # time complexity: O(1)
        self.d[key] = 1

    def remove(self, key: int) -> None:
        # assigns value 0 to key saying the value is deleted from dictionary
        # time complexity: O(1)
        self.d[key] = 0

    def contains(self, key: int) -> bool:
        # checks if the key exists in dictionary by vefirying if its value is not equal to 0
        # time complexity: O(1)
        return self.d.get(key,0)!=0
    



obj = MyHashSet()
while True:
    print('add <value>')
    print('remove <value>')
    print('contains <value>')
    print("quit")
    ip = input('What would you like to do? ').split()
    op = ip[0].strip().lower()
    if op == "add":
        obj.add(int(ip[1]))
    elif op == "remove":
        obj.remove(int(ip[1]))
    elif op == "contains":
        res = obj.contains(int(ip[1]))
        print(res)
    elif op == "quit":
        break